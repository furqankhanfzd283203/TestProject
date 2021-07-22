package com.mindtree.entity;

public class Student {
	private byte id;
	private String name;
	private byte rollNumber;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(byte id, String name, byte rollNumber) {
		super();
		this.id = id;
		this.name = name;
		this.rollNumber = rollNumber;
	}
	public byte getId() {
		return id;
	}
	public void setId(byte id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(byte rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	

}
