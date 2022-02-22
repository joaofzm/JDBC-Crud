package model.dao;

import model.dao.implementations.PlayerDaoJDBC;

public class DaoFactory {

	public static PlayerDao createPlayerDaoJDBC() {
		return new PlayerDaoJDBC();
	}
}
