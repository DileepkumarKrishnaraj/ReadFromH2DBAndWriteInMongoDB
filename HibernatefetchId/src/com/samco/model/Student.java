package com.samco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	@Column
	private int id;
	@Column
	private String department;
	@Column
	private String name;
	@Column
	private int collegeyear;

	public Student() {
		super();
	}

	public Student(int id, String department, String name, int collegeyear) {
		super();
		this.id = id;
		this.department = department;
		this.name = name;
		this.collegeyear = collegeyear;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCollegeyear() {
		return collegeyear;
	}

	public void setCollegeyear(int collegeyear) {
		this.collegeyear = collegeyear;
	}

}
