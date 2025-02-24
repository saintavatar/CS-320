/*
 * Joseph Roberts
 * CS-320 Module 3
 * Contact Service
 * 1-20-2025
 */

package main;

import java.util.ArrayList;
import java.util.List;


public class ContactService {
	
	//Create list for contacts
	public static List<Contact> contacts = new ArrayList<Contact>();
	
	public void addContact(String id, String firstName, String lastName, String phone, String address) {
		
		
		//Check list for duplicate ID
		if (!contacts.isEmpty()) {
			for (Contact item : contacts) {
				if (item.getId() == id) {
					throw new IllegalArgumentException("Duplicate Contact ID");
				}
			}
		}
		
		//If no errors found
		
		Contact newContact = new Contact(id, firstName, lastName, phone, address);
		contacts.add(newContact);
	}
	
	public void deleteContact(String id) {
		
			if (contacts.isEmpty()) {
					throw new IllegalArgumentException("List is empty");
			}
			
			for(int i = 0; i < contacts.size(); i++) {
				if (contacts.get(i).getId() == id) {
					contacts.remove(i);
					return;
				}
			}
			
			//If contact not found
			throw new IllegalArgumentException("Contact ID does not exist");	
	}
	
	//Update information
	
	public void updateFirstName(String id, String firstName) {
		
			for (Contact item : contacts) {
				if (item.getId() == id) {
						item.setFirstName(firstName);
			}
		}
	}
	
	public void updateLastName(String id, String lastName) {
		
			for (Contact item : contacts) {
				if (item.getId() == id) {
						item.setLastName(lastName);
			}	
		}
	}
	public void updatePhone(String id, String phone) {
		
			for (Contact item : contacts) {
				if (item.getId() == id) {
					item.setPhone(phone);
			}
		}
	}
	
	public void updateAddress(String id, String address) {
	
		for (Contact item : contacts) {
				if (item.getId() == id) {
					item.setAddress(address);
			}
		}
	}
	
}	


