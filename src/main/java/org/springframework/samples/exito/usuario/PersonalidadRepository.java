package org.springframework.samples.exito.usuario;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.exito.usuario.Personalidad;
import org.springframework.transaction.annotation.Transactional;

public interface PersonalidadRepository extends Repository<Personalidad, Integer> {

	@Query("SELECT d " + "FROM Personalidad d")
	@Transactional(readOnly = true)
	Collection<Personalidad> listarPersonalidad();

	@Query("SELECT d " + "FROM Personalidad d " + "WHERE d.usuarioper LIKE :user")
	@Transactional(readOnly = true)
	Personalidad buscarPorUser(@Param("user") String user);

	void save(Personalidad personalidad);

}
