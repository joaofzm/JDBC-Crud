package application;


import java.util.Date;

import model.entities.Player;
import model.entities.Team;

public class Program {

	public static void main(String[] args) {
		
		Team obj = new Team(1, "Lakers");
		
		Player player = new Player(1, "Lebron", "PG", new Date(), 40000000.0, obj);
		System.out.println(player);
		System.out.println(obj);
	}
}
