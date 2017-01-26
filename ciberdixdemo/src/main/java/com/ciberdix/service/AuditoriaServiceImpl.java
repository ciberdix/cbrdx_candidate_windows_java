package com.ciberdix.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciberdix.model.Auditoria;
import com.ciberdix.model.AuditoriaRepository;
import com.ciberdix.model.Usuarios;


@Service("auditoriaService")
@Transactional
public class AuditoriaServiceImpl implements AuditoriaService {
	
	@Autowired
	AuditoriaRepository auditoriaRepository;
	

	public void saveAuditoria(String accion, Usuarios usuario) {
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Auditoria auditoria = new Auditoria();

		auditoria.setAccion(accion);
		auditoria.setTimestamp(timestamp);
		auditoria.setUsuario(usuario);
		auditoriaRepository.save(auditoria);
		
	}	

	public void saveAuditoria(String accion, Usuarios usuario, Timestamp timestamp) {
		Auditoria auditoria = new Auditoria();

		auditoria.setAccion(accion);
		auditoria.setTimestamp(timestamp);
		auditoria.setUsuario(usuario);
		auditoriaRepository.save(auditoria);
		
	}		
	
	
	public List<Auditoria> findAllAuditorias() {
		return (List<Auditoria>) auditoriaRepository.findAll();
	}

}
