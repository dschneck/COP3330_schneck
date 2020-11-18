import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// I think that these are more straightforward calls to methods
// in the TaskList


// invalid index
public class TaskListTest {
	@Test
	public void addingTaskItemsIncreasesSize() {
		TaskList taskList = new TaskList();
		taskList.addTask("COP 3330", "A very fun and interesting class", new int[]{2020, 12, 20});

		assertEquals(1, taskList.getSize());
	}

	@Test
	public void completingTaskItemChangesStatus() {
		TaskList taskList = new TaskList();
		taskList.addTask("COP 3330", "A very fun and interesting class", new int[]{2020, 12, 20});

		taskList.tasks.get(0).toggleCompleted();
		assertEquals(true, taskList.tasks.get(0).isCompleted());
	}

	@Test
	public void completingTaskItemFailsWithInvalidIndex() {
		TaskList taskList = new TaskList();
		taskList.addTask("COP 3330", "A very fun and interesting class", new int[]{2020, 12, 20});

		assertThrows(IndexOutOfBoundsException.class, () -> taskList.toggleCompleted(1));
	}


	/*
	@Test
	public void editingTaskItemChangesValues() {
		TaskList taskList = new TaskList();
		taskList.addTask("COP 3330", "A very fun and interesting class", new int[]{2020, 12, 20});
		taskList.editTask(0,"COP 3330" , "It's cool!", new int[]{2020, 12, 20} );

		assertEquals("A very fun and interesting class", taskList.tasks.get(0).getDescription());
	}
	*/

	@Test
	public void editingTaskItemDescriptionChangesValue() {
		TaskList taskList = new TaskList();
		taskList.addTask("COP 3330", "A very fun and interesting class", new int[]{2020, 12, 20});
		taskList.editTask(0,"COP 3330" , "It's cool!", new int[]{2020, 12, 20} );

		assertNotEquals("A very fun and interesting class", taskList.tasks.get(0).getDescription());
	}


	@Test
	public void editingTaskItemDescriptionFailsWithInvalidIndex() {
		TaskList taskList = new TaskList();
		taskList.addTask("COP 3330", "A very fun and interesting class", new int[]{2020, 12, 20});

		assertThrows(IndexOutOfBoundsException.class, () -> taskList.editTask(1,"COP 3330" , "It's cool!", new int[]{2020, 12, 20} ));
	}

	@Test
	public void editingTaskItemDueDateChangesValue() {
		int[] orig = new int[]{2020, 12, 20};
		int[] edit = new int[]{2021, 6, 14};
		TaskList taskList = new TaskList();
		taskList.addTask("COP 3330", "A very fun and interesting class", orig);
		taskList.editTask(0, "COP 3330", "A very fun and interesting class", edit);

		for (int i = 0; i < orig.length; i++) {
			assertNotEquals(orig[i], taskList.getTaskDate(0)[i]);
		}
	}
/*
	@Test
	public void editingTaskItemDueDateFailsWithInvalidIndex() {
		assertThrows();
	}

	@Test
	public void editingTaskItemTitleChangesValue() {
		assertDoesNotThrow();
	}

	@Test
	public void editingTaskItemTitleFailsWithInvalidIndex() {
		assertThrows();
	}

	@Test
	public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
		assertThrows();
	}

	@Test
	public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
		assertDoesNotThrow();
	}

	@Test
	public void gettingTaskItemDueDateFailsWithInvalidIndex() {
		assertThrows();
	}

	@Test
	public void gettingTaskItemDueDateSucceedsWithValidIndex() {
		assertDoesNotThrow();
	}

	@Test
	public void gettingTaskItemTitleFailsWithInvalidIndex() {
		assertThrows();
	}

	@Test
	public void gettingTaskItemTitleSucceedsWithValidIndex() {
		assertDoesNotThrow();
	}

	@Test
	public void newTaskListIsEmpty() {
		assertDoesNotThrow();
	}

	@Test
	public void removingTaskItemsDecreasesSize() {
		assertDoesNotThrow();
	}

	@Test
	public void removingTaskItemsFailsWithInvalidIndex() {
		assertThrows();
	}

	@Test
	public void savedTaskListCanBeLoaded() {
		assertDoesNotThrow();
	}

	@Test
	public void uncompletingTaskItemChangesStatus() {
		assertDoesNotThrow();
	}

	@Test
	public void uncompletingTaskItemFailsWithInvalidIndex() {
		assertThrows();
	}
*/


}
