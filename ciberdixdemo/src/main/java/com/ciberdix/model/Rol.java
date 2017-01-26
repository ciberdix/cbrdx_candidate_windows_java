package com.ciberdix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Rol {
	@Id 
	@SequenceGenerator(name="rol_seq",sequenceName="rol_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rol_seq")
	Long CodigoRol;
	String Rol;
	public Long getCodigoRol() {
		return CodigoRol;
	}
	public void setCodigoRol(Long cogigoRol) {
		CodigoRol = cogigoRol;
	}
	public String getRol() {
		return Rol;
	}
	public void setRol(String rol) {
		Rol = rol;
	}

}
