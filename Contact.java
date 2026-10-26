package contact;

public class Contact {
	private final String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		if ((contactID != null) && (contactID.length() <= 10)) {
			this.contactID = contactID;
		}
		else {
		    throw new IllegalArgumentException(
		        "Contact ID must not be null or longer than 10 characters."
		    );
		}
		if ((firstName != null) && (firstName.length() <= 10)) {
			this.firstName = firstName;
		}
		else {
		    throw new IllegalArgumentException("First name must not be null or longer than 10 characters.");
		}
		if ((lastName != null) && (lastName.length() <= 10)) {
			this.lastName = lastName;
		}
		else {
		    throw new IllegalArgumentException("Last name must not be null or longer than 10 characters.");
		}
		if ((phone != null) && (phone.matches("\\d{10}"))) {
		    this.phone = phone;
		} else {
		    throw new IllegalArgumentException(
		        "Phone number must be exactly 10 digits."
		    );
		}
		if ((address != null) && (address.length() <= 30)) {
			this.address = address;
		}
		else {
		    throw new IllegalArgumentException("Address must not be null or longer than 30 characters.");
		}
	}
	
	public String getContactID() {
		return contactID;
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
	
	public void setFirstName(String name) {
		if ((name != null) && name.length() <= 10) {
			firstName = name;
		}
		else {
			throw new IllegalArgumentException("First name must not be null or longer than 10 characters.");
		}
	}
	
	public void setLastName(String name) {
		if ((name != null) && (name.length() <= 10)) {
			lastName = name;
		}
		else {
		    throw new IllegalArgumentException("Last name must not be null or longer than 10 characters.");
		}
	}
	
	public void setPhone(String number) {
		if ((number != null) && (number.matches("\\d{10}"))) {
		    phone = number;
		} else {
		    throw new IllegalArgumentException(
		        "Phone number must be exactly 10 digits."
		    );
		}
	}
	
	public void setAddress(String newAddress) {
		if ((newAddress != null) && (newAddress.length() <= 30)) {
			address = newAddress;
		}
		else {
		    throw new IllegalArgumentException("Address must not be null or longer than 30 characters.");
		}
	}
}
