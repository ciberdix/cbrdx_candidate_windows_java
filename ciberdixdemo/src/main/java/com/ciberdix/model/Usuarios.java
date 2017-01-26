package com.ciberdix.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Usuarios {
	@Id 
	@SequenceGenerator(name="usuarios_seq",sequenceName="usuarios_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usuarios_seq")
	Long CodigoUsuario;
	String UsuarioSistema;
	String Contrasena;
	@ManyToOne
	@JoinColumn(name="CodigoRol", referencedColumnName="CodigoRol")
	private Rol rol;

	
	public Long getCodigoUsuario() {
		return CodigoUsuario;
	}
	public void setCodigoUsuario(Long codigoUsuario) {
		CodigoUsuario = codigoUsuario;
	}
	public String getUsuarioSistema() {
		return UsuarioSistema;
	}
	public void setUsuarioSistema(String usuarioSistema) {
		UsuarioSistema = usuarioSistema;
	}
	public String getContrasena() {
		return Contrasena;
	}
	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}	
	
}
