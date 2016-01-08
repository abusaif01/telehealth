package tel.data.model;

import javax.persistence.*;
@Entity
@Table(name = "doctor")
@PrimaryKeyJoinColumn(name="userId")

public class Doctor extends User {

	@Column(name="availability")
	private int availability;
	
	@Column(name="location")
	private String location;

	
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Doctor(String userName, String userPassword) {
		super(userName, userPassword);
		// TODO Auto-generated constructor stub
	}

	
	public Doctor(String firstName, String lastName,
			String userName, String userPassword, int userType,
			int availability, String location) {
		super(firstName, lastName, userName, userPassword, userType);
		this.availability = availability;
		this.location = location;
	}



	

	public Doctor( String firstName, String lastName,
			String userName, String userPassword, int userType) {
		super(firstName, lastName, userName, userPassword, userType);
		// TODO Auto-generated constructor stub
	}



	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
