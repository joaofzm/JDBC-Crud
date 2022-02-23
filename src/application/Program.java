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
		Player test1player = playerDao.findById(3);
		System.out.println(test1player);
		
		
		System.out.println("\n===============Test 2: Player Find by Team===============");
		Team test2Team = new Team (2,null);
		List<Player> test2List = playerDao.findByTeam(test2Team);
		for(Player obj : test2List) {
			System.out.println(obj);
		}
		
		System.out.println("\n===============Test 3: Player Find All===============");
		List<Player> test3List = playerDao.findAll();
		for(Player player : test3List) {
			System.out.println(player);
		}
		
		System.out.println("\n===============Test 4: Player Insert===============");
		Team test4Team = new Team (6,null);
		Player newPlayer = new Player(null, "Demar Derozan", "SG", new Date(), 36000000.0, test4Team);
		playerDao.insert(newPlayer);
		System.out.println("Inserted sucessfully! New id = "+ newPlayer.getId());

		System.out.println("\n===============Test 5: Player Update===============");
		Player test5Player = playerDao.findById(6);
		test5Player.setName("Yusei Fudo");
		playerDao.update(test5Player);
		System.out.println("Update completed sucesfully!");
 
	}
}
