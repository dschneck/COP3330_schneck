import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskApp implements App {
	public static Scanner scanner = new Scanner(System.in);
	public static TaskList taskList = new TaskList();

	static int ListOperationInput, mainMenuInput, index;
	static String filename = new String(), title = new String(),
			      description = new String(), date = new String();

	// Helper functions
	public void MainMenu() {
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
					loadFile();
					ListOperationsMenu();
					MainMenu();
					break;
				case 3:
					break;
				default:
					System.out.println("Please use a number from 1 to 3 (inclusive)\n");
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

	public void printMainMenu() {
		System.out.println("\nMain Menu\n--------\n\n1) create a new list\n2) load an existing list\n3) quit\n");
		System.out.print("> ");
		}

	public void ListOperationsMenu() {
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
					default:
						System.out.println("Please use a number from 1 to 3 (inclusive)\n");
						break;

				}

				ListOperationsMenu();
			}

		} catch (InputMismatchException e) {
			System.out.println("WARNING: Input was not an integer from 1 to 8.\n Try again.\n");
			scanner.reset();
			scanner.nextLine();
			ListOperationsMenu();
		}
	}

	public void printListOperations() {
		System.out.println("\nList Operations Task\n--------\n\n1) view the list\n2) add an item \n3) edit an item \n4) remove item\n5) mark an item as completed\n6) unmark an item as completed\n7) save the current list\n8) quit to the main menu\n");
		System.out.print("> ");
	}

	// Methods called from switch statement
	public void ViewList() {
		System.out.println("Current Tasks\n--------");
		taskList.printList();
	}

	public void AddItem() {
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
		} catch (InputMismatchException e) {
			System.err.println((e));
		}

		try {
			taskList.addItem(new TaskItem(title, description, date));
		} catch(IndexOutOfBoundsException i) {
			System.out.println(i.getMessage());
		} catch(InvalidDueDateException d) {
			System.out.println(d.getMessage());
		}

	}

	public void EditItem() { // needs to check for index
		ViewList();

		try {
			System.out.println("Which task will you edit?\n> ");
			index = scanner.nextInt();
			scanner.nextLine();

			System.out.println("Enter a new title for task " + Integer.toString(index) + ":\n> ");
			title = scanner.nextLine();

			System.out.println("Enter a new description for task " + Integer.toString(index) + ":\n> ");
			description = scanner.nextLine();

			System.out.println("Enter a new task due date (YYYY-MM-DD) for task " + Integer.toString(index) + ":\n> ");
			date = scanner.nextLine();

			try {
				taskList.editTask(index, title, description, date);
			} catch (IndexOutOfBoundsException i) {
				System.out.println(i.getMessage());
			} catch (InvalidDueDateException d) {
				System.out.println(d.getMessage());
			}
		}  catch(InputMismatchException m) {
			System.out.println("WARNING: Please input an integer.");
		}
	}

	public void RemoveItem() {
		ViewList();

		System.out.println("Which task will you remove?");
		System.out.print("> ");

		index = scanner.nextInt();
		scanner.nextLine();

		try {
			taskList.removeItem(index);
		} catch(IndexOutOfBoundsException i) {
			System.out.println(i.getMessage());
		}

	}

	public void ClearList() { taskList.clearList(); }

	public void MarkItemComplete() {
		System.out.println("Uncompleted Tasks\n--------");
		taskList.printUncompleted();
		System.out.println("Which task will you mark as completed?\n> ");

		try {
			index = scanner.nextInt();
			scanner.nextLine();

			try {
				taskList.toggleCompleted(index);
			} catch (IndexOutOfBoundsException i) {
				System.out.println(i.getMessage());
			}
		} catch(InputMismatchException m) {
			System.out.println("WARNING: Please input an integer.");
		}
	}

	public void MarkItemUncomplete() {
		System.out.println("Completed Tasks\n--------");
		taskList.printCompleted();
		System.out.println("Which task will you unmark as completed?\n> ");

		try {
			index = scanner.nextInt();
			scanner.nextLine();

			try {
				taskList.toggleCompleted(index);
			} catch (IndexOutOfBoundsException i) {
				System.out.println(i.getMessage());
			}
		} catch(InputMismatchException m) {
			System.out.println("WARNING: Please input an integer.");
		}
	}

	public void SaveCurrentList() {
		System.out.println("Enter the filename to save as:");
		System.out.print("> ");
		filename = scanner.nextLine();
		taskList.saveToFile(filename);
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
					String title, description, date;
					boolean isComplete;

					title = input.nextLine();
					description = input.nextLine();
					date = input.nextLine();
					isComplete = input.nextBoolean();


					taskList.addItemFromFile(new TaskItem(title, description, date));
					if (isComplete) taskList.toggleCompleted(i);

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
			e.printStackTrace();
			System.out.println("WARNING: File not found");
			MainMenu();

		}



	}
}

