package org.football;

import java.util.ArrayList;
import java.util.List;

import org.football.dao.ManagerDao;
import org.football.dao.PlayerDao;
import org.football.dao.SponsorDao;
import org.football.dao.TeamDao;
import org.football.entities.Manager;
import org.football.entities.Player;
import org.football.entities.Team;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ZZSpringBootFootballApplication {

	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ZZSpringBootFootballApplication.class, args);
		PlayerDao playerDao = ctx.getBean(PlayerDao.class);
		TeamDao teamDao = ctx.getBean(TeamDao.class);
		SponsorDao sponsorDao = ctx.getBean(SponsorDao.class);
		ManagerDao managerDao = ctx.getBean(ManagerDao.class);

		
		
		
		
		
		
		
		
		
	}
}
