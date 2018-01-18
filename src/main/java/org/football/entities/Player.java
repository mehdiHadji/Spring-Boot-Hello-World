package org.football.entities;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="Player")
public class Player implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="idPlayer")
	private int idPlayer;
	
	@Column(name="nomPlayer")
	private String nomPlayer;
	
	@Column(name="salaire")
	private float salaire;		
	
	@ManyToOne()
	@JoinColumn(name="idTeam")
	private Team team;	
	
	@ManyToMany(mappedBy="players")		
	private List<Manager> managers;
	
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	
	public List<Manager> getManagers() {
		return managers;
	}

	public void setManagers(List<Manager> managers) {
		this.managers = managers;
	}

	public Player(String nomPlayer, float salaire, Team team) 
	{
		this.nomPlayer = nomPlayer;
		this.salaire = salaire;
		this.team = team;
	}
	public Player()
	{
		
	}

	public int getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}

	public String getNomPlayer() {
		return nomPlayer;
	}

	public void setNomPlayer(String nomPlayer) {
		this.nomPlayer = nomPlayer;
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public Player(String nomPlayer, float salaire, Team team, List<Manager> managers) 
	{
		this.nomPlayer = nomPlayer;
		this.salaire = salaire;
		this.team = team;
		this.managers = managers;
	}

	
	
}
