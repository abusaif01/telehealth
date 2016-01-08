package tel.data.model;

import javax.persistence.*;
@Entity
@Table(name = "patient")
@PrimaryKeyJoinColumn(name="userId")

public class Patient extends User{
	
	@Column(name="age")
	private int age;
	
	@Column(name="weight")
	private int weight;
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
			int age,int weight) {
		super( firstName, lastName, userName, userPassword, userType);
		this.age = age;
		this.weight = weight;
	}

	public Patient( String firstName, String lastName,
			String userName, String userPassword, int userType) {
		super(firstName, lastName, userName, userPassword, userType);
		// TODO Auto-generated constructor stub
	}

	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	
	
}
