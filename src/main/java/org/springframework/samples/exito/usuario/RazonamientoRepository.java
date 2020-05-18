package org.springframework.samples.exito.usuario;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.exito.usuario.Razonamiento;
import org.springframework.transaction.annotation.Transactional;

public interface RazonamientoRepository extends Repository<Razonamiento, Integer> {

	@Query("SELECT d " + "FROM Razonamiento d")
	@Transactional(readOnly = true)
	Collection<Razonamiento> listarRazonamiento();

	@Query("SELECT d " + "FROM Razonamiento d " + "WHERE d.usuarioraz LIKE :user%")
	@Transactional(readOnly = true)
	Razonamiento buscarPorUser(@Param("user") String user);

	void save(Razonamiento razonamiento);

}
