package org.football.dao;


import org.football.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeamDao extends JpaRepository<Team, Integer> {
	
	@Query("select p from Team p where p.idTeam = :y")
	public Team chercherTeam(@Param("y")int id);

}
