import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp implements App {
    public ContactList contactList = new ContactList();

    private static int ListOperationInput, mainMenuInput, index;
    private static String filename = new String(), firstName = new String(),
                          lastName = new String(), phoneNumber = new String(),
                          emailAddress = new String();


    public void MainMenu() {
        try {
            printMainMenu();
            mainMenuInput = scanner.nextInt();
            scanner.nextLine();

            switch (mainMenuInput) {
                case 1:
                    System.out.println("\nnew contact list has been created\n");
                    ListOperationsMenu();
                    MainMenu();
                    break;
                case 2:
                    loadFile();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Please use a number from 1 to 3 (inclusive)\n");
                    MainMenu();
                    break;
            }

        } catch(InputMismatchException ie) {
            System.out.println("Please use a number from 1 to 3 (inclusive)\n");
            scanner.reset();
            scanner.nextLine();
            MainMenu();
        }
    }

    public void printMainMenu() {
        System.out.println("\nMain Menu\n--------\n\n1) create a new list\n2) load an existing list\n3) quit\n");
        System.out.print("> ");
    }

    public void ListOperationsMenu() {
        printListOperations();
        try {
            ListOperationInput = scanner.nextInt();
            scanner.nextLine();

                switch (ListOperationInput) {
                    case 1: // View the list
                        ViewList();
                        ListOperationsMenu();
                        break;
                    case 2: // Add an item
                        AddItem();
                        ListOperationsMenu();
                        break;
                    case 3: // Edit an item
                        EditItem();
                        ListOperationsMenu();
                        break;
                    case 4: // Remove an item
                        RemoveItem();
                        ListOperationsMenu();
                        break;
                    case 5: // Save the current list
                        SaveCurrentList();
                        ListOperationsMenu();
                        break;
                    case 6: // Quit to main menu
                        ClearList();
                        break;
                    default:
                        System.out.println("Please use a number from 1 to 3 (inclusive)\n");
                        break;

                }



        } catch (InputMismatchException e) {
            System.out.println("Input was not an integer from 1 to 8.\n Try again.\n");
            scanner.reset();
            scanner.nextLine();
            ListOperationsMenu();
        }
    }

    public void printListOperations() {
        System.out.println("\nList Operations Task\n--------\n\n1) view the list\n2) add an item \n3) edit an item \n4) remove item\n5) save the current list\n6) quit to the main menu\n");
        System.out.print("> ");
    }

    public void ViewList() {
        System.out.println("Current Contacts\n--------");
        contactList.printList();
    }

    public void AddItem() {
        try {
            System.out.print("First Name: ");
            firstName = scanner.nextLine();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }

        try {
            System.out.print("Last Name: ");
            lastName = scanner.nextLine();

        } catch (InputMismatchException e) {
            e.printStackTrace();
        }

        try {
            System.out.print("Phone number (xxx-xxx-xxxx): ");
            phoneNumber = scanner.nextLine();
        } catch (InputMismatchException e) {
            System.err.println((e));
        }

        try {
            System.out.print("Email address (x@y.z): ");
            emailAddress = scanner.nextLine();
            try {
                contactList.addItem(new ContactItem(firstName, lastName, phoneNumber, emailAddress));
            } catch(ItemAllBlankException b) {
                System.out.println(b.getMessage());
            }

        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }

    public void EditItem() { 
        ViewList();

        System.out.println("\n\nWhich contact will you edit?\n> ");

        try {
            index = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter a new first name for contact " + Integer.toString(index) + ": ");
            System.out.print("> ");
            firstName = scanner.nextLine();

            System.out.println("Enter a new last name for contact " + Integer.toString(index) + ": ");
            System.out.print("> ");
            lastName = scanner.nextLine();

            System.out.println("Enter a new phone number (xxx-xxx-xxxx) for contact " + Integer.toString(index) + ": ");
            System.out.print("> ");
            phoneNumber = scanner.nextLine();

            System.out.println("Enter a new last name for contact " + Integer.toString(index) + ": ");
            System.out.print("> ");
            emailAddress = scanner.nextLine();
            try {
                contactList.editItem(index, firstName, lastName, phoneNumber, emailAddress);
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            } catch (ItemAllBlankException b) {
                System.out.println(b.getMessage());
            }
        } catch(InputMismatchException m) {
            System.out.println("WARNING: Please input an integer.");
        }
    }

    public void RemoveItem() {
        ViewList();

        System.out.println("Which task will you remove?\n> ");

        try {
            index = scanner.nextInt();
            scanner.nextLine();

            try {
                contactList.removeItem(index);
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        } catch(InputMismatchException m) {
            System.out.println("WARNING: Please input an integer.");
        }
    }

    public void ClearList() {
        contactList.clearList();
    }

    public void SaveCurrentList() {
        System.out.println("Enter the filename to save as:");
        System.out.print("> ");
        filename = scanner.nextLine();

        try {
            contactList.saveToFile(filename);
        } catch(ItemAllBlankException b) {
            System.out.println(b.getMessage());
        }
        System.out.println(filename + " has been saved");
    }

    public void loadFile() {
        System.out.print("Enter the filename to load:\n> ");
        filename = scanner.nextLine();
        File file = null;

        try {
            URL path = AppsDriver.class.getResource(filename);
            file = new File(path.getFile());

            try {
                if (!file.exists()) return;

                FileReader fileRead = new FileReader(file);

                Scanner input = new Scanner(fileRead);

                int numTask = input.nextInt();
                input.nextLine();

                for (int i = 0; i < numTask; i++) {
                    String firstName, lastName, phoneNumber, emailAddress;

                    firstName = input.nextLine();
                    lastName = input.nextLine();
                    phoneNumber = input.nextLine();
                    emailAddress = input.nextLine();

                    contactList.addItemFromFile(new ContactItem(firstName, lastName, phoneNumber, emailAddress));

                    input.nextLine();
                }

                input.close();
                System.out.println(filename + " has been loaded\n");
                ListOperationsMenu();
                MainMenu();
            } catch(FileNotFoundException e) {
                System.out.println("WARNING: File not found");
            }
        } catch(Exception e) {
            System.out.println("WARNING: File not found");
            MainMenu();

        }



    }

}


