package org.springframework.samples.exito.usuario;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.exito.usuario.Usuario;
import org.springframework.transaction.annotation.Transactional;

public interface UsuarioRepository extends Repository<Usuario, Integer> {

	@Query("SELECT DISTINCT usuario " + "FROM Usuario usuario " + "WHERE usuario.apellidos LIKE :lastName%")
	@Transactional(readOnly = true)
	Collection<Usuario> findByLastName(@Param("lastName") String lastName);

	@Query("SELECT DISTINCT usuario " + "FROM Usuario usuario " + "WHERE usuario.username LIKE :username%")
	@Transactional(readOnly = true)
	Collection<Usuario> buscarPorUsername(@Param("username") String username);

	@Query("SELECT DISTINCT usuario " + "FROM Usuario usuario " + "WHERE usuario.username LIKE :user%")
	@Transactional(readOnly = true)
	Usuario buscarPorUser(@Param("user") String user);

	@Query("SELECT usuario FROM Usuario usuario WHERE usuario.id =:id")
	@Transactional(readOnly = true)
	Usuario findById(@Param("id") Integer id);

	void save(Usuario usuario);

}
