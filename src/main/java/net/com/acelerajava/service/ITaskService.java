package net.com.acelerajava.service;

import java.util.List;

import net.com.acelerajava.todo.model.Task;

public interface ITaskService {
    
    List<Task> getAllTasks();

    Task getTaskById(Long id);

    Task createTask(Task task);

    Task updateTaskById(Task task);

    void deleteTask(Long id);
}
