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
	
	private Team department;
	
	public Player() {
		
	}

	public Player(Integer id, String name, String position, Date birthDate, Double baseSalary, Team department) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.birthDate = birthDate;
		this.baseSalary = baseSalary;
		this.department = department;
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

	public void setEmail(String email) {
		this.position = email;
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

	public Team getDepartment() {
		return department;
	}

	public void setDepartment(Team department) {
		this.department = department;
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
				+ baseSalary + ", department=" + department + "]";
	}
	
	
	
	
	
	
}
