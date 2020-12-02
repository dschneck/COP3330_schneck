import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ContactList extends List {
    
    // Constructor
    public ContactList() {super(ContactItem.itemType);} // The list starts empty

    public void editItem(int index, String firstName, String lastName, String number, String emailAddress) {
        if (isValidIndex(index)) {
            if (ContactItem.checkNumEmpty(firstName, lastName, number, emailAddress) < 4) {
                ContactItem item = (ContactItem) list.get(index);
                item.editContact(firstName, lastName, number, emailAddress);

            } else {
                throw new ItemAllBlankException("WARNING: At least one field needs to be filled.\n");
            }
        } else {
            throw new IndexOutOfBoundsException("You must pick a contact index that is in the list.\n");
        }

    }

    public void printList() {
        System.out.print("\n");

        for (int i = 0; i < list.size(); i++) {
            ContactItem item = (ContactItem) list.get(i);
            System.out.println(item.toString(i));
        }

        System.out.print("\n");
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
                    ret = getItemString(i);

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

    public String [] getItemString(int index) {
        if (isValidIndex(index)) {
            ContactItem item = (ContactItem) list.get(index);
            String [] contact = new String[4];

            contact[0] = item.getFirstName();
            contact[1] = item.getLastName();
            contact[2] = item.getPhoneNumber();
            contact[3] = item.getEmailAddress();

            return contact;
        } else {
            throw new IndexOutOfBoundsException("You must pick a contact index that is in the list\n");
        }
    }

}


