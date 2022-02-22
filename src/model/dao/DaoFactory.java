package model.dao;

import db.DB;
import model.dao.implementations.PlayerDaoJDBC;

public class DaoFactory {

	public static PlayerDao createPlayerDaoJDBC() {
		return new PlayerDaoJDBC(DB.getConnection());
	}
}
