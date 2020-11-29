import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String [] args) {

		ApplicationOptions();



	}

	private static void ApplicationOptions()  {
		System.out.println("Select Your Application\n-------\n1) task list\n2) contact list\n3) exit");

		try {
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch(choice) {
				case 1:
					TaskApp.TaskMain();
					ApplicationOptions();
					break;
				case 2:
					//ContactApp.ContactMain();
					ApplicationOptions();
					break;
				case 3:
					break;

			}

		} catch(InputMismatchException ie) {
			System.err.println(ie);
			System.out.println("WARNING: Please choose a number from 1 to 3 (inclusive)\n");
			scanner.reset();
			scanner.nextLine();
			ApplicationOptions();
		}

	}
}
