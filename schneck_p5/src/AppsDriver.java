import java.util.InputMismatchException;
import java.util.Scanner;

public class AppsDriver {

	public static Scanner scanner = new Scanner(System.in);

	/* Apps in the program */
	public static TaskApp taskApp = new TaskApp();
	public static ContactApp contactApp = new ContactApp();

	public static void main(String [] args) { ApplicationOptions(); }

	private static void ApplicationOptions()  {
		System.out.print("\nSelect Your Application\n-------\n1) task list\n2) contact list\n3) exit\n> ");

		try {
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch(choice) {
				case 1:
					taskApp.MainMenu();
					ApplicationOptions();
					break;
				case 2:
					contactApp.MainMenu();
					ApplicationOptions();
					break;
				case 3:
					break;
				default:
					System.out.println("WARNING: Please choose a number from 1 to 3 (inclusive)\n");
					ApplicationOptions();
					break;
			}

		} catch(InputMismatchException ie) {
			System.out.println("WARNING: Please choose a number from 1 to 3 (inclusive)\n");
			scanner.reset();
			scanner.nextLine();
			ApplicationOptions();
		}
	}
}
