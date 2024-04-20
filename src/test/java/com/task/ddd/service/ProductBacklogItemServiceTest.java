package com.task.ddd.service;

import static org.junit.jupiter.api.Assertions.*;  // Import assertions for JUnit 5
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import com.task.ddd.entity.*;
import com.task.ddd.repository.BacklogItemRepository;
import com.task.ddd.service.ProductBacklogItemService;

import java.util.*;

@ExtendWith(SpringExtension.class)  // For Spring Boot context
@SpringBootTest  // Test class annotation to initialize Spring Boot context
public class ProductBacklogItemServiceTest {

    @Mock
    private BacklogItemRepository backlogItemRepository;

    @InjectMocks
    private ProductBacklogItemService productBacklogItemService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAssignSprintToBacklogItem() {
        SprintID sprintId = new SprintID("Sprint1");
        BacklogItem backlogItem = new BacklogItem();
        backlogItem.setId("BL123");

        when(backlogItemRepository.addBacklogItemSprint(sprintId, backlogItem)).thenReturn(backlogItem);

        BacklogItem result = productBacklogItemService.assignSprintToBacklogItem(sprintId, backlogItem);

        verify(backlogItemRepository, times(1)).addBacklogItemSprint(sprintId, backlogItem);
        assertEquals("BL123", result.getId());
        assertEquals(sprintId, result.sprintID());
    }

    @Test
    public void testAssignReleaseToBacklogItem() {
        ReleaseID releaseId = new ReleaseID();
        BacklogItem backlogItem = new BacklogItem();
        backlogItem.setId("BL123");

        when(backlogItemRepository.addBacklogItemRelease(releaseId, backlogItem)).thenReturn(backlogItem);

        BacklogItem result = productBacklogItemService.assignReleaseToBacklogItem(releaseId, backlogItem);

        verify(backlogItemRepository, times(1)).addBacklogItemRelease(releaseId, backlogItem);
        assertEquals("BL123", result.getId());
        assertEquals(releaseId, result.releaseID());
    }

    @Test
    public void testAssignTasksToBacklogItem() {
        Task task1 = new Task("Task1");
        Task task2 = new Task("Task2");
        List<Task> tasks = Arrays.asList(task1, task2);

        BacklogItem backlogItem = new BacklogItem();
        backlogItem.setId("BL123");

        when(backlogItemRepository.backlogItemTasks(tasks, backlogItem)).thenReturn(backlogItem);

        BacklogItem result = productBacklogItemService.assignTasksToBacklogItem(tasks, backlogItem);

        verify(backlogItemRepository, times(1)).backlogItemTasks(tasks, backlogItem);
        assertEquals("BL123", result.getId());
        assertEquals(2, result.getTasks().size());
    }
}
