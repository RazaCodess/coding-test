package com.health.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "enrollee_tbl")
public class Enrollee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="eid")
	private int id;
	private String name;
	private boolean status;
	private Date birthDate;
	private String phoneNumber;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "eid")
	private List<Dependent> dependents;

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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Dependent> getDependents() {
		return dependents;
	}

	public void setDependents(List<Dependent> dependents) {
		this.dependents = dependents;
	}

	public Enrollee() {
	}

	public Enrollee(int id, String name, boolean status, Date birthDate, String phoneNumber, List<Dependent> dependents) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.dependents = dependents;
	}
}
