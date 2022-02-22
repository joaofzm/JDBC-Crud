package model.dao;

import java.util.List;

import model.entities.Player;

public interface PlayerDao {
	
	void insert (Player obj);
	
	void update (Player obj);
	
	void deleteById(Integer id);
	
	Player findById(Integer id);
	
	List<Player> findAll();
}
