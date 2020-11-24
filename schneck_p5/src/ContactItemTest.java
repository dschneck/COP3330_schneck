import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {

	@Test
	public void creationFailsWithAllBlankValues() {

		assertThrows(ItemAllBlankException.class, () -> new ContactItem("", "", "", "") );
	}

	@Test
	public void creationSucceedsWithBlankEmail() {
		assertDoesNotThrow(() -> new ContactItem("David", "Schneck", "777-888-1223", ""));
	}

	@Test
	public void creationSucceedsWithBlankFirstName() {
		assertDoesNotThrow(() -> new ContactItem("", "Schneck", "777-888-1223", "david.schneck@Knights.ucf.edu"));
	}
	
	@Test
	public void creationSucceedsWithBlankLastName() {
		assertDoesNotThrow(() -> new ContactItem("David", "", "777-888-1223", "david.schneck@Knights.ucf.edu"));
	}

	@Test
	public void creationSucceedsWithBlankPhone() {
		assertDoesNotThrow(() -> new ContactItem("David", "Schneck", "", "david.schneck@Knights.ucf.edu"));
	}

	@Test
	public void creationSucceedsWithNonBlankValues() {
		assertDoesNotThrow(() -> new ContactItem("David", "Schneck", "777-888-1223", "david.schneck@Knights.ucf.edu"));
	}

	@Test
	public void editingFailsWithAllBlankValues() {
		ContactItem contact = new ContactItem("David", "Schneck", "777-888-1223", "david.schneck@Knights.ucf.edu");

		assertThrows(ItemAllBlankException.class, () -> contact.editContact("", "", "", ""));
	}
	
	@Test
	public void editingSucceedsWithBlankEmail() {
		ContactItem contact = new ContactItem("David", "Schneck", "777-888-1223", "david.schneck@Knights.ucf.edu");

		assertDoesNotThrow(() -> contact.editContact("Jin", "Yang", "123-223-3434", ""));
	}

	@Test
	public void editingSucceedsWithBlankFirstName() {
		ContactItem contact = new ContactItem("David", "Schneck", "777-888-1223", "david.schneck@Knights.ucf.edu");

		assertDoesNotThrow(() -> contact.editContact("", "Yang", "123-223-3434", "yang@aol.com"));
	}

	@Test
	public void editingSucceedsWithBlankLastName() {
		ContactItem contact = new ContactItem("David", "Schneck", "777-888-1223", "david.schneck@Knights.ucf.edu");

		assertDoesNotThrow(() -> contact.editContact("Jin", "", "123-223-3434", "yang@aol.com"));
	}

	@Test
	public void editingSucceedsWithBlankPhone() {
		ContactItem contact = new ContactItem("David", "Schneck", "777-888-1223", "david.schneck@Knights.ucf.edu");

		assertDoesNotThrow(() -> contact.editContact("Jin", "Yang", "", "yang@aol.com"));
	}
	
	@Test
	public void editingSucceedsWithNonBlankValues() {
		ContactItem contact = new ContactItem("David", "Schneck", "777-888-1223", "david.schneck@Knights.ucf.edu");

		assertDoesNotThrow(() -> contact.editContact("Jin", "Yang", "123-223-3434", "yang@aol.com"));
	}

	@Test
	public void testToString() {
		ContactItem contact = new ContactItem("David", "Schneck", "777-888-1223", "david.schneck@Knights.ucf.edu");

		assertEquals("0) Name: David Schneck\nPhone: 777-888-1223\nEmail: david.schneck@Knights.ucf.edu", contact.toString(0));
	}

}


