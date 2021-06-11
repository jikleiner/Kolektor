package com.klk.usuarios.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.klk.usuarios.bo.Usuario;
import com.klk.usuarios.dto.Persona;
import com.klk.usuarios.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioServiceImp implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	@Autowired
	private RestTemplate usuarioTemp;
	@Value("${key.personas}")
	private String urlPersonas;

	public Usuario altaUsuario(Usuario user) {
		usuarioRepo.save(user);
		return user;
	}
	
	public Usuario buscarUsuarioId(Long id) {
		return usuarioRepo.findById(id).get();
	}

	public List<Usuario> mostrarUsuarios() {
		List<Usuario> res = new ArrayList<Usuario>();
		for (Usuario usuario : usuarioRepo.findAll()) {
			res.add(usuario);
		}
		return res;
	}

	public Usuario modificarUsuario(Usuario user) {
		// ver q se modifica
		return null;
	}

	public void eliminarUsuario(Long id) {
		usuarioRepo.deleteById(id);
	}

	public Usuario generarCredenciales(String dni) {
		Usuario user = usuarioRepo.buscarUsuarioDni(dni);
		Persona pers = this.buscarDatosPersona(dni);
		user.setUserId(pers.getNombre()+pers.getApellido());
		user.setPass(pers.getNroDocumento()+pers.getSexo());
		usuarioRepo.save(user);
		return user;
	}

	public List<Persona> consultarPersonas() {
		@SuppressWarnings("unchecked")
		List<Persona> personas = usuarioTemp.getForObject(urlPersonas, List.class);
		return personas;
	}
	
	public Persona buscarDatosPersona(String dni) {
		return usuarioTemp.getForObject(urlPersonas+"?nroDocumento="+dni, Persona.class);
	}

	public Usuario buscarUsuarioDni(String dni) {
		return usuarioRepo.buscarUsuarioDni(dni);
	}


}
