package org.football.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="Sponsor")
public class Sponsor implements Serializable{	
	@Id
	@GeneratedValue
	@Column(name="idSponsor")
	private int idSponsor;
	
	@Column(name="libelle")
	private String libelle;
	
	@Column(name="marque")
	private String marque;	
	
	@OneToOne
	private Player player;

	
	public int getIdSponsor() {
		return idSponsor;
	}

	public void setIdSponsor(int idSponsor) {
		this.idSponsor = idSponsor;
	}


	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Sponsor(String libelle, String marque, Player player) {
		super();
		this.libelle = libelle;
		this.marque = marque;
		this.player = player;
	}
	public Sponsor()
	{
		
	}
	

}
