package com.ujiuye.dbutils;

import java.io.Serializable;

public class Emp implements Serializable{
	
	private int id;
	private String name2;
	private String gender;
	private double salary;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name2;
	}
	public void setName(String name) {
		this.name2 = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name2 + ", gender=" + gender + ", salary=" + salary + ", password="
				+ password + "]";
	}
	
	
	

}
