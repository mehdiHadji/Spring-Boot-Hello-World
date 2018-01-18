package org.football.controller;

import java.util.ArrayList;
import java.util.List;

import org.football.dao.ManagerDao;
import org.football.dao.PlayerDao;
import org.football.dao.SponsorDao;
import org.football.dao.TeamDao;
import org.football.entities.Manager;
import org.football.entities.Player;
import org.football.entities.Sponsor;
import org.football.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class monController {
	@Autowired
	private TeamDao teamDao;
	@Autowired
	private PlayerDao playerDao;
	@Autowired
	private SponsorDao sponsorDao;
	@Autowired
	private ManagerDao managerDao;
	

	@RequestMapping(value="/player")
	public String player(Model model)
	{
		List<Player> players = playerDao.findAll();
		model.addAttribute("players", players);
		List<Team> teams = teamDao.findAll();
		model.addAttribute("teams", teams);
		return "player";
	}
	
	@RequestMapping(value="/ajouterTeam")
	public String ajouterTeam(Model model,Team t)
	{
		teamDao.save(t);
		List<Player> players = playerDao.findAll();
		model.addAttribute("players", players);
		List<Team> teams = teamDao.findAll();
		model.addAttribute("teams", teams);
		return "player";
	}
	
	
	@RequestMapping(value="/ajouterPlayer")
	public String ajouterPlayer(Model model,@RequestParam("nom")String nom,@RequestParam("salaire") float salaire,
			@RequestParam("b") int b)
	{
		Team t = teamDao.getOne(b);
		Player p = new Player(nom,salaire,t);
		playerDao.save(p);
		List<Player> players = playerDao.findAll();
		model.addAttribute("players", players);
		List<Team> teams = teamDao.findAll();
		model.addAttribute("teams", teams);
		return "player";
	}
	
	
	@RequestMapping(value="/supprimerPlayer")
	public String supprimerPlayer(Model model,@RequestParam("id") int id)
	{
		playerDao.delete(id);
		List<Player> players = playerDao.findAll();
		model.addAttribute("players", players);
		List<Team> teams = teamDao.findAll();
		model.addAttribute("teams", teams);
		return "player";
	}
	
	
	@RequestMapping(value="/chercherPlayer")
	public String chercherPlayer(Model model,@RequestParam("motCle")String mc)
	{
		String mot = mc;
		List<Player> players = playerDao.chercherPlayerMC("%"+mot+"%");		
		model.addAttribute("players", players);
		List<Team> teams = teamDao.findAll();
		model.addAttribute("teams", teams);
		return "player";
	}
	
	
	@RequestMapping(value="/sponsor")
	public String sponsor(Model model)
	{
		List<Player> players = playerDao.findAll();
	    model.addAttribute("players", players);
		List<Sponsor> sponsors = sponsorDao.findAll();
		model.addAttribute("sponsors", sponsors);
		List<Player> rest = playerDao.notSelected();
		model.addAttribute("rest", rest);
		
		List<Player> notChoosin = players;
		for(int i=0;i<sponsors.size();i++)
		{
			for(int k=0;k<notChoosin.size();k++)
			{
				if(sponsors.get(i).getPlayer().getIdPlayer() == notChoosin.get(k).getIdPlayer())
				{
					notChoosin.remove(k);
				}
			}
		}
		model.addAttribute("notChoosin", notChoosin);
		List<Player> plays = playerDao.findAll();
		model.addAttribute("plays", plays);
		List<Manager> managers = managerDao.findAll();
		model.addAttribute("managers", managers);
		return "sponsor";
	}
	@RequestMapping(value="/ajouterSponsor")
	public String ajouterSponsor(Model model,@RequestParam("libelle") String libelle,
			@RequestParam("marque") String marque,@RequestParam("b")int b)
	{
		Player p = playerDao.getOne(b);
		Sponsor s = new Sponsor(libelle,marque,p);
		sponsorDao.save(s);
		
		List<Player> players = playerDao.findAll();
	    model.addAttribute("players", players);
		List<Sponsor> sponsors = sponsorDao.findAll();
		model.addAttribute("sponsors", sponsors);
		
		List<Player> notChoosin = players;
		for(int i=0;i<sponsors.size();i++)
		{
			for(int k=0;k<notChoosin.size();k++)
			{
				if(sponsors.get(i).getPlayer().getIdPlayer() == notChoosin.get(k).getIdPlayer())
				{
					notChoosin.remove(k);
				}
			}
		}
		model.addAttribute("notChoosin", notChoosin);
		List<Player> plays = playerDao.findAll();
		model.addAttribute("plays", plays);
		List<Manager> managers = managerDao.findAll();
		model.addAttribute("managers", managers);
		return "sponsor";
	}
	@RequestMapping(value="/ajouterManager")
	public String ajouterManager(Model model,@RequestParam("nom")String nom,@RequestParam("b") int b )
	{
		Player p = playerDao.chercherPlayer(b);
		List<Player> joueur = new ArrayList<>(1);
		joueur.add(p);
		Manager manager = new Manager(nom,joueur);
		managerDao.save(manager);
		List<Player> players = playerDao.findAll();
	    model.addAttribute("players", players);
		List<Sponsor> sponsors = sponsorDao.findAll();
		model.addAttribute("sponsors", sponsors);
		List<Player> notChoosin = players;
		for(int i=0;i<sponsors.size();i++)
		{
			for(int k=0;k<notChoosin.size();k++)
			{
				if(sponsors.get(i).getPlayer().getIdPlayer() == notChoosin.get(k).getIdPlayer())
				{
					notChoosin.remove(k);
				}
			}
		}
		model.addAttribute("notChoosin", notChoosin);
		List<Player> plays = playerDao.findAll();
		model.addAttribute("plays", plays);
		List<Manager> managers = managerDao.findAll();
		model.addAttribute("managers", managers);
		return "sponsor";
	}

}
