import java.util.ArrayList;

public class ContactList {
    private ArrayList<ContactItem> contacts;

    // Constructor
    public ContactList() {contacts = new ArrayList<>();} // The list starts empty

    public int getSize() {return contacts.size();}

    public void addContact(String firstName, String lastName, String number, String emailAddress) {
        contacts.add(new ContactItem(firstName, lastName, number, emailAddress));
    }

    public void addContactFromFile(ContactItem contact) {contacts.add(contact);}

    public void removeContact(int index) {
        if (isValidIndex(index)) {
            contacts.remove(index);
        } else {
            throw new IndexOutOfBoundsException("You must pick a contact index that is in the list\n");
        }
    }

    public void editContact(int index, String firstName, String lastName, String number, String emailAddress) {
        if (isValidIndex(index)) { // TODO might be able to replace tasks.get(index) with task
            if (ContactItem.checkNumEmpty(firstName, lastName, number, emailAddress) < 4) {

               contacts.get(index).editContact(firstName, lastName, number, emailAddress);

            } else {
                throw new ItemAllBlankException("WARNING: At least one field needs to be filled.\n");
            }
        } else {
            throw new IndexOutOfBoundsException("You must pick a contact index that is in the list.\n");
        }

    }

    public void printList() {
        System.out.print("\n");

        for (int i = 0; i < contacts.size(); i++) {
            System.out.print(contacts.get(i).toString(i));
        }

        System.out.print("\n");
    }

    // Validate input
    public boolean isValidIndex(int index) {
        return !(index < 0 || index > this.getSize());
    }

}


