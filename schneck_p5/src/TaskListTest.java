import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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



	@Test
	public void editingTaskItemChangesValues() {
		TaskList taskList = new TaskList();
		taskList.addTask("COP 3330", "A very fun and interesting class", new int[]{2020, 12, 20});
		taskList.editTask(0,"COP 3330" , "It's cool!", new int[]{2020, 12, 20} );

		assertNotEquals("A very fun and interesting class", taskList.tasks.get(0).getDescription());
	}


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

	@Test
	public void editingTaskItemDueDateFailsWithInvalidIndex() {
		int[] orig = new int[]{2020, 12, 20};
		int[] edit = new int[]{2021, 6, 14};
		TaskList taskList = new TaskList();
		taskList.addTask("COP 3330", "A very fun and interesting class", orig);

		assertThrows(IndexOutOfBoundsException.class, () -> taskList.editTask(1,"COP 3330" , "It's cool!", edit ));

	}

	@Test
	public void editingTaskItemTitleChangesValue() {
		String orig = "Finish Project 4";
		TaskList taskList = new TaskList();
		taskList.addTask(orig, "A very fun and interesting class", new int[]{2020, 12, 20});
		taskList.editTask(0, "COP 3330", "A very fun and interesting class", new int[]{2020, 12, 20});

		assertNotEquals(orig, taskList.getTaskTitle(0));

	}

	@Test
	public void editingTaskItemTitleFailsWithInvalidIndex() {
		String orig = "Finish Project 4";
		TaskList taskList = new TaskList();
		taskList.addTask(orig, "A very fun and interesting class", new int[]{2020, 12, 20});

		assertThrows(IndexOutOfBoundsException.class, () -> taskList.editTask(1,"COP 3330" , "It's cool!", new int[]{2020, 12, 20} ));
	}

	@Test
	public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
		TaskList taskList = new TaskList();
		taskList.addTask("COP 3330", "A very fun and interesting class", new int[]{2020, 12, 20});

		assertThrows(IndexOutOfBoundsException.class, () -> taskList.getTaskDate(1));
	}

	@Test
	public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
		TaskList taskList = new TaskList();
		taskList.addTask("COP 3330", "A very fun and interesting class", new int[]{2020, 12, 20});

		assertDoesNotThrow(() -> taskList.getTaskDescription(0));
	}

	@Test
	public void gettingTaskItemDueDateFailsWithInvalidIndex() {
		TaskList taskList = new TaskList();
		taskList.addTask("COP 3330", "A very fun and interesting class", new int[]{2020, 12, 20});

		assertThrows(IndexOutOfBoundsException.class, () -> taskList.getTaskDate(1));
	}

	@Test
	public void gettingTaskItemDueDateSucceedsWithValidIndex() {
		TaskList taskList = new TaskList();
		taskList.addTask("COP 3330", "A very fun and interesting class", new int[]{2020, 12, 20});

		assertDoesNotThrow(() -> taskList.getTaskDate(0));
	}

	@Test
	public void gettingTaskItemTitleFailsWithInvalidIndex() {
		TaskList taskList = new TaskList();
		taskList.addTask("COP 3330", "A very fun and interesting class", new int[]{2020, 12, 20});

		assertThrows(IndexOutOfBoundsException.class, () -> taskList.getTaskTitle(1));
	}

	@Test
	public void gettingTaskItemTitleSucceedsWithValidIndex() {
		TaskList taskList = new TaskList();
		taskList.addTask("COP 3330", "A very fun and interesting class", new int[]{2020, 12, 20});

		assertDoesNotThrow(() -> taskList.getTaskTitle(0));
	}

	@Test
	public void newTaskListIsEmpty() {
		TaskList taskList = new TaskList();

		assertEquals(0, taskList.getSize());
	}

        @Test
        public void removingTaskItemsDecreasesSize() {
			TaskList taskList = new TaskList();
			taskList.addTask("COP 3330", "A very fun and interesting class", new int[]{2020, 12, 20});
			int curSize = taskList.getSize();
			taskList.removeTask(0);

			assertNotEquals(curSize, taskList.getSize());
        }

        @Test
        public void removingTaskItemsFailsWithInvalidIndex() {
			TaskList taskList = new TaskList();
			taskList.addTask("COP 3330", "A very fun and interesting class", new int[]{2020, 12, 20});

            assertThrows(IndexOutOfBoundsException.class, () -> taskList.removeTask(1));
        }
	/*
            @Test
            public void savedTaskListCanBeLoaded() {
                assertDoesNotThrow();
            }
        */
	@Test
	public void uncompletingTaskItemChangesStatus() {
		TaskList taskList = new TaskList();
		taskList.addTask("COP 3330", "A very fun and interesting class", new int[]{2020, 12, 20});
		taskList.toggleCompleted(0);

		assertNotEquals(false, taskList.tasks.get(0).isCompleted());
	}

	@Test
	public void uncompletingTaskItemFailsWithInvalidIndex() {
		TaskList taskList = new TaskList();
		taskList.addTask("COP 3330", "A very fun and interesting class", new int[]{2020, 12, 20});

		assertThrows(IndexOutOfBoundsException.class, () -> taskList.toggleCompleted(1));
	}
	
/*
	// Added with new assigment
	@Test
	public void addingItemsIncreasesSize() {}

	@Test
	public void completingTaskItemChangesStatus() {}

	@Test
	public void completingTaskItemFailsWithInvalidIndex() {}

	@Test
	public void editingItemDescriptionFailsWithInvalidIndex() {}

	@Test
	public void editingItemDescriptionSucceedsWithExpectedValues() {}

	@Test
	public void editingItemDueDateSucceedsWithExpectedValue() {}

	//@Test
	//public void editingItemTitleFailsWithEmptyString() {}

	@Test
	public void editingTitleFailsWithInvalidIndex() {}

	@Test
	public void editingTitleSucceedsWithExpectedValue() {}

	@Test
	public void editingTaskItemDueDateFailsWithInvalidDateFormat() {}

	@Test
	public void editingTaskItemDueDateFailsWithInvalidIndex() {}

	@Test
	public void editingTaskItemDueDateFailsWithInvalidYYYMMDD() {}

	@Test
	public void gettingItemDescriptionFailsWithInvalidInde() {}

	@Test
	public void gettingItemDescriptionSucceedsWithValidIndex() {}

	@Test
	public void gettingItemDueDateFailsWithInvalidIndex() {}

	@Test
	public void gettingItemDueDateSucceedsWithValidIndex() {}

	@Test
	public void gettingItemTitleFailsWithInvalidIndex() {}

	@Test
	public void gettingItemTitleSucceedsWIthValidIndex() {}

	@Test
	public void newListIsEmpty() {}

	@Test
	public void removingItemsDecreasesSize() {}

	@Test
	public void removingItemsFailWithInvalidIndex() {}

	@Test
	public void savedTaskListCanBeLoaded() {}

	@Test
	public void uncompletingTaskItemChangeStatus() {}

	@Test
	public void uncompletingTaskItemFailsWithInvalidIndex() {}
*/
}
