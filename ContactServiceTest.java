/*
 * Joseph Roberts
 * CS-320 Module 3
 * Contact Service Test
 * 1-20-2025
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.ContactService;



public class ContactServiceTest {
	
	@AfterEach
	void clearContacts() throws Exception {
		main.ContactService.contacts.clear();
	}
	
	//Add contact
	@Test
	@DisplayName("Add contact to empty list")
	void testAddContact() {
		main.ContactService testService = new ContactService();
		
		testService.addContact("123", "Ginger", "Bread", "0123454321", "14 Drury Lane");
		assertEquals(ContactService.contacts.get(0).getId(), "123");
		assertEquals(ContactService.contacts.get(0).getFirstName(), "Ginger");
		assertEquals(ContactService.contacts.get(0).getLastName(), "Bread");
		assertEquals(ContactService.contacts.get(0).getPhone(), "0123454321");
		assertEquals(ContactService.contacts.get(0).getAddress(), "14 Drury Lane");
	}
	
	//Add two contacts
	@Test
	@DisplayName("Add two contacts")
	void testMultiContacts() {
		ContactService testService = new ContactService();
		
		testService.addContact("123", "Ginger", "Bread", "0123454321", "14 Drury Lane");
		testService.addContact("124", "Rul", "Dolph", "9876543210", "14 Drury Lane");
		assertEquals(ContactService.contacts.size(), 2);
	}
	
	//Test to reject duplicate ID's
	@Test
	@DisplayName("Reject duplicate ID")
	void testDuplicateID() {
		ContactService testService = new ContactService();
		
		testService.addContact("123", "Ginger", "Bread", "0123454321", "14 Drury Lane");
		assertThrows(IllegalArgumentException.class, () ->{
			testService.addContact("123", "Rul", "Dolph", "9876543210", "14 Drury Lane");
		});
		
	}
	
	//Test delete from list
	@Test
	@DisplayName("Delete from empty list")
	void testEmptyList() {
		ContactService testService = new ContactService();
		
		assertThrows(IllegalArgumentException.class, () ->{
			testService.deleteContact("123");
		});
		
	}
	
	
	@Test
	@DisplayName("Delete invalid ID")
	void testDeleteInvalid() {
		ContactService testService = new ContactService();
		
		testService.addContact("123", "Ginger", "Bread", "0123454321", "14 Drury Lane");
		assertThrows(IllegalArgumentException.class, () ->{
			testService.deleteContact("321");
		});
	}
	
	//Update existing information
	@Test
	@DisplayName("Update existing first name")
	void testUpdateFirstName() {
		ContactService testService = new ContactService();
		
		// Add and verify two records
		testService.addContact("123", "Original", "Original", "0123454321", "Original");
		testService.addContact("124", "Original", "Original", "9876543210", "Original");
		assertEquals(ContactService.contacts.size(), 2);
		assertEquals(ContactService.contacts.get(0).getFirstName(), "Original");
		assertEquals(ContactService.contacts.get(1).getFirstName(), "Original");
		
		// Check that exactly 1 record gets updated
		testService.updateFirstName("123", "Changed");
		assertEquals(ContactService.contacts.get(0).getFirstName(), "Changed");
		assertEquals(ContactService.contacts.get(1).getFirstName(), "Original");
		
	}
	
	@Test
	@DisplayName("Update existing last name")
	void testUpdateLastName() {
		ContactService testService = new ContactService();
		
		// Add and verify two records
		testService.addContact("123", "Original", "Original", "0123454321", "Original");
		testService.addContact("124", "Original", "Original", "9876543210", "Original");
		assertEquals(ContactService.contacts.size(), 2);
		assertEquals(ContactService.contacts.get(0).getLastName(), "Original");
		assertEquals(ContactService.contacts.get(1).getLastName(), "Original");
		
		// Check that exactly 1 record gets updated
		testService.updateLastName("123", "Changed");
		assertEquals(ContactService.contacts.get(0).getLastName(), "Changed");
		assertEquals(ContactService.contacts.get(1).getLastName(), "Original");
		
	}
	
	@Test
	@DisplayName("Update existing address")
	void testUpdateAddress() {
		ContactService testService = new ContactService();
		
		// Add and verify two records
		testService.addContact("123", "Original", "Original", "0123454321", "Original");
		testService.addContact("124", "Original", "Original", "9876543210", "Original");
		assertEquals(ContactService.contacts.size(), 2);
		assertEquals(ContactService.contacts.get(0).getAddress(), "Original");
		assertEquals(ContactService.contacts.get(1).getAddress(), "Original");
		
		// Check that exactly 1 record gets updated
		testService.updateAddress("123", "Changed");
		assertEquals(ContactService.contacts.get(0).getAddress(), "Changed");
		assertEquals(ContactService.contacts.get(1).getAddress(), "Original");
		
	}
	
	@Test
	@DisplayName("Update existing phone")
	void testUpdatePhone() {
		ContactService testService = new ContactService();
		
		// Add and verify two records
		testService.addContact("123", "Original", "Original", "0123454321", "Original");
		testService.addContact("124", "Original", "Original", "9876543210", "Original");
		assertEquals(ContactService.contacts.size(), 2);
		assertEquals(ContactService.contacts.get(0).getPhone(), "0123454321");
		assertEquals(ContactService.contacts.get(1).getPhone(), "9876543210");
		
		// Check that exactly 1 record gets updated
		testService.updatePhone("123", "1234543210");
		assertEquals(ContactService.contacts.get(0).getPhone(), "1234543210");
		assertEquals(ContactService.contacts.get(1).getPhone(), "9876543210");
		
	}


}
