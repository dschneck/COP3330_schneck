import static java.lang.Math.log10;

public class TaskItem extends Item {

	// Fields
	private String title;
	private String description;
	private String date;
	private boolean completed;

	// Constructor
	public TaskItem(String title, String description, String date) {
		super("Task");

		if (isValidTitle(title)) {
			this.title = title;
		} else {
			throw new InvalidTitleException("The title must have at least one character\n");
		}
		if (isValidDate(dateToIntArray(date))) {
			this.date = date;
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

	public String getDate() {return this.date;}

	public boolean isCompleted() {
		return this.completed;
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

	public void setDate(String newDate) {
		if (isValidDate(dateToIntArray(newDate))) {
			this.date = newDate;
		} else {
			throw new InvalidDueDateException("WARNING: Please give the date in the following format: (YYYY-MM-DD)\n");
		}
	}

	public void toggleCompleted() {
		this.completed = !this.completed;
	}

	// Validate inputs
	public static int [] dateToIntArray(String date) {
		int [] dateA = new int[3];
		String[] values = date.split("-");

		dateA[0] = Integer.parseInt(values[0]);
		dateA[1] = Integer.parseInt(values[1]);
		dateA[2] = Integer.parseInt(values[2]);

		return dateA;
	}
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
