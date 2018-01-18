package org.football.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="Manager")
public class Manager implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="idManager")
	private int idManager;
	
	@Column(name="nomManager")
	private String nomManager;
	
	@ManyToMany
	@JoinTable(name="player_manager",joinColumns={@JoinColumn(name="idManager")},inverseJoinColumns={@JoinColumn(name="idPlayer")})
	private List<Player> players;
	
	public Manager(String nomManager, List<Player> players)
	{
		this.nomManager = nomManager;
		this.players = players;
	}
	public Manager()
	{
		
	}
	public int getIdManager() {
		return idManager;
	}
	public void setIdManager(int idManager) {
		this.idManager = idManager;
	}
	public String getNomManager() {
		return nomManager;
	}
	public void setNomManager(String nomManager) {
		this.nomManager = nomManager;
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	

}
