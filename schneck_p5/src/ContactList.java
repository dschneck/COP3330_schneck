import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ContactList {
    private ArrayList<ContactItem> contacts;

    // Constructor
    public ContactList() {contacts = new ArrayList<>();} // The list starts empty

    public int getSize() {return contacts.size();}

    public void addContact(String firstName, String lastName, String number, String emailAddress) {
        contacts.add(new ContactItem(firstName, lastName, number, emailAddress));
    }

    public void addContactFromFile(ContactItem contact) {contacts.add(contact);} // addItemFromFile<I>

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

    public void saveToFile(String filename) {
        File file = new File(filename);
        boolean isValidFile = false;

        do {
            try {
                FileWriter fileWriter = new FileWriter(file);

                fileWriter.write(Integer.toString(this.getSize()) + "\n");
                String[] ret;

                for (int i = 0; i < this.getSize(); i++) {
                    ret = this.getTaskString(i);

                    fileWriter.write(ret[0] + "\n");
                    fileWriter.write(ret[1] + "\n");
                    fileWriter.write(ret[2] + "\n");
                    fileWriter.write(ret[3] + "\n");
                    fileWriter.write(" \n");

                }

                isValidFile = true;
                fileWriter.close();

            } catch (IOException e) {
                System.err.println(e + "\n");
                e.printStackTrace();
            }
        } while(!isValidFile);


    }

    public String [] getTaskString(int index) {
        if (isValidIndex(index)) {
            String [] contact = new String[4];

            contact[0] = contacts.get(index).getFirstName(); //tasks.get(index).getTitle();
            contact[1] = contacts.get(index).getLastName(); //tasks.get(index).getDescription();
            contact[2] = contacts.get(index).getPhoneNumber(); //tasks.get(index).getDateString();
            contact[3] = contacts.get(index).getEmailAddress();

            return contact;
        } else {
            throw new IndexOutOfBoundsException("You must pick a contact index that is in the list\n");
        }

        //return tasks.get(index).getTaskString(index);
    }


}


