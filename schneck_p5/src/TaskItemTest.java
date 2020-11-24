import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TaskItemTest {
	// Reusable date that works
	int [] ValidDate = {2020, 11, 10};

	@Test
	public void creatingTaskItemFailsWithInvalidDueDate() {
		int [] InvalidDate = {1 , 20, 12};

		assertThrows(InvalidDueDateException.class, () -> new TaskItem("Do homework", "OOP assignment", InvalidDate));
	}

	@Test
	public void creatingTaskItemFailsWithInvalidTitle() {
		assertThrows(InvalidTitleException.class, () -> new TaskItem("", "oops", ValidDate));
	}

	@Test 
	public void creatingTaskItemSucceedsWithValidDueDate() {
		assertDoesNotThrow(() -> new TaskItem("Do homework", "OOP assignment", ValidDate));
	}

	@Test 
	public void creatingTaskItemSucceedsWithValidTitle() {
		assertDoesNotThrow(() -> new TaskItem("Do homework", "OOP assignment", ValidDate));
	}

	@Test
	public void settingTaskItemDueDateFailsWithInvalidDate() {
		TaskItem task = new TaskItem("Do homework", "OOP assignment", ValidDate);
		int [] InvalidDate = {122, 20, 14};

		assertThrows(InvalidDueDateException.class, () -> task.setDate(InvalidDate));
	}

	@Test
	public void settingTaskItemDueDateSucceedsWithValidDate() {
		TaskItem task = new TaskItem("Do homework", "OOP assignment", ValidDate);
		int [] otherValidDate = {2019, 12, 24};

		assertDoesNotThrow(() -> task.setDate(otherValidDate));
	}

	@Test 
	public void settingTaskItemTitleFailsWithInvalidTitle() {
		TaskItem task = new TaskItem("Do homework", "OOP assignment", ValidDate);

		assertThrows(InvalidTitleException.class, () -> task.setTitle(""));
	}

	@Test 
	public void settingTaskItemTitleSucceedsWithValidTitle() {
		TaskItem task = new TaskItem("Do homework", "OOP assignment", ValidDate);

		assertDoesNotThrow(() -> task.setTitle("OOP can be hard"));
	}

	// Added for the new assignment
	@Test
	public void constructorFailsWIthInvalidDueDate() {}

	@Test
	public void constructorFailsWIthInvalidTitle() {}
	
	@Test
	public void constructorSucceedsWithValidDueDate() {}

	@Test
	public void constructorSucceedsWithValidTitle() {}

	@Test
	public void editingDescriptionSucceedsWithExpectedValue() {}

	@Test
	public void editingDueDateFailsWithInvalidDateForm() {}

	@Test
	public void editingDueDateFailsWithInvalidYYYYMMDDFormat() {}

	@Test
	public void editingDueDateExceedsWithExpectedValue() {}

	@Test
	public void editingTitleFailsWithEmptyString() {}

	@Test
	public void editingTitlSucceedsWithExpectedValue() {}










}
