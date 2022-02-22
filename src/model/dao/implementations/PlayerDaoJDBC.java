package model.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				Team team = new Team(rs.getInt("TeamId"),rs.getString("TeamName"));
				Player p = new Player();
				p.setId(rs.getInt("Id"));
				p.setName(rs.getString("Name"));
				p.setPosition(rs.getString("Pos"));
				p.setBaseSalary(rs.getDouble("BaseSalary"));
				p.setBirthDate(rs.getDate("BirthDate"));
				p.setTeam(team);
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
		return null;
	}

}
