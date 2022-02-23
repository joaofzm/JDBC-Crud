package application;


import java.util.List;

import model.dao.DaoFactory;
import model.dao.PlayerDao;
import model.entities.Player;
import model.entities.Team;

public class Program {

	public static void main(String[] args) {
		
		PlayerDao playerDao = DaoFactory.createPlayerDaoJDBC();
		
		System.out.println("===============Teste 1: Player Find by ID===============");
		Player player = playerDao.findById(3);
		System.out.println(player);
		
		
		System.out.println("\n===============Teste 2: Player Find by ID===============");
		Team team = new Team (2,null);
		List<Player> list = playerDao.findByTeam(team);
		for(Player obj : list) {
			System.out.println(obj);
		}
	}
}
