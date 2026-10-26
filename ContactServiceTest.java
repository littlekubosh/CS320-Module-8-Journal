package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactServiceTest {

    // Test adding a contact
    @Test
    void testAddContact() {
        ContactService service = new ContactService();

        service.addContact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main St");

        Contact contact = service.getContact("12345");

        assertNotNull(contact);
        assertEquals("12345", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    // Test that duplicate contact IDs are rejected
    @Test
    void testDuplicateContactID() {
        ContactService service = new ContactService();

        service.addContact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main St");

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(
                    "12345",
                    "Jane",
                    "Jones",
                    "0987654321",
                    "456 Main St");
        });
    }

    // Test deleting a contact
    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();

        service.addContact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main St");

        service.deleteContact("12345");

        assertNull(service.getContact("12345"));
    }

    // Test updating a contact
    @Test
    void testUpdateContact() {
        ContactService service = new ContactService();

        service.addContact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main St");

        service.updateContact(
                "12345",
                "James",
                "Jones",
                "0987654321",
                "456 Main St");

        Contact contact = service.getContact("12345");

        assertEquals("James", contact.getFirstName());
        assertEquals("Jones", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Main St", contact.getAddress());
    }

    // Test that updating does not change the contact ID
    @Test
    void testContactIDDoesNotChangeDuringUpdate() {
        ContactService service = new ContactService();

        service.addContact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main St");

        service.updateContact(
                "12345",
                "James",
                "Jones",
                "0987654321",
                "456 Main St");

        Contact contact = service.getContact("12345");

        assertEquals("12345", contact.getContactID());
    }

    // Test attempting to update a contact that does not exist
    @Test
    void testUpdateNonexistentContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact(
                    "12345",
                    "James",
                    "Jones",
                    "0987654321",
                    "456 Main St");
        });
    }
}
