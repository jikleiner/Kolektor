package com.klk.usuarios.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klk.usuarios.bo.Usuario;
import com.klk.usuarios.dto.UsuarioDto;
import com.klk.usuarios.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioRest {

	@Autowired
	private UsuarioService userServ;
	
	@PostMapping
	public ResponseEntity<UsuarioDto> altaUsuario(@RequestBody Usuario usuario){
		UsuarioDto userNvo = new UsuarioDto(userServ.altaUsuario(usuario));
		return ResponseEntity.ok(userNvo);
	}
	
	@GetMapping(path="/")
	public ResponseEntity<UsuarioDto> buscarUsuarioId(@RequestParam Long id){
		UsuarioDto res = new UsuarioDto(userServ.buscarUsuarioId(id));
		return ResponseEntity.ok(res);
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioDto>> listarUsuarios(){
		List<UsuarioDto> res = new ArrayList<UsuarioDto>();
		for (Usuario usuario : userServ.mostrarUsuarios()) {
			res.add(new UsuarioDto(usuario));
		}
		return ResponseEntity.ok(res);
	}
	
	@DeleteMapping
	public BodyBuilder eliminarUsuario(@RequestParam Long id) {
		userServ.eliminarUsuario(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED);
	}
	
	@PutMapping
	public ResponseEntity<UsuarioDto> generarUserPass (@RequestParam Long id){
		UsuarioDto user = new UsuarioDto(userServ.generarCredenciales(id));
		return ResponseEntity.ok(user);
	}
	
	@GetMapping(path="/search")
	public ResponseEntity<UsuarioDto> buscarUsuarioDni(@RequestParam String dni){
		UsuarioDto user = new UsuarioDto(userServ.buscarUsuarioDni(dni));
		return ResponseEntity.ok(user);
	}
}
