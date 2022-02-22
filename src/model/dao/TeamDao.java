package model.dao;

import java.util.List;

import model.entities.Team;

public interface TeamDao {

	void insert (Team obj);
	
	void update (Team obj);
	
	void deleteById(Integer id);
	
	Team findById(Integer id);
	
	List<Team> findAll();
}
