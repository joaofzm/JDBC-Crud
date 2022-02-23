package model.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.PlayerDao;
import model.entities.Player;
import model.entities.Team;

public class PlayerDaoJDBC implements PlayerDao {

	private Connection conn;

	public PlayerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Player obj) {

	}

	@Override
	public void update(Player obj) {

	}

	@Override
	public void deleteById(Integer id) {

	}

	@Override
	public Player findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(
					"SELECT player.*,team.Name as TeamName "
					+ "FROM player INNER JOIN team "
					+ "ON player.TeamId = team.Id "
					+ "WHERE player.Id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				Team team = new Team(rs.getInt("TeamId"),rs.getString("TeamName"));
				Player p = new Player(
						rs.getInt("Id"),
						rs.getString("Name"),
						rs.getString("Pos"),
						rs.getDate("BirthDate"),
						rs.getDouble("BaseSalary"),
						team);
				return p;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Player> findAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(
					" SELECT player.*,team.Name as TeamName "
					+ "FROM player INNER JOIN team "
					+ "ON player.TeamId = team.Id "
					+ "ORDER BY Name");
			rs = ps.executeQuery();
			
			List <Player> listOfPlayers = new ArrayList<>();
			Map <Integer, Team> map = new HashMap<>();
			while (rs.next()) {
				
				Team checkIfTeamAlreadyOnMap = map.get(rs.getInt("TeamId"));
				
				Team tempTeam;
				if (checkIfTeamAlreadyOnMap == null) {
					tempTeam = new Team(rs.getInt("TeamId"),rs.getString("TeamName"));
					map.put(rs.getInt("TeamId"), tempTeam);
				} else {
					tempTeam = map.get(rs.getInt("TeamId"));
				}
				Player p = new Player(
						rs.getInt("Id"),
						rs.getString("Name"),
						rs.getString("Pos"),
						rs.getDate("BirthDate"),
						rs.getDouble("BaseSalary"),
						tempTeam);
				listOfPlayers.add(p);
			}
			return listOfPlayers;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Player> findByTeam(Team team) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(
					" SELECT player.*,team.Name as TeamName "
					+ "FROM player INNER JOIN team "
					+ "ON player.TeamId = team.Id "
					+ "WHERE TeamId = ? "
					+ "ORDER BY Name");
			ps.setInt(1, team.getId());
			rs = ps.executeQuery();
			
			List <Player> listOfPlayers = new ArrayList<>();
			Map <Integer, Team> map = new HashMap<>();
			while (rs.next()) {
				
				Team checkIfTeamAlreadyOnMap = map.get(rs.getInt("TeamId"));
				
				Team tempTeam;
				if (checkIfTeamAlreadyOnMap == null) {
					tempTeam = new Team(rs.getInt("TeamId"),rs.getString("TeamName"));
					map.put(rs.getInt("TeamId"), tempTeam);
				} else {
					tempTeam = map.get(rs.getInt("TeamId"));
				}
				Player p = new Player(
						rs.getInt("Id"),
						rs.getString("Name"),
						rs.getString("Pos"),
						rs.getDate("BirthDate"),
						rs.getDouble("BaseSalary"),
						tempTeam);
				listOfPlayers.add(p);
			}
			return listOfPlayers;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
	}

}
