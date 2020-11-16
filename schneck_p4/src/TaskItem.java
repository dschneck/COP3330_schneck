public class TaskItem {
	private String title;
	private String description;
	private int date[];
	private boolean completed;

	public TaskItem(String title, String description, int [] date) {
		this.title = title;
		this.description = description;
		
		this.date[] = new int[3];

		this.date[0] = date[0]; //month
		this.date[1] = date[1]; //day
		this.date[2] = date[2];  //year

		this.completed = false;
	}


	// Getters
	public String getTitle() {return this.title;}
	public String getDescription() {return this.description;}
	public boolean isCompleted() {return this.completed;}

	public void printDate(){System.out.print("[" + Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day) + "]");}

	// Setters
	public void setTitle(String newTitle) {} // TODO
	public void setDescription (String newDescription) {} // TODO
	public void setDate(int newMonth, int newDay, int newYear) {} // TODO
	public void toggleCompleted() {this.completed = !this.completed;}

}	
