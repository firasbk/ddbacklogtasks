package com.task.ddd.service;

import com.task.ddd.entity.Task;
import com.task.ddd.entity.EstimationLogEntry;
import com.task.ddd.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TaskServiceTest {

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void testAssignEstimationLogEntriesToTask() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);

        // Arrange
        Task task = new Task("1");

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

        Mockito.when(taskRepository.addEstLogs(task, estimationLogEntries))
                .thenReturn(task);

        // Act
        Task updatedTask = taskService.assignEstimationLogEntriesToTask(task, estimationLogEntries);

        // Assert
        assertThat(updatedTask).isEqualTo(task); // Ensure the returned task is as expected

        List<EstimationLogEntry> assignedEntries = updatedTask.getEstimationLogEntries();
        assertThat(assignedEntries).isNotNull().hasSize(2); // Ensure the list is not null and has the correct number of entries

        // Check that the values in the assigned entries are correct
        assertThat(assignedEntries.get(0).getName()).isEqualTo("Initial Estimation");
        assertThat(assignedEntries.get(0).getDescription()).isEqualTo("First estimation");
        assertThat(assignedEntries.get(0).getHourRemaining()).isEqualTo(10);
        assertThat(assignedEntries.get(0).getVolunteer()).isEqualTo("volunteer1");

        assertThat(assignedEntries.get(1).getName()).isEqualTo("2estimation");
        assertThat(assignedEntries.get(1).getDescription()).isEqualTo("Second estimation");
        assertThat(assignedEntries.get(1).getHourRemaining()).isEqualTo(5);
        assertThat(assignedEntries.get(1).getVolunteer()). isEqualTo("volunteer2");

        // Verify that the repository method was called with correct arguments
        Mockito.verify(taskRepository).addEstLogs(task, estimationLogEntries);
    }
}