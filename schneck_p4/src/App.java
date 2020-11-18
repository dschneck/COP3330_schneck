import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
	public static Scanner scanner = new Scanner(System.in);
	public static TaskList taskList = new TaskList();

	static int ListOperationInput, mainMenuInput, index;
	static int [] date;
	static String filename = new String(), title = new String(), description = new String();

	static boolean mainIsFinished = false, validTask = false;

	public static void main(String[] args) {
		MainMenu();
	}

	// Helper functions
	private static void printMainMenu() { 
		System.out.println("Main Menu\n--------\n\n1) create a new list\n2) load an existing list\n3) quit\n");
		System.out.print("> ");
		}

	private static void printListOperations() {
		System.out.println("\nList Operations Task\n--------\n\n1) view the list\n2) add an item \n3) edit an item \n4) remove item\n5) mark an item as completed\n6) unmark an item as completed\n7) save the current list\n8) quit to the main menu\n");
		System.out.print("> ");
	}

	private static void loadFile(String filename) {
		URL path = App.class.getResource(filename);
		File file = new File(path.getFile());
		boolean validFile = false;

		do {
			try (Scanner input = new Scanner(file)) {
				int numTask = input.nextInt();
				input.nextLine();

				for (int i = 0; i < numTask; i++) {
					String title, description;
					int [] date = new int [3];
					boolean isComplete;

					String line = input.nextLine();
					String[] values = line.split("-");

					date[0] = Integer.parseInt(values[0]);
					date[1] = Integer.parseInt(values[1]);
					date[2] = Integer.parseInt(values[2]);

					title = input.nextLine();
					description = input.nextLine();
					isComplete = Boolean.parseBoolean(input.nextLine());

					TaskItem task = new TaskItem(title, description, date);
					if (isComplete) task.toggleCompleted();

					taskList.addTaskFromFile(task);

					input.nextLine();
				}

				validFile = true;
			} catch (FileNotFoundException e) {
				System.err.println("\n" + e);
				e.printStackTrace();
			}
		} while(!validFile);
	}

	private static void saveFile(String filename) {
		File file = new File(filename);
		boolean isValidFile = false;

		do {
			try {
				FileWriter fileWriter = new FileWriter(file);

				fileWriter.write(Integer.toString(taskList.getSize()) + "\n");
				String[] ret;

				for (int i = 0; i < taskList.getSize(); i++) {
					ret = taskList.getTaskString(i);

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

	private static int [] readDate(Scanner scan) {
		int [] date = new int[3];
		boolean isValidDate = false;
		do {
			try {
				String line = scan.nextLine();
				String[] values = line.split("-");

				date[0] = Integer.parseInt(values[0]);
				date[1] = Integer.parseInt(values[1]);
				date[2] = Integer.parseInt(values[2]);

				isValidDate = true;
			} catch (InputMismatchException ie) {
				ie.printStackTrace();
				System.err.println(ie + "\n");
			} catch(ArithmeticException ae) {
				ae.printStackTrace();
				System.err.println(ae + "\n");
			}



		} while(!isValidDate);

		return date;
	}

	// Main drivers
	private static void MainMenu() {
		do {
			try {
				printMainMenu();
				mainMenuInput = scanner.nextInt();
				scanner.nextLine();
				mainIsFinished = true;


				while (mainMenuInput != 3) {
					mainIsFinished = false;
					switch (mainMenuInput) {
						case 1:
							System.out.println("\nnew task list has been created\n\n");
							ListOperationsMenu();
							//printMainMenu();
							break;

						case 2:
							System.out.print("Enter the filename to load: ");
							filename = scanner.nextLine();
							loadFile(filename);
							System.out.println(filename + " has been loaded\n");
							break;
						default:
							System.out.println("Please use a number from 1 to 3 (inclusive)\n");
							break;
						case 3:
							mainIsFinished = true;
							break;
					}

					if (mainMenuInput == 2) {
						mainMenuInput = 1;
						break;
					}
					else mainMenuInput = scanner.nextInt();

				}
			} catch (InputMismatchException e) {
				System.err.println(e + "\n");
				System.out.println("Please use a number from 1 to 3 (inclusive)\n");

				scanner.nextLine();
			}

		} while(!mainIsFinished);
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
					default: // Error
						System.out.println("Please use a number 1 to 8 (inclusive)");
						break;

				}

				printListOperations();
				ListOperationInput = scanner.nextInt();
				scanner.nextLine();
			}

		} catch (Exception e) {
			System.err.println(e + "\n");
			System.err.println("Input was not an integer from 1 to 7.\n Try again.\n");
		}
	}

	// Methods called from switch statement
	private static void ViewList() {
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
			date = readDate(scanner);
			taskList.addTask(title, description, date);
		} catch (Exception e) {
			System.err.println((e));
		}
	}

	private static void EditItem() {
		System.out.println("Which task will you edit? ");
		index = scanner.nextInt();

		System.out.println("Enter a new title for task " + ": ");
		title = scanner.nextLine();

		System.out.println("Enter a new description for task " + ": ");
		description = scanner.nextLine();

		System.out.println("Enter a new task due date (YYYY-MM-DD) for task " + ": ");
		date = readDate(scanner);
		taskList.editTask(index, title, description, date);
	}

	private static void RemoveItem() {
		System.out.println("Which task will you remove? ");
		index = scanner.nextInt();

		taskList.removeTask(index);

	}

	private static void MarkItemComplete() {
		System.out.println("Uncompleted Tasks\n--------");
		taskList.printUncompleted();
		System.out.println("Which task will you mark as completed? ");

		index = scanner.nextInt();
		taskList.toggleCompleted(index);

	}

	private static void MarkItemUncomplete() {
		System.out.println("Completed Tasks\n--------");
		taskList.printCompleted();
		System.out.println("Which task will you unmark as completed? ");

		index = scanner.nextInt();
		taskList.toggleCompleted(index);
	}

	private static void SaveCurrentList() {
		System.out.println("Enter the filename to save as: ");
		filename = scanner.nextLine();
		saveFile(filename);
		System.out.println(filename + " has been saved");
	}
}

