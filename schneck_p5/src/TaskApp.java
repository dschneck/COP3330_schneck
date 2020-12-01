import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskApp {
	public static Scanner scanner = new Scanner(System.in);
	public static TaskList taskList = new TaskList();

	static int ListOperationInput, mainMenuInput, index;
	static String filename = new String(), title = new String(), description = new String(), date = new String();

	public static void TaskMain() {
		MainMenu();
	}

	// Helper functions
	private static void MainMenu() {
		try {
			printMainMenu();
			mainMenuInput = scanner.nextInt();
			scanner.nextLine();

			switch (mainMenuInput) {
				case 1:
					System.out.println("\nnew task list has been created\n\n");
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

		} catch (InputMismatchException e) {
			System.err.println(e + "\n");
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
			while (ListOperationInput != 8) {
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
					case 5: // Mark an item as uncompleted
						MarkItemComplete();
						break;
					case 6: // Unmark an item as completed
						MarkItemUncomplete();
						break;
					case 7: // Save the current list
						SaveCurrentList();
						break;
					case 8: // Quit to main menu
						ClearList();
						break;

				}

				ListOperationsMenu();
			}

		} catch (Exception e) {
			System.err.println(e + "\n");
			System.err.println("Input was not an integer from 1 to 8.\n Try again.\n");
		}
	}

	private static void printListOperations() {
		System.out.println("\nList Operations Task\n--------\n\n1) view the list\n2) add an item \n3) edit an item \n4) remove item\n5) mark an item as completed\n6) unmark an item as completed\n7) save the current list\n8) quit to the main menu\n");
		System.out.print("> ");
	}

	// Methods called from switch statement
	private static void ViewList() {
		System.out.println("Current Tasks\n--------");
		taskList.printList();
	}

	private static void AddItem() {
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
			date = scanner.nextLine();
			taskList.addItem(new TaskItem (title, description, date));
		} catch (InputMismatchException e) {
			System.err.println((e));
		}
	}

	private static void EditItem() { // needs to check for index
		ViewList();

		System.out.println("Which task will you edit?");
		System.out.print("> ");
		index = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter a new title for task " + Integer.toString(index) + ": ");
		System.out.print("> ");
		title = scanner.nextLine();

		System.out.println("Enter a new description for task " + Integer.toString(index) + ": ");
		System.out.print("> ");
		description = scanner.nextLine();

		System.out.println("Enter a new task due date (YYYY-MM-DD) for task " + Integer.toString(index) + ": ");
		System.out.print("> ");
		date = scanner.nextLine();
		taskList.editTask(index, title, description, date);
	}

	private static void RemoveItem() {
		ViewList();

		System.out.println("Which task will you remove?");
		System.out.print("> ");
		index = scanner.nextInt();

		taskList.removeItem(index);

	}

	private static void ClearList() {
		for (int i = 0; i < taskList.getSize(); i++) {
			taskList.removeItem(i);
		}
	}

	private static void MarkItemComplete() {
		System.out.println("Uncompleted Tasks\n--------");
		taskList.printUncompleted();
		System.out.println("Which task will you mark as completed?");
		System.out.print("> ");

		index = scanner.nextInt();
		taskList.toggleCompleted(index);

	}

	private static void MarkItemUncomplete() {
		System.out.println("Completed Tasks\n--------");
		taskList.printCompleted();
		System.out.println("Which task will you unmark as completed? ");
		System.out.print("> ");

		index = scanner.nextInt();
		taskList.toggleCompleted(index);
	}

	private static void SaveCurrentList() {
		System.out.println("Enter the filename to save as:");
		System.out.print("> ");
		filename = scanner.nextLine();
		taskList.saveToFile(filename);
		System.out.println(filename + " has been saved");
	}

	private static void loadFile(String filename) {
		URL path = AppsDriver.class.getResource(filename);
		File file = new File(path.getFile());
		boolean validFile = false;

		do {
			try (Scanner input = new Scanner(file)) {
				int numTask = input.nextInt();
				input.nextLine();

				for (int i = 0; i < numTask; i++) {
					String title, description, date;
					boolean isComplete;

					date = input.nextLine();
					title = input.nextLine();
					description = input.nextLine();
					isComplete = Boolean.parseBoolean(input.nextLine());

					TaskItem task = new TaskItem(title, description, date);
					if (isComplete) task.toggleCompleted();

					taskList.addItemFromFile(task);

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

