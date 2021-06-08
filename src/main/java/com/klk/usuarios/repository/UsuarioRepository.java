package com.klk.usuarios.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.klk.usuarios.bo.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	@Query(value="from Usuario u where u.dni like :dni")
	public Usuario buscarUsuarioDni(@Param(value = "dni") String dni);
}
