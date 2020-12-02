import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskList extends List {

	// Constructor
	public TaskList() {super(TaskItem.itemType);} // The list starts empty

	public void editTask(int index, String title, String description, String date) {
		if (isValidIndex(index)) {
			TaskItem task = (TaskItem) list.get(index);

			if (task.isValidDate(task.dateToIntArray(date))) {
				task.setDate(date);
			} else {
				throw new InvalidDueDateException("Please enter the date in the following format: (YYYY-MM-DD)\n");
			}

			if (task.isValidTitle(title)) {
				task.setTitle(title);
			} else {
				throw new InvalidTitleException("The title must have at least one character\n");
			}

			task.setDescription(description);

		} else {
			throw new IndexOutOfBoundsException("You must pick a task index that is in the list\n");
		}

	}
	
	public void printList() {
		System.out.print("\n");
		for (int i = 0; i < this.getSize(); i++) {
			TaskItem item = (TaskItem) list.get(i);

			if (item.isCompleted()) {
				System.out.print(i + ") *** ");
			} else {
				System.out.print(i + ") ");
			}

			System.out.print(item.getDate() + " " + item.getTitle() + ": " + item.getDescription() + "\n");
		}
		System.out.print("\n");
	}

	public void printCompleted() {
		System.out.print("\n");
		for (int i = 0; i < this.getSize(); i++) {
			TaskItem item = (TaskItem) list.get(i);

			if (item.isCompleted()) {
				System.out.print(i +") " + item.getDate() + " " + item.getTitle() + ": " + item.getDescription() + "\n");
			}
		}
		System.out.print("\n");
	}

	public void printUncompleted() {
		System.out.print("\n");
		for (int i = 0; i < this.getSize(); i++) {
			TaskItem item = (TaskItem) list.get(i);

			if (!item.isCompleted()) {
				System.out.print(i +") " + item.getDate() + " " + item.getTitle() + ": " + item.getDescription() + "\n");
			}
		}
		System.out.print("\n");
	}

	public String [] getItemString(int index) {
		if (isValidIndex(index)) {
			TaskItem item = (TaskItem) list.get(index);
			String [] task = new String[4];

			task[0] = item.getDate(); //tasks.get(index).getTitle();
			task[1] = item.getTitle(); //tasks.get(index).getDescription();
			task[2] = item.getDescription(); //tasks.get(index).getDateString();
			task[3] = Boolean.toString(item.isCompleted());

			return task;
		} else {
			throw new IndexOutOfBoundsException("You must pick a contact index that is in the list\n");
		}
	}

	public String getTaskDate(int index) {
		if (isValidIndex(index)) {
			TaskItem task = (TaskItem) list.get(index);
			return task.getDate();
		} else {
			throw new IndexOutOfBoundsException("You must pick a task index that is in the list\n");
		}
	}

	public String getTaskTitle(int index) {
		if (isValidIndex(index)) {
			TaskItem task = (TaskItem) list.get(index);
			return task.getTitle();
		} else {
			throw new IndexOutOfBoundsException("You must pick a task index that is in the list\n");
		}

	}

	public String getTaskDescription(int index) {
		if (isValidIndex(index)) {
			TaskItem task = (TaskItem) list.get(index);
			return task.getDescription();
		} else {
			throw new IndexOutOfBoundsException("You must pick a task index that is in the list\n");
		}

	}

	public void toggleCompleted(int index) {
		if (isValidIndex(index)) {
			TaskItem task = (TaskItem) list.get(index);
			task.toggleCompleted();
		} else {
			throw new IndexOutOfBoundsException("You must pick a task index that is in the list\n");
		}


	}

	public void saveToFile(String filename) {
		File file = new File(filename);
		boolean isValidFile = false;

		do {
			try {
				FileWriter fileWriter = new FileWriter(file);

				fileWriter.write(Integer.toString(this.getSize()) + "\n");
				String[] ret;

				for (int i = 0; i < this.getSize(); i++) {
					ret = this.getItemString(i);

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
}

