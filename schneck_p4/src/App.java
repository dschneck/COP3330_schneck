import java.util.Scanner;
import java.util.ArrayList;

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
					printListOperations();
					try {
						ListOperationInput = scanner.nextInt();

						while(ListOperationInput != 8) {
							ListOperationInput = scanner.nextInt();
							switch(ListOperationInput) {
								case 1:
									break;
								case 2:
									break;
								case 3:
									break;
								case 4:
									break;
								case 5:
									break;
								case 6:
									break;
								case 7:
									break;
								default:
									System.out.println("Please use a number 1 to 8 (inclusive)");
									break;
							
							}
						}

					} catch() {
					q
					}

					printMainMenu();
					break;
				case 2: 
					System.out.println("2");
					break;
				case 3: 
					System.out.println("3");
					break;
				default:
					System.out.println("Please use a number 1 to 3 (inclusive)");
					break;
			} 

			mainMenuInput = scanner.nextInt();

		}


		

		

	}

	private static void printMainMenu() { 
		System.out.println("Main Menu \n --------  \n\n 1) create a new list \n 2) load an existing list \n 3) quit");
		}

	private static void printListOperations() {
		System.out.println("1) view the list \n 2) add an item \n 3) edit an item \n 4) remove item \n 5) mark an item as completed \n 6) unmark an item as completed \n 7) save the current list \n 8) quit to the main menu \n");
	
		}
	private void loadFile(String filename) {
		
	}
}
