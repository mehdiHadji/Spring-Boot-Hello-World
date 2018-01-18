package org.football.dao;

import java.util.List;

import org.football.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayerDao extends JpaRepository<Player, Integer> {
	

   @Query("select p from Player p where p.idPlayer = :y")
	public Player chercherPlayer(@Param("y")int id);
	
	@Query("select p from Player p where p.nomPlayer like :x")
	List<Player> chercherPlayerMC(@Param("x")String mc);
	
	@Query("select p from Player p,Sponsor s where p.idPlayer <> s.player")
	List<Player> notSelected();

}
