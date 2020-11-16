import java.util.ArrayList; 

public class TaskList {
	
	
	// Constructor
	public TaskList(TaskItem initial) { // The task list can be empty
		ArrayList<TaskItem> tasks  = new ArrayList<TaskItem>();
	}

	public void addTask(String description, String title, int [] date) { 
		TaskItem task = new TaskItem(description, title, date);

		taskList.add(task);

	}
	
	public void removeTask(int index) {
		tasks.remove(index);
	}

	// TODO: decide how I want to format the input file
	public loadTaskList() {
		
	}
	
	public void printList() {
		for (int i = 0; i < tasks.size(); i++) {
			System.out.print(i +") ");
			tasks.get(i).printDate();
			System.out.print(" " + task.get(i).getTitle() + " " + tasks.get(i).getDescription() + "\n");
		}
	}
	public void printCompleted() 
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).isCompleted()) {
				System.out.print(i +") ");
				tasks.get(i).printDate();
				System.out.print(" " + task.get(i).getTitle() + " " + tasks.get(i).getDescription() + "\n");
			}

			else continue;
		}
	}

	public void printUncompleted() {
		for (int i = 0; i < tasks.size(); i++) {
			if (!tasks.get(i).isCompleted()) {
				System.out.print(i +") ");
				tasks.get(i).printDate();
				System.out.print(" " + task.get(i).getTitle() + " " + tasks.get(i).getDescription() + "\n");
			}
			else continue;
		}
	}


	public void toggleCompleted(int index) {
		// TODO decide om search algorithm to find pos
		tasks.get(index).toggleCompleted();
	}

}
