package application;


import model.dao.DaoFactory;
import model.dao.PlayerDao;
import model.entities.Player;

public class Program {

	public static void main(String[] args) {
		
		PlayerDao playerDao = DaoFactory.createPlayerDaoJDBC();
		
		Player player = playerDao.findById(3);
		
		System.out.println(player);
	}
}
