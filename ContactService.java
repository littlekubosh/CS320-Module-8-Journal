package contact;

import java.util.HashMap;

public class ContactService {
	private HashMap<String, Contact> contactIDs = new HashMap<String, Contact>();
	
	public void addContact(String contactID, String firstName, String lastName, String phone, String address) {
		if (!contactIDs.containsKey(contactID)) {
			Contact contact = new Contact(contactID, firstName, lastName, phone, address);
			contactIDs.put(contact.getContactID(), contact);
		}
		else {
			throw new IllegalArgumentException("Cannot use duplicate IDs.");
		}
	}
	
	public void deleteContact(String contactID) {
		contactIDs.remove(contactID);
	}
	
	public void updateContact(String contactID, String newFirstName, String newLastName, String newPhone, String newAddress) {
		if (contactIDs.containsKey(contactID)) {
	        Contact contact = contactIDs.get(contactID);

	        contact.setFirstName(newFirstName);
	        contact.setLastName(newLastName);
	        contact.setPhone(newPhone);
	        contact.setAddress(newAddress);
	    } else {
	        throw new IllegalArgumentException("Contact ID does not exist.");
	    }
	}
	
	public Contact getContact(String contactID) {
	    return contactIDs.get(contactID);
	}

}
