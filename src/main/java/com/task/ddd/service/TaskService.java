package com.task.ddd.service;
import com.task.ddd.entity.*;
import com.task.ddd.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {
    @Transactional
    public Task assignEstimationLogEntriesToTask(
            Task task,
            List<EstimationLogEntry> estimationLogEntries) {
        TaskRepository taskRepository = new TaskRepository();
        return taskRepository.addEstLogs(task, estimationLogEntries);
    }
}