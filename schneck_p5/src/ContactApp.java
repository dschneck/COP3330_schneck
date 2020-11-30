import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp {
    public static Scanner scanner = new Scanner(System.in);
    public static ContactList contactList = new ContactList();

    static int ListOperationInput, mainMenuInput, index;
    static String filename = new String(), firstName = new String(),
            lastName = new String(), phoneNumber = new String(), emailAddress = new String();

    public static void ContactMain() { MainMenu(); }


    public static void MainMenu() {
        try {
            printMainMenu();
            mainMenuInput = scanner.nextInt();
            scanner.nextLine();

            switch (mainMenuInput) {
                case 1:
                    System.out.println("\nnew contact list has been created\n\n");
                    ListOperationsMenu();
                    MainMenu();
                    break;
                case 2:
                    System.out.print("Enter the filename to load: ");
                    filename = scanner.nextLine();
                    loadFile(filename);
                    System.out.println(filename + " has been loaded\n");
                    ListOperationsMenu();
                    MainMenu();
                    break;
                default:
                    System.out.println("Please use a number from 1 to 3 (inclusive)\n");
                    break;
                case 3:
                    break;
            }

        } catch(InputMismatchException ie) {
            System.out.println("Please use a number from 1 to 3 (inclusive)\n");
            scanner.reset();
            scanner.nextLine();
            MainMenu();
        }
    }

    private static void printMainMenu() {
        System.out.println("Main Menu\n--------\n\n1) create a new list\n2) load an existing list\n3) quit\n");
        System.out.print("> ");
    }

    private static void ListOperationsMenu() {
        printListOperations();
        try {
            ListOperationInput = scanner.nextInt();
            scanner.nextLine();
            while (ListOperationInput != 6) {
                switch (ListOperationInput) {
                    case 1: // View the list
                        ViewList();
                        break;
                    case 2: // Add an item
                        AddItem();
                        break;
                    case 3: // Edit an item
                        EditItem();
                        break;
                    case 4: // Remove an item
                        RemoveItem();
                        break;
                    case 5: // Save the current list
                        SaveCurrentList();
                        break;
                    case 6: // Quit to main menu
                        break;

                }

                ListOperationsMenu();
            }

        } catch (Exception e) {
            System.err.println(e + "\n");
            System.err.println("Input was not an integer from 1 to 8.\n Try again.\n");
        }
    }

    private static void printListOperations() { // printListOperation(String * options)
        System.out.println("\nList Operations Task\n--------\n\n1) view the list\n2) add an item \n3) edit an item \n4) remove item\n5) save the current list\n6) quit to the main menu\n");
        System.out.print("> ");
    }

    private static void ViewList() {
        System.out.println("Current Tasks\n--------");
        contactList.printList();
    }

    private static void AddItem() {
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

            contactList.addContact(firstName, lastName, phoneNumber, emailAddress);

        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }

    private static void EditItem() { // needs to check for index
        ViewList();

        System.out.println("Which contact will you edit?");
        System.out.print("> ");
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

        System.out.println("Enter a new last name for contact" + Integer.toString(index) + ": ");
        System.out.print("> ");
        emailAddress = scanner.nextLine();
        contactList.editContact(index, firstName, lastName, phoneNumber, emailAddress);
    }

    private static void RemoveItem() {
        ViewList();

        System.out.println("Which task will you remove?");
        System.out.print("> ");
        index = scanner.nextInt();
        scanner.nextLine();

        contactList.removeContact(index);

    }

    private static void SaveCurrentList() {
        System.out.println("Enter the filename to save as:");
        System.out.print("> ");
        filename = scanner.nextLine();
        contactList.saveToFile(filename);
        System.out.println(filename + " has been saved");
    }

    private static void loadFile(String filename) { // make this just straight up addContact()
        URL path = App.class.getResource(filename);
        File file = new File(path.getFile());
        boolean validFile = false;

        do {
            try (Scanner input = new Scanner(file)) {
                int numTask = input.nextInt();
                input.nextLine();

                for (int i = 0; i < numTask; i++) {
                    String firstName, lastName, phoneNumber, emailAddress;
                    boolean isComplete;

                    firstName = input.nextLine();
                    lastName = input.nextLine();
                    phoneNumber = input.nextLine();
                    emailAddress = input.nextLine();

                    ContactItem contact = new ContactItem(firstName, lastName, phoneNumber, emailAddress);

                    contactList.addContactFromFile(contact);

                    input.nextLine();
                }

                validFile = true;
            } catch (FileNotFoundException e) {
                System.err.println("\n" + e);
                e.printStackTrace();
            }
        } while(!validFile);
    }
















}