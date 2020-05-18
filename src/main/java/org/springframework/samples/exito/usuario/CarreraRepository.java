package org.springframework.samples.exito.usuario;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface CarreraRepository extends Repository<Carrera, Integer> {

	// criterios busqueda

	@Query("SELECT d " + "FROM Carrera d")
	@Transactional(readOnly = true)
	Collection<Carrera> listarCarreras();

	@Query("SELECT c " + "FROM Carrera c " + "WHERE c.area = :area " + "AND c.dpto = :dpto " + "AND c.pago = :pago ")
	ArrayList<Carrera> buscaCarreras(@Param("area") String area, @Param("dpto") String dpto,
			@Param("pago") String pago);

	void save(Carrera carrera) throws DataAccessException;

}
