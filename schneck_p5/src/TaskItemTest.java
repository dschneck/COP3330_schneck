import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TaskItemTest {

	@Test
	public void creatingTaskItemFailsWithInvalidDueDate() {

		assertThrows(InvalidDueDateException.class, () -> new TaskItem("Do homework", "OOP assignment","1-20-12"));
	}

	@Test
	public void creatingTaskItemFailsWithInvalidTitle() {
		assertThrows(InvalidTitleException.class, () -> new TaskItem("", "oops", "2020-11-10"));
	}

	@Test 
	public void creatingTaskItemSucceedsWithValidDueDate() {
		assertDoesNotThrow(() -> new TaskItem("Do homework", "OOP assignment", "2020-11-10"));
	}

	@Test 
	public void creatingTaskItemSucceedsWithValidTitle() {
		assertDoesNotThrow(() -> new TaskItem("Do homework", "OOP assignment", "2020-11-10"));
	}

	@Test
	public void settingTaskItemDueDateFailsWithInvalidDate() {
		TaskItem task = new TaskItem("Do homework", "OOP assignment", "2020-11-10");

		assertThrows(InvalidDueDateException.class, () -> task.setDate("122-20-14"));
	}

	@Test
	public void settingTaskItemDueDateSucceedsWithValidDate() {
		TaskItem task = new TaskItem("Do homework", "OOP assignment", "2020-11-10");
		String otherValidDate = "2019-12-24";

		assertDoesNotThrow(() -> task.setDate(otherValidDate));
	}

	@Test 
	public void settingTaskItemTitleFailsWithInvalidTitle() {
		TaskItem task = new TaskItem("Do homework", "OOP assignment", "2020-11-10");

		assertThrows(InvalidTitleException.class, () -> task.setTitle(""));
	}

	@Test 
	public void settingTaskItemTitleSucceedsWithValidTitle() {
		TaskItem task = new TaskItem("Do homework", "OOP assignment", "2020-11-10");

		assertDoesNotThrow(() -> task.setTitle("OOP can be hard"));
	}

}
