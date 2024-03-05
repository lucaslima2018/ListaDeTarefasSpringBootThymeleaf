package net.com.acelerajava.todo.service;

import java.util.List;

import net.com.acelerajava.todo.model.Task;

public interface ITaskService {
    
    List<Task> getAllTasks();

    Task findTaskById(Long id);

    Task createTask(Task task);    

    void deleteTask(Long id);
}
