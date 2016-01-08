package tel.data.model;

import javax.persistence.*;
@Entity
@Table(name = "patient")
@PrimaryKeyJoinColumn(name="userId")

public class Patient extends User{
	
	@Column(name="location")
	private String location;
	@Column(name="age")
	private int age;
	

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Patient(String userName, String userPassword) {
		super(userName, userPassword);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Patient(String firstName, String lastName,
			String userName, String userPassword, int userType,
			String location, int age) {
		super( firstName, lastName, userName, userPassword, userType);
		this.location = location;
		this.age = age;
	}

	public Patient( String firstName, String lastName,
			String userName, String userPassword, int userType) {
		super(firstName, lastName, userName, userPassword, userType);
		// TODO Auto-generated constructor stub
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
