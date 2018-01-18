package org.football.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Team")
public class Team implements Serializable{
	private int idTeam;
	private String nomTeam;			
	private List<Player> players;

	public Team(String nomTeam, List<Player> players) 
	{
		this.nomTeam = nomTeam;
		this.players = players;
	}
	public Team()
	{
		
	}
	@Id
	@GeneratedValue
	@Column(name="idTeam")
	public int getIdTeam() {
		return idTeam;
	}
	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}
	@Column(name="nomTeam")
	public String getNomTeam() {
		return nomTeam;
	}
	public void setNomTeam(String nomTeam) {
		this.nomTeam = nomTeam;
	}
	@OneToMany(mappedBy="team",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	
	
	
	
	

}
