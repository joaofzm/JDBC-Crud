package application;


import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.PlayerDao;
import model.entities.Player;
import model.entities.Team;

public class Program {

	public static void main(String[] args) {
		
		PlayerDao playerDao = DaoFactory.createPlayerDaoJDBC();
		
		System.out.println("===============Test 1: Player Find by ID===============");
		Player player = playerDao.findById(3);
		System.out.println(player);
		
		
		System.out.println("\n===============Test 2: Player Find by Team===============");
		Team team = new Team (2,null);
		List<Player> list = playerDao.findByTeam(team);
		for(Player obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===============Test 3: Player Find All===============");
		list = playerDao.findAll();
		for(Player obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===============Test 4: Player Insert===============");
		Team test4Team = new Team (6,null);
		Player newPlayer = new Player(null, "Demar Derozan", "SG", new Date(), 36000000.0, test4Team);
		playerDao.insert(newPlayer);
		System.out.println("Inserted sucessfully! New id = "+ newPlayer.getId());

	}
}
