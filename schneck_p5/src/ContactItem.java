import static java.lang.Math.log10;

public class ContactItem {

	// Fields
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;
	

	// Constructor
	public ContactItem(String firstName, String lastName, String number, String emailAddress) {
		
		if (checkNumEmpty(firstName, lastName, number, emailAddress) < 4) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.phoneNumber = number;
			this.emailAddress = emailAddress;
		} else {
			throw new ItemAllBlankException("WARNING: At least one field needs to be filled.");
		}
	}


	// Getters
	public String getFirstName() {return this.firstName;}
	public String getLastName() {return this.lastName;}
	public String getPhoneNumber() {return this.phoneNumber;}
	public String getEmailAddress() {return this.emailAddress;}

	// Setters
	//public void setFirstName(String name) {this.firstName = name;}
	//public void setLastName(String name) {this.lastName = name;}
	//public void setPhoneNumber(String number) {this.phoneNumber = number;}
	//public void setEmailAddress(String email) {this.emailAddress = email;}


	// Printers
	//@Override
	public String toString(int index) {
		return Integer.toString(index) + ") Name: " + this.firstName + " " + this.lastName
			+ "\nPhone: " + this.phoneNumber
			+ "\nEmail: " + this.emailAddress;
	}

	// Helper methods
	public static int checkNumEmpty(String fname, String lname, String number, String emailadd) {
		int numEmpty = 0;

		if (fname.isEmpty()) numEmpty++;
		if (lname.isEmpty()) numEmpty++;
		if (number.isEmpty()) numEmpty++;
		if (emailadd.isEmpty()) numEmpty++;

		//if (Math.floor(log10(number + 1)) != 10 ) numEmpty++;

		return numEmpty;
	}

	public void editContact(String firstName, String lastName, String number, String emailAddress) {
		if (checkNumEmpty(firstName, lastName, number, emailAddress) < 4) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.phoneNumber = number;
			this.emailAddress = emailAddress;
		} else {
			throw new ItemAllBlankException("WARNING: At least one field needs to be filled.");
		}
	}

}
