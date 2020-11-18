import org.junit.jupiter.api.function.Executable;

import static java.lang.Math.log10;

public class TaskItem {
	private String title;
	private String description;
	private int[] date;
	private boolean completed;

	// Constructor
	public TaskItem(String title, String description, int[] date) {

		if (isValidTitle(title)) {
			this.title = title;
		} else {
			throw new InvalidTitleException("The title must have at least one character\n");
		}
		if (isValidDate(date)) {
			this.date = new int[3];

			this.date[0] = date[0]; //year
			this.date[1] = date[1]; //month
			this.date[2] = date[2]; //day
		} else {
			throw new InvalidDueDateException("Please enter the date in the following format: (YYYY-MM-DD)\n");
		}

		this.description = description;

		this.completed = false;
	}

	// Getters
	public String getTitle() {
		return this.title;
	}

	public String getDescription() {
		return this.description;
	}

	public String getDateString() {
		return Integer.toString(date[0]) + "-" + Integer.toString(date[1]) + "-" + Integer.toString(date[2]);
	}

	public int [] getDate() {return this.date;}

	public boolean isCompleted() {
		return this.completed;
	}

	public void printDate() {
		System.out.print("[" + Integer.toString(date[0]) + "-" + Integer.toString(date[1]) + "-" + Integer.toString(date[2]) + "]");
	}

	// Setters
	public void setTitle(String newTitle) {
		if (isValidTitle(newTitle)) {
			this.title = newTitle;
		} else {
			throw new InvalidTitleException("The title must have at least one character\n");
		}

	}

	public void setDescription(String newDescription) {
		this.description = newDescription;
	}

	public void setDate(int[] newDate) {
		if (isValidDate(newDate)){
			for (int i = 0; i < 3; i++) this.date[i] = newDate[i];
		} else {
			throw new InvalidDueDateException("Please enter the date in the following format: (YYYY-MM-DD)\n");
		}
	}

	public void toggleCompleted() {
		this.completed = !this.completed;
	}

	// Validate inputs
	public boolean isValidDate(int[] date) {
		boolean year, month, day;

		year = Math.floor(log10(date[0]) + 1) == 4; // TODO check if a "04" works
		month = (date[1] != 0) && (date[1] <= 12);
		day = (date[2] != 0) && (date[2] <= 31);

		return (year && month && day);
	}

	public boolean isValidTitle(String title) {
		return (title.length() > 1);
	}
}

// Custom Exceptions
class InvalidDueDateException extends IllegalArgumentException { // TODO use for set and creating
	public InvalidDueDateException(String msg) {
		super(msg);
	}
}

class InvalidTitleException extends IllegalArgumentException { // TODO use for set and creating
	public InvalidTitleException(String msg) {
		super(msg);
	}
}