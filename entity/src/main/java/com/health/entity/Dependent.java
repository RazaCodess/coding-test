package com.health.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dependent_tbl")
public class Dependent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "did")
	private int id;
	private String name;
	private Date dateOfBirth;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Dependent() {
	}

	public Dependent(int id, String name, Date dateOfBirth) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
}