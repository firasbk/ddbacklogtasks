package com.task.ddd.repository;
import com.task.ddd.entity.EstimationLogEntry;
import com.task.ddd.entity.Task;

import java.util.List;

public class TaskRepository {

    public Task addEstLogs( Task task, List<EstimationLogEntry> estimationLogEntries) {
        task.setEstimationLogEntries(estimationLogEntries);
        return task;
    }
}