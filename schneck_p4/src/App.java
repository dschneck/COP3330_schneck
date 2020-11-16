import java.util.Scanner;
import java.util.ArrayList;
//import java.util.Exceptions.*;

public class App {
	public static Scanner scanner = new Scanner(System.in);
	//public TaskList taskList = new TaskList();

	public static void main(String[] args) {	
		int ListOperationInput;
		String filename;

		printMainMenu();
		int mainMenuInput = scanner.nextInt();
	

		while(mainMenuInput != 3 ) {
			switch(mainMenuInput) {
				case 1:
					System.out.println("new task list has been created\n\n");
					printListOperations();
					try {
						ListOperationInput = scanner.nextInt();

						while(ListOperationInput != 8) {
							ListOperationInput = scanner.nextInt();
							switch(ListOperationInput) {
								case 1: // View the list
									tasklist.printList();
									break;
								case 2: // Add an item
									System.out.println("Task title: ");
									String title = scanner.nextLine();	

									System.out.println("Task description: ");
									String description = scanner.nextLine();
									
									System.out.println("Task due date (YYYY-MM-DD): ");
									int date[]  = readDate();
									taskList.addTask(title, description, date);

									break;
								case 3: // Edit an item

									System.out.println("Enter a new title for task " + ": ");


									System.out.println("Enter a new description for task " + ": ");


									System.out.println("Enter a new task due date (YYYY-MM-DD) for task " + ": ");
									break;
								case 4: // Remove an item


									System.out.println("Which task will you remove? ");
									tasklist.remove(task);
									break;
								case 5: // Mark an item as completed
									System.out.println("Uncompleted Tasks\n--------\n\n");
									tasklist.printUncompleted();
									tasklist.toggleCompleted(task);
									break;
								case 6: // Unmark an item as completed
									System.out.println("Completed Tasks\n--------\n\n");
									tasklist.printCompleted();
									tasklist.toggleCompleted(task);
									break;
								case 7: // Save the current list
									System.out.println("Enter the filename to save as: ");
									saveAsFile();
									System.out.println("task list has been saved");

									break;
								default: // Error
									System.out.println("Please use a number 1 to 8 (inclusive)");
									break;
							
							}
						}

					} catch(Exception e) {
						System.err.println(e);
						System.err.println("Input was not an integer from 1 to 7.\n Try again.");
					}

					printMainMenu();
					break;
				case 2: 
					System.out.println("Enter the filename to load: ");
					filename = scanner.nextLine();
					loadFile(filename);
					System.out.println(filename + " has been loaded\n");
					break;
				case 3: 
					break;
				default:
					System.out.println("Please use a number 1 to 3 (inclusive)");
					break;
			} 
			
			if (mainMenuInput == 2) {
				mainMenuInput = 1;
				continue;
			}
			else mainMenuInput = scanner.nextInt();

		}


		

		

	}

	private static void printMainMenu() { 
		System.out.println("Main Menu\n--------\n\n1) create a new list\n2) load an existing list\n3) quit\n");
		System.out.print("> ");
		}

	private static void printListOperations() {
		System.out.println("List Operations Task\n--------\n\n1) view the list\n2) add an item \n3) edit an item \n4) remove item\n5) mark an item as completed\n6) unmark an item as completed\n7) save the current list\n8) quit to the main menu\n");
		System.out.println("> ");
	}

	private static void loadFile(String filename) {
				
	}

	private static int [] readDate() {
	//	int year = 0, month = 0, day = 0;
		int date[] = new int[3];

		try {
			date[0]  = scanner.nextInt();
			scanner.skip("-");

			date[1]  = scanner.nextInt();
			scanner.skip("-");

			date[2] = scanner.nextInt();
			scanner.skip("-");
		}
		catch(InputMismatchException e) {
			System.err.println(e);
			System.err.println("yuh");
		}

	//	System.out.print(Integer.toString(year) + " " + Integer.toString(month) + " " + Integer.toString(day));
		return date;
	}
}

