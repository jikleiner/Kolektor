package com.klk.usuarios.service;

import java.util.List;

import com.klk.usuarios.bo.Usuario;
import com.klk.usuarios.dto.Persona;

public interface UsuarioService {
	
	public Usuario altaUsuario(Usuario user);
	public Usuario buscarUsuarioId(Long id);
	public List<Usuario> mostrarUsuarios();
	public Usuario modificarUsuario(Usuario user);
	public void eliminarUsuario(Long id);
	public Usuario generarCredenciales(Long id);
	public Persona buscarDatosPersona(String dni);
	public List<Persona> consultarPersonas();
	public Usuario buscarUsuarioDni(String dni);
	
}
