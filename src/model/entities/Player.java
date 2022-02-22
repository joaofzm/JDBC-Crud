package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Player implements Serializable {

	private Integer id;
	private String name;
	private String position;
	private Date birthDate;
	private Double baseSalary;
	
	private Team team;
	
	public Player() {
		
	}

	public Player(Integer id, String name, String position, Date birthDate, Double baseSalary, Team team) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.birthDate = birthDate;
		this.baseSalary = baseSalary;
		this.team = team;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", position=" + position + ", birthDate=" + birthDate + ", baseSalary="
				+ baseSalary + ", team =" + team + "]";
	}
	
	
	
	
	
	
}
