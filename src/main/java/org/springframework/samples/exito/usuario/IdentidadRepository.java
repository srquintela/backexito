package org.springframework.samples.exito.usuario;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.exito.usuario.Identidad;
import org.springframework.transaction.annotation.Transactional;

public interface IdentidadRepository extends Repository<Identidad, Integer> {

	@Query("SELECT d " + "FROM Identidad d")
	@Transactional(readOnly = true)
	Collection<Identidad> listarIdentidad();

	@Query("SELECT d " + "FROM Identidad d " + "WHERE d.usuarioide LIKE :user%")
	@Transactional(readOnly = true)
	Identidad buscarPorUser(@Param("user") String user);

	void save(Identidad identidad);

}
