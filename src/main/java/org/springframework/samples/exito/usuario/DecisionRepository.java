package org.springframework.samples.exito.usuario;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.exito.usuario.Decision;
import org.springframework.transaction.annotation.Transactional;

public interface DecisionRepository extends Repository<Decision, Integer> {

	@Query("SELECT d " + "FROM Decision d")
	@Transactional(readOnly = true)
	ArrayList<Decision> listarDecision();

	@Query("SELECT d " + "FROM Decision d " + "WHERE d.usuariodec LIKE :user")
	@Transactional(readOnly = true)
	ArrayList<Decision> buscarDecisionPorUser(@Param("user") String user);

	@Query("SELECT d " + "FROM Decision d " + "WHERE d.usuariodec LIKE :user" + " AND d.fuente LIKE :fuente%")
	@Transactional(readOnly = true)
	Decision buscarDecisionPorUserYFuente(@Param("user") String user, @Param("fuente") String fuente);

	void save(Decision decision) throws DataAccessException;

}
