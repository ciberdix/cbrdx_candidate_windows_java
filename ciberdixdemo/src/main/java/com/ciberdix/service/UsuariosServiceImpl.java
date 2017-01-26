package com.ciberdix.service;

import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciberdix.model.AuditoriaRepository;
import com.ciberdix.model.Usuarios;
import com.ciberdix.model.UsuariosRepository;


import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

@Service("usuariosService")
@Transactional
public class UsuariosServiceImpl implements UsuariosService {

	@Autowired
	UsuariosRepository usuariosRepository;
	
	@Autowired
	AuditoriaService auditoriaService;
	
	public boolean findInLdap(String ldapUsername, String ldapPassword) {
		boolean resp = false;
		Hashtable env = new Hashtable(11);
		Usuarios usuario = findByUsuarioSistema(ldapUsername);
		
        String ldapAdServer = "ldap://ciberdix.eastus.cloudapp.azure.com:389";
        String ldapSearchBase = ldapUsername + "@ciberdix.eastus.cloudapp.azure.com";
        
        
        String Securityprinciple = ldapSearchBase;
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapAdServer);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, Securityprinciple);
        env.put(Context.SECURITY_CREDENTIALS, ldapPassword);  
        

        try {
            // Create initial context
        	if(usuario != null)
        		auditoriaService.saveAuditoria("LDAP_REQUEST", usuario);
        		
            DirContext ctx = new InitialDirContext(env);
        	if(usuario != null){
        		auditoriaService.saveAuditoria("LDAP_CONNECT", usuario);
        		auditoriaService.saveAuditoria("LDAP_SUCCESS", usuario);
        	}

            // Close the context when we're done
            resp = true;
            ctx.close();

        } catch (NamingException e) {
        	resp = false;
        }        
		return resp;
	}
	
	public Usuarios findByUsuarioSistema(String usuarioSistema) {
		Iterable<Usuarios> usuarios = usuariosRepository.findAll();
		for(Usuarios usuario : usuarios){
			if(usuario.getUsuarioSistema().equalsIgnoreCase(usuarioSistema)){
				return usuario;
			}
		}
		return null;		
	}	
}
