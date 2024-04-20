package com.task.ddd.service;
import com.task.ddd.entity.*;
import com.task.ddd.repository.BacklogItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductBacklogItemService {
    @Transactional
    public BacklogItem assignSprintToBacklogItem(SprintID sprintId, BacklogItem backlogItem) {
        BacklogItemRepository backlogItemRepository = new BacklogItemRepository();
        return backlogItemRepository.addBacklogItemSprint(sprintId, backlogItem);

    }
    @Transactional
    public BacklogItem assignReleaseToBacklogItem(ReleaseID releaseID, BacklogItem backlogItem) {
        BacklogItemRepository backlogItemRepository = new BacklogItemRepository();
        return backlogItemRepository.addBacklogItemRelease(releaseID, backlogItem);
    }
    @Transactional
    public BacklogItem assignTasksToBacklogItem(List<Task> tasks, BacklogItem backlogItem) {
        BacklogItemRepository backlogItemRepository = new BacklogItemRepository();
        return backlogItemRepository.backlogItemTasks(tasks, backlogItem);
    }
}