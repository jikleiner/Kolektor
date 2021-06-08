package com.klk.usuarios.dto;

import com.klk.usuarios.bo.Usuario;

public class UsuarioDto {

	private String userId; 
	private String nivelUsuario;
	private String proyecto;

	public UsuarioDto() {
	}
	
	public UsuarioDto(Usuario user) {
		this.userId = user.getUserId();
		this.nivelUsuario = user.getNivelUsuario();
		this.proyecto = user.getProyecto();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNivelUsuario() {
		return nivelUsuario;
	}

	public void setNivelUsuario(String nivelUsuario) {
		this.nivelUsuario = nivelUsuario;
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	
	
}
