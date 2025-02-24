/*
 * Joseph Roberts
 * CS-320 Module 3
 * Contact Test
 * 1-20-2025
 */

package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import main.Contact;

public class ContactTest {
	
	
	@Test
	@DisplayName("New Contact Creation / Verify Getters")
	void testNewContact() {
		String id = "123454321";
		String firstName = "Ginger";
		String lastName = "Bread";
		String phone = "0123454321";
		String address = "14 Drury Lane";
		
		Contact testContact = new Contact(id, firstName, lastName, phone, address);
		
		assertEquals("123454321", testContact.getId());
		assertEquals("Ginger", testContact.getFirstName());
		assertEquals("Bread", testContact.getLastName());
		assertEquals("0123454321", testContact.getPhone());
		assertEquals("14 Drury Lane", testContact.getAddress());		
	}
	
	//Error test on null value
	@Test
	@DisplayName("Error on null values")
	void testContactNullArguments() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact(null, "Ginger", "Bread", "0123454321", "14 Drury Lane");
		});
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("123454321", null, "Bread", "0123454321", "14 Drury Lane");
		});
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("123454321", "Ginger", null, "0123454321", "14 Drury Lane");
		});
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("123454321", "Ginger", "Bread", null, "14 Drury Lane");
		});
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("123454321", "Ginger", "Bread", "0123454321", null);
		});
	}
	
	//Error test on max string value
	@Test 
	@DisplayName("Error on string longer than max") 
	void testContactMaxLength() { 
		assertThrows(IllegalArgumentException.class, () ->{ 
			new Contact("12345678901", "Ginger", "Bread", "01234567890", "14 Drury Lane"); 
		}); 
		assertThrows(IllegalArgumentException.class, () ->{ 
			new Contact("1234567890", "12345678901", "Bread", "01234567890", "14 Drury Lane"); 
		}); 
		assertThrows(IllegalArgumentException.class, () ->{ 
			new Contact("1234567890", "Ginger", "12345678901", "01234567890", "14 Drury Lane");
		}); 
		assertThrows(IllegalArgumentException.class, () ->{ 
			new Contact("1234567890", "Ginger", "Bread", "012345678901", "14 Drury Lane"); 
		}); 
		assertThrows(IllegalArgumentException.class, () ->{ 
			new Contact("1234567890", "Ginger", "Bread", "01234567890", "14 Drury Lane, Extra Long Address"); 
		}); 
	}
	
	//Error test on invalid phone value
	@Test
	@DisplayName("Error on invalid phone number")
	void testPhone() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("123454321", "Ginger", "Bread", "12345", "14 Drury Lane");
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("123454321", "Ginger", "Bread", "12345432101", "14 Drury Lane");
	    });
	}

	
	@Test
	@DisplayName("Verify contact setter methods")
	void testSetters() {
		String contactID = "123454321";
		String firstName = "Ginger";
		String lastName = "Bread";
		String phone = "0123454321";
		String address = "14 Drury Lane";
		
		Contact testContact = new Contact(contactID, firstName, lastName, phone, address);
		
		testContact.setFirstName("Changed");
		assertEquals(testContact.getFirstName(), "Changed");
		testContact.setLastName("Changed");
		assertEquals(testContact.getLastName(), "Changed");
		testContact.setPhone("1234543210");
		assertEquals(testContact.getPhone(), "1234543210");
		testContact.setAddress("Changed");
		assertEquals(testContact.getAddress(), "Changed");
		
	}
}
