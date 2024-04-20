package com.task.ddd;

import com.task.ddd.entity.BacklogItem;
import com.task.ddd.entity.EstimationLogEntry;
import com.task.ddd.entity.SprintID;
import com.task.ddd.entity.Task;
import com.task.ddd.service.ProductBacklogItemService;
import com.task.ddd.service.TaskService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DddApplication {

	public static void main(String[] args) {


		BacklogItem backlogItem = new BacklogItem();
		backlogItem.setId("BL123");
		SprintID sprintId = new SprintID("Sprint1");

		ProductBacklogItemService productBacklogItemService = new ProductBacklogItemService();
		BacklogItem backlogItemFinal = productBacklogItemService.assignSprintToBacklogItem(sprintId, backlogItem);
		System.out.println("backlogItemFinal of SprintID = " + backlogItemFinal.getSprintID().getId()); //backlogItemFinal of SprintID = Sprint1

		Task task1 = new Task("Task1");
		Task task2 = new Task("Task2");
		List<Task> tasks = Arrays.asList(task1, task2);

		BacklogItem backlogItemN = new BacklogItem();
		backlogItemN.setId("BL123");
		BacklogItem backlogItemWithTasks = productBacklogItemService.assignTasksToBacklogItem(tasks, backlogItemN);
		System.out.println("backlogItemWithTasks of tasks number = " + backlogItemWithTasks.getTasks().size()); // backlogItemWithTasks of tasks number = 2

		TaskService taskService = new TaskService();
		Task task = new Task("1");
		task.setName("Task One");

		EstimationLogEntry estimationLogEntry = new EstimationLogEntry();
		estimationLogEntry.setName("Initial Estimation");
		estimationLogEntry.setDescription("First estimation");
		estimationLogEntry.setHourRemaining(10);
		estimationLogEntry.setVolunteer("volunteer1");

		EstimationLogEntry estimationLogEntrySecond = new EstimationLogEntry();
		estimationLogEntrySecond.setName("2estimation");
		estimationLogEntrySecond.setDescription("Second estimation");
		estimationLogEntrySecond.setHourRemaining(5);
		estimationLogEntrySecond.setVolunteer("volunteer2");

		List<EstimationLogEntry> estimationLogEntries = Arrays.asList(estimationLogEntry, estimationLogEntrySecond);

		taskService.assignEstimationLogEntriesToTask(task, estimationLogEntries);
		Task updatedTask = taskService.assignEstimationLogEntriesToTask(task, estimationLogEntries);

		System.out.println("Name of Task = " + updatedTask.getName()); // Name of Task = Task One
		System.out.println("Task has " + updatedTask.getEstimationLogEntries().size() + " Estimation Log Entries"); // Task has 2 Estimation Log Entries

	}

}
