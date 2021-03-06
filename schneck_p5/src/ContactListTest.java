import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {
	@Test
	public void addingItemsIncreasesSize() {
		ContactList list = new ContactList();

		int initialSize = list.getSize();
		list.addItem(new ContactItem("David", "Schneck", "123-345-6789", "david.schneck@Knights.ucf.edu"));

		assertNotEquals(initialSize, list.getSize());
	}

	@Test
	public void editingItemsFailsWithAllBlankValues() {
		ContactList list= new ContactList();
		list.addItem(new ContactItem("David", "Schneck", "123-345-6789", "david.schneck@Knights.ucf.edu"));

		assertThrows(ItemAllBlankException.class, () -> list.editItem(0, "", "", "", ""));

	}

	@Test
	public void editingItemsFailsWithInvalidIndex() {
		ContactList list = new ContactList();
		list.addItem(new ContactItem("David", "Schneck", "123-345-6789", "david.schneck@Knights.ucf.edu"));

		assertThrows(IndexOutOfBoundsException.class, () -> list.editItem(1, "Ehrlich", "Bachman", "123-456-6789", "ehrnoc@hooli.com"));
	}

	@Test
	public void editingSucceedsWithBlankFirstName()  {
		ContactList list = new ContactList();
		list.addItem(new ContactItem("David", "Schneck", "123-345-6789", "david.schneck@Knights.ucf.edu"));

		assertDoesNotThrow(() -> list.editItem(0, "", "Bachman", "123-456-6789", "ehrnoc@hooli.com"));
	}

	@Test
	public void editingSucceedsWithBlankLastName() {
		ContactList list = new ContactList();
		list.addItem(new ContactItem("David", "Schneck", "123-345-6789", "david.schneck@Knights.ucf.edu"));

		assertDoesNotThrow(() -> list.editItem(0, "Ehrlich", "", "123-456-6789", "ehrnoc@hooli.com"));
	}

	@Test
	public void editingSucceedsWithBlankPhone() {
		ContactList list = new ContactList();
		list.addItem(new ContactItem("David", "Schneck", "123-345-6789", "david.schneck@Knights.ucf.edu"));

		assertDoesNotThrow(() -> list.editItem(0, "Ehrlich", "Bachman", "", "ehrnoc@hooli.com"));
	}

	@Test
	public void editingSucceedsWithNonBlankValues() {
		ContactList list = new ContactList();
		list.addItem(new ContactItem("David", "Schneck", "123-345-6789", "david.schneck@Knights.ucf.edu"));

		assertDoesNotThrow(() -> list.editItem(0, "Ehrlich", "Bachman", "123-456-6789", "ehrnoc@hooli.com"));
	}
	
	@Test
	public void newListIsEmpty() {
		ContactList list = new ContactList();

		assertEquals(0 ,list.getSize());
	}

	@Test
	public void removingItemsDecreasesSize() {
		ContactList list = new ContactList();
		list.addItem(new ContactItem("David", "Schneck", "123-345-6789", "david.schneck@Knights.ucf.edu"));

		int sizeOfOne = list.getSize();
		list.removeItem(0);

		assertNotEquals(sizeOfOne, list.getSize());
	}

	@Test
	public void removingItemsFailsWithInvalidIndex () {
		ContactList list = new ContactList();
		list.addItem(new ContactItem("David", "Schneck", "123-345-6789", "david.schneck@Knights.ucf.edu"));

		assertThrows(IndexOutOfBoundsException.class, () -> list.removeItem(1));
	}

	//@Test
	//public void savedContactListCanBeLoaded() {}



}
