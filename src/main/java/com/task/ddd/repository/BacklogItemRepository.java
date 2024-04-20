package com.task.ddd.repository;

import com.task.ddd.entity.BacklogItem;
import com.task.ddd.entity.ReleaseID;
import com.task.ddd.entity.SprintID;
import com.task.ddd.entity.Task;

import java.util.List;

public class BacklogItemRepository {
    public BacklogItem backlogItemTasks(List<Task> tasks, BacklogItem
            backlogItemObj) {
            backlogItemObj.setTasks(tasks);

        return backlogItemObj;
    }

    public BacklogItem addBacklogItemRelease(ReleaseID releaseId, BacklogItem
            backlogItemObj) {
        backlogItemObj.setReleaseID(releaseId);

        return backlogItemObj;
    }

    public BacklogItem addBacklogItemSprint(SprintID sprintId, BacklogItem
            backlogItemObj) {
        backlogItemObj.setSprintID(sprintId);

        return backlogItemObj;
    }
}
