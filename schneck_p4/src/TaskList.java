import java.util.ArrayList; 

public class TaskList {
	public ArrayList<TaskItem> tasks;

	// Constructor
	public TaskList() {tasks = new ArrayList<>();} // The list starts empty

	public void addTask(String description, String title, int [] date) { 
		TaskItem task = new TaskItem(description, title, date);
		tasks.add(task);
	}
	
	public void removeTask(int index) {tasks.remove(index);}

	public void editTask(int index, String title, String description, int [] date) { //index, title, description, date
		tasks.get(index).setDate(date);
		tasks.get(index).setTitle(title);
		tasks.get(index).setDescription(description);
	}


	// TODO: decide how I want to format the input file
	public void loadTaskList() {
		
	}
	
	public void printList() {
		for (int i = 0; i < tasks.size(); i++) {
			if ((tasks.get(i).isCompleted())) {
				System.out.print(i + ") *** ");
			} else {
				System.out.print(i + ") ");
			}

			tasks.get(i).printDate();
			System.out.print(" " + tasks.get(i).getTitle() + " " + tasks.get(i).getDescription() + "\n");
		}
		System.out.print("\n");
	}
	public void printCompleted() {
		System.out.print("\n");
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).isCompleted()) {
				System.out.print(i +") ");
				tasks.get(i).printDate();
				System.out.print(" " + tasks.get(i).getTitle() + " " + tasks.get(i).getDescription() + "\n");
			}
		}
		System.out.print("\n");
	}

	public void printUncompleted() {
		System.out.print("\n");
		for (int i = 0; i < tasks.size(); i++) {
			if (!tasks.get(i).isCompleted()) {
				System.out.print(i +") ");
				tasks.get(i).printDate();
				System.out.print(" " + tasks.get(i).getTitle() + " " + tasks.get(i).getDescription() + "\n");
			}
		}
		System.out.print("\n");
	}

	public void toggleCompleted(int index) {tasks.get(index).toggleCompleted();}

}
