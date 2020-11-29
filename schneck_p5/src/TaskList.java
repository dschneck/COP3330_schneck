import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TaskList {
	public ArrayList<TaskItem> tasks;

	// Constructor
	public TaskList() {tasks = new ArrayList<>();} // The list starts empty

	public int getSize() {return tasks.size();}

	public void addTask(String title, String description, String date) {
		tasks.add(new TaskItem(title, description, date));
	}

	public void addTaskFromFile(TaskItem task) {tasks.add(task);}
	
	public void removeTask(int index) {
		if (isValidIndex(index)) {
			tasks.remove(index);
		} else {
			throw new IndexOutOfBoundsException("You must pick a task index that is in the list\n");
		}
	}

	public void editTask(int index, String title, String description, String date) {
		if (isValidIndex(index)) { // TODO might be able to replace tasks.get(index) with task
			TaskItem task = tasks.get(index);

			if (task.isValidDate(task.dateToIntArray(date))) {
				tasks.get(index).setDate(date);
			} else {
				throw new InvalidDueDateException("Please enter the date in the following format: (YYYY-MM-DD)\n");
			}

			if (task.isValidTitle(title)) {
				tasks.get(index).setTitle(title);
			} else {
				throw new InvalidTitleException("The title must have at least one character\n");
			}

			tasks.get(index).setDescription(description);

		} else {
			throw new IndexOutOfBoundsException("You must pick a task index that is in the list\n");
		}

	}
	
	public void printList() {
		System.out.print("\n");
		for (int i = 0; i < tasks.size(); i++) {
			if ((tasks.get(i).isCompleted())) {
				System.out.print("\n"+ i + ") *** ");
			} else {
				System.out.print(i + ") ");
			}

			System.out.print(tasks.get(i).getDate() + " " + tasks.get(i).getTitle() + " " + tasks.get(i).getDescription() + "\n");
		}
		System.out.print("\n");
	}

	public void printCompleted() {
		System.out.print("\n");
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).isCompleted()) {
				System.out.print(i +") " + tasks.get(i).getDate() + " " + tasks.get(i).getTitle() + " " + tasks.get(i).getDescription() + "\n");
			}
		}
		System.out.print("\n");
	}

	public void printUncompleted() {
		System.out.print("\n");
		for (int i = 0; i < tasks.size(); i++) {
			if (!tasks.get(i).isCompleted()) {
				System.out.print(i +") " + tasks.get(i).getDate() + " " + tasks.get(i).getTitle() + " " + tasks.get(i).getDescription() + "\n");
			}
		}
		System.out.print("\n");
	}

	public String [] getTaskString(int index) {
		if (isValidIndex(index)) {
			String [] task = new String[4];

			task[0] = tasks.get(index).getDate(); //tasks.get(index).getTitle();
			task[1] = tasks.get(index).getTitle(); //tasks.get(index).getDescription();
			task[2] = tasks.get(index).getDescription(); //tasks.get(index).getDateString();
			task[3] = Boolean.toString(tasks.get(index).isCompleted());

			return task;
		} else {
			throw new IndexOutOfBoundsException("You must pick a task index that is in the list\n");
		}

		//return tasks.get(index).getTaskString(index);
	}

	public String getTaskDate(int index) {
		if (isValidIndex(index)) {
			TaskItem task = tasks.get(index);
			return task.getDate();
		} else {
			throw new IndexOutOfBoundsException("You must pick a task index that is in the list\n");
		}

		//return tasks.get(index).getTaskString(index);
	}

	public String getTaskTitle(int index) {
		if (isValidIndex(index)) {
			TaskItem task = tasks.get(index);
			return task.getTitle();
		} else {
			throw new IndexOutOfBoundsException("You must pick a task index that is in the list\n");
		}

	}

	public String getTaskDescription(int index) {
		if (isValidIndex(index)) {
			TaskItem task = tasks.get(index);
			return task.getDescription();
		} else {
			throw new IndexOutOfBoundsException("You must pick a task index that is in the list\n");
		}

	}

	public void toggleCompleted(int index) {
		if (isValidIndex(index)) {
			tasks.get(index).toggleCompleted();
		} else {
			throw new IndexOutOfBoundsException("You must pick a task index that is in the list\n");
		}


	}

	// Validate input
	public boolean isValidIndex(int index) {
		return !(index < 0 || index > this.getSize());
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
					ret = this.getTaskString(i);

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

