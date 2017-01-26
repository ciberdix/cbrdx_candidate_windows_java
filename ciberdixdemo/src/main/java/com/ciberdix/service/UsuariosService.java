package com.ciberdix.service;

import com.ciberdix.model.Usuarios;

public interface UsuariosService {
	public boolean findInLdap(String ldapUsername, String ldapPassword);
	public Usuarios findByUsuarioSistema(String usuarioSistema);
}
