public class TaskItem {
	private String title;
	private String description;
	private int month, day, year;
	
	public TaskItem(String title, String description, int month, int day, int year) {
		this.title = title;
		this.description = description;

		this.month = month;
		this.day = day;
		this.year = year;
		
	}


	// Getters
	public String title() {return this.title;}
	
	// Setters
	public void setTitle;

	public void printDate(){System.out.println("[" + Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day) + "]");}
}
