package org.football.dao;

import org.football.entities.Sponsor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SponsorDao extends JpaRepository<Sponsor, Integer>{
	
	@Query("select p from Sponsor p where p.idSponsor = :y")
	public Sponsor chercherSponsor(@Param("y")int id);

}
