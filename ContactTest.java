package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

    // Test creation of a valid contact
    @Test
    void testContact() {
        Contact contact = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main St");

        assertEquals("12345", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    // Contact ID tests
    @Test
    void testContactIDTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345678901",
                    "John",
                    "Smith",
                    "1234567890",
                    "123 Main St");
        });
    }

    @Test
    void testContactIDNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    null,
                    "John",
                    "Smith",
                    "1234567890",
                    "123 Main St");
        });
    }

    // First name tests
    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "Johnnnnnnnn",
                    "Smith",
                    "1234567890",
                    "123 Main St");
        });
    }

    @Test
    void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    null,
                    "Smith",
                    "1234567890",
                    "123 Main St");
        });
    }

    // Last name tests
    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smithhhhhhh",
                    "1234567890",
                    "123 Main St");
        });
    }

    @Test
    void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    null,
                    "1234567890",
                    "123 Main St");
        });
    }

    // Phone tests
    @Test
    void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smith",
                    "123456789",
                    "123 Main St");
        });
    }

    @Test
    void testPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smith",
                    "12345678901",
                    "123 Main St");
        });
    }

    @Test
    void testPhoneContainsNonDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smith",
                    "12345abcde",
                    "123 Main St");
        });
    }

    @Test
    void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smith",
                    null,
                    "123 Main St");
        });
    }

    // Address tests
    @Test
    void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smith",
                    "1234567890",
                    "1234567890123456789012345678901");
        });
    }

    @Test
    void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smith",
                    "1234567890",
                    null);
        });
    }

    // Setter tests
    @Test
    void testSetFirstName() {
        Contact contact = createValidContact();

        contact.setFirstName("James");

        assertEquals("James", contact.getFirstName());
    }

    @Test
    void testSetLastName() {
        Contact contact = createValidContact();

        contact.setLastName("Jones");

        assertEquals("Jones", contact.getLastName());
    }

    @Test
    void testSetPhone() {
        Contact contact = createValidContact();

        contact.setPhone("0987654321");

        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    void testSetAddress() {
        Contact contact = createValidContact();

        contact.setAddress("456 Main St");

        assertEquals("456 Main St", contact.getAddress());
    }

    // Invalid setter tests
    @Test
    void testSetInvalidFirstName() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("Johnnnnnnnn");
        });
    }

    @Test
    void testSetInvalidLastName() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("Smithhhhhhh");
        });
    }

    @Test
    void testSetInvalidPhone() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("12345");
        });
    }

    @Test
    void testSetInvalidAddress() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(
                    "1234567890123456789012345678901");
        });
    }

    // Creates a valid contact for use in setter tests
    private Contact createValidContact() {
        return new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main St");
    }
}
