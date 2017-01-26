package com.ciberdix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ciberdix.model.Auditoria;
import com.ciberdix.model.AuditoriaRepository;
import com.ciberdix.model.LDAPUser;
import com.ciberdix.model.Usuarios;
import com.ciberdix.service.AuditoriaService;
import com.ciberdix.service.UsuariosService;



@CrossOrigin
@RestController
public class CiberdixDemoController {
	
	@Autowired
	UsuariosService usuariosService;
	@Autowired
	AuditoriaService auditoriaService;
	

	@RequestMapping(value = "/loginUsuario/", method = RequestMethod.POST, headers="Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LDAPUser> loginUsuario(@RequestBody LDAPUser ldapUser, UriComponentsBuilder ucBuilder) {
		System.out.println("Fetching User " + ldapUser);
		System.out.println("Fetching User with id " + ldapUser.getLdapUsername());
		Usuarios usuario = usuariosService.findByUsuarioSistema(ldapUser.getLdapUsername());
		if(usuario != null){
			auditoriaService.saveAuditoria("LDAP_CLIENT", usuario, ldapUser.getTimestamp());
    		auditoriaService.saveAuditoria("LDAP_SESSION_BACKEND", usuario);
		}
		boolean isAccepted = usuariosService.findInLdap(ldapUser.getLdapUsername(), ldapUser.getLdapPassword());
		if (isAccepted == false) {
			System.out.println("User with id " + ldapUser.getLdapUsername() + " not found");
			ldapUser.setAccepted(isAccepted);
			return new ResponseEntity<LDAPUser>(ldapUser, HttpStatus.NOT_FOUND);
		}
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(ucBuilder.path("/loginUsuario/{id}").buildAndExpand(id).toUri());
		ldapUser.setAccepted(isAccepted);
		return new ResponseEntity<LDAPUser>(ldapUser,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/auditoria/", method = RequestMethod.GET, headers="Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Auditoria>> listAllAuditorias() {
		List<Auditoria> auditorias = auditoriaService.findAllAuditorias();
		if(auditorias.isEmpty()){
			return new ResponseEntity<List<Auditoria>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Auditoria>>(auditorias, HttpStatus.OK);
	}	
	

}
