import java.util.ArrayList; 

public class TaskList {
	public ArrayList<TaskItem> tasks;

	// Constructor
	public TaskList() {tasks = new ArrayList<>();} // The list starts empty

	public int getSize() {return tasks.size();}

	public void addTask(String description, String title, int [] date) { 
		TaskItem task = new TaskItem(description, title, date);
		tasks.add(task);
	}

	public void addTaskFromFile(TaskItem task) {tasks.add(task);}
	
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
				System.out.print("\n"+ i + ") *** ");
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

	public String [] getTask(int index) {
		String [] task = new String[4];

		task[0] = tasks.get(index).getDateString(); //tasks.get(index).getTitle();
		task[1] = tasks.get(index).getTitle(); //tasks.get(index).getDescription();
		task[2] = tasks.get(index).getDescription(); //tasks.get(index).getDateString();
		task[3] = Boolean.toString(tasks.get(index).isCompleted());

		return task;
		//return tasks.get(index).getTaskString(index);
	}

	public void toggleCompleted(int index) {tasks.get(index).toggleCompleted();}

}
