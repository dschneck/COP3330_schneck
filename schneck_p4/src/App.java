import java.io.FileNotFoundException;
import java.io.File;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;
//import java.util.Exceptions.*;

public class App {
	public static Scanner scanner = new Scanner(System.in);
	public static TaskList taskList = new TaskList();

	public static void main(String[] args) {	
		int ListOperationInput, mainMenuInput, index;
		int [] date;
		String filename = new String(), title = new String(), description = new String();

		printMainMenu();
		mainMenuInput = scanner.nextInt();
	

		while(mainMenuInput != 3 ) {
			switch(mainMenuInput) {
				case 1:
					System.out.println("new task list has been created\n\n");
					printListOperations();
					try {
						ListOperationInput = scanner.nextInt();
						scanner.nextLine();
						while(ListOperationInput != 8) {
							switch(ListOperationInput) {
								case 1: // View the list
									taskList.printList();
									break;
								case 2: // Add an item

										try {
											System.out.print("Task title: ");
											title = scanner.nextLine();
										} catch (InputMismatchException e) {
											e.printStackTrace();
										}

										try {
											System.out.print("Task description: ");
											description = scanner.nextLine();

										} catch (InputMismatchException e) {
											e.printStackTrace();
										}

										try {
											System.out.print("Task due date (YYYY-MM-DD): ");
											date = readDate();
											taskList.addTask(title, description, date);
										} catch (Exception e) {
											System.err.println((e));
										}
									break;
								case 3: // Edit an item
									System.out.println("Which task will you edit? ");
									index = scanner.nextInt();

									System.out.println("Enter a new title for task " + ": ");
									title = scanner.nextLine();

									System.out.println("Enter a new description for task " + ": ");
									description = scanner.nextLine();

									System.out.println("Enter a new task due date (YYYY-MM-DD) for task " + ": ");
									date = readDate();
									taskList.editTask(index, title, description, date);

									break;
								case 4: // Remove an item
									System.out.println("Which task will you remove? ");
									index = scanner.nextInt();

									taskList.removeTask(index);

									break;
								case 5: // Mark an item as uncompleted
									System.out.println("Uncompleted Tasks\n--------\n\n");
									taskList.printUncompleted();
									System.out.println("Which task will you mark as completed? ");

									index = scanner.nextInt();
									taskList.toggleCompleted(index);

									break;
								case 6: // Unmark an item as completed
									System.out.println("Completed Tasks\n--------\n\n");
									taskList.printCompleted();
									System.out.println("Which task will you unmark as completed? ");

									index = scanner.nextInt();
									taskList.toggleCompleted(index);

									break;
								case 7: // Save the current list
									System.out.println("Enter the filename to save as: ");
									filename = scanner.nextLine();
									saveFile(filename);
									System.out.println("task list has been saved");

									break;
								default: // Error
									System.out.println("Please use a number 1 to 8 (inclusive)");
									break;
							
							}

							printListOperations();
							ListOperationInput = scanner.nextInt();
							scanner.nextLine();
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
		System.out.print("> ");
	}

	private static void loadFile(String filename) {
		URL path = App.class.getResource(filename);
		File file = new File(path.getFile());

		try (Scanner input = new Scanner(file)) {
			int numTask = input.nextInt();

			while (input.hasNextLine()) {
				String line = input.nextLine();
				System.out.println(line);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void saveFile(String filename) {
		File file = new File(filename);

	}

	private static int [] readDate() {
		int [] date = new int[3];
		String line = scanner.nextLine();
		String[] values = line.split("-");

		date[0] = Integer.parseInt(values[0]);
		date[1] = Integer.parseInt(values[1]);
		date[2] = Integer.parseInt(values[2]);
		/*
		try {
			date[0]  = scanner.nextInt();
			scanner.skip("-");

			date[1]  = scanner.nextInt();
			scanner.skip("-");

			date[2] = scanner.nextInt();
			scanner.skip("-");

			scanner.nextLine();
		}
		catch(InputMismatchException e) {
			System.err.println(e);
			System.err.println("Please enter a new task due date in the following format: YYYY-MM-DD");
		}

		 */

	//	System.out.print(Integer.toString(year) + " " + Integer.toString(month) + " " + Integer.toString(day));
		//finally {
		//	return date;
		//}

		return date;
	}
}

