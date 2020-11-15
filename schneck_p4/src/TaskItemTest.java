import  org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest { 
	@Test
	public void creatingTaskItemFailsWithInvalidDueDate(){}

	@Test
	public void creatingTaskItemFailsWithInvalidTitle(){}

	@Test 
	public void creatingTaskItemSucceedsWithValidDueDate(){}

	@Test 
	public void creatingTaskItemSucceedsWithValidTitle(){}

	@Test
	public void settingTaskItemDueDateFailsWithInvalidDate(){}

	@Test
	public void settingTaskItemDueDateSucceedsWithValidDate(){}

	@Test 
	public void settingTaskItemTitleFailsWithInvalidTitle(){}

	@Test 
	public void settingTaskItemTitleSucceedsWithValidTitle(){}
}
