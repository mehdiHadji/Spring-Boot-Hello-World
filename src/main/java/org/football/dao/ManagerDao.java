package org.football.dao;

import org.football.entities.Manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ManagerDao extends JpaRepository<Manager, Integer> {
	
	@Query("select p from Manager p where p.idManager = :y")
	public Manager chercherManager(@Param("y")int id);

}
