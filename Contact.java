/*
 * Joseph Roberts
 * CS-320 Module 3
 * Contact
 * 1-20-2025
 */

package main;

public class Contact {
	private static final int MAX_LENGTH = 10;
	private static final int MAX_ADDRESS = 30;
	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String id, String firstName, String lastName, String phone, String address) {
		super();
		
		
		// Check that all parameters are not null and meet length restrictions
		if (id == null || id.length() > MAX_LENGTH) {
			throw new IllegalArgumentException("ID is not valid");
		}
		if (firstName == null || firstName.length() > MAX_LENGTH) {
			throw new IllegalArgumentException("First Name is not valid");
		}
		if (lastName == null || lastName.length() > MAX_LENGTH) {
			throw new IllegalArgumentException("Last name is not valid");
		}
		if (phone == null || phone.length() != MAX_LENGTH) {
			throw new IllegalArgumentException("Phone number is not valid");
		}
		if (address == null || address.length() > MAX_ADDRESS) {
			throw new IllegalArgumentException("Address is invalid");
		}
		
		//Object parameters with valid input
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}

	//Setter method
	
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("First name is invalid");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Last name is invalid");
		}
		this.lastName = lastName;
	}

	public void setPhone(String phone) {
		if (phone == null || phone.length() > 10) {
			throw new IllegalArgumentException("Phone number is invalid");
		}
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Address is invalid");
		}
		this.address = address;
	}
	
	//Getter method
	
	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	

}
