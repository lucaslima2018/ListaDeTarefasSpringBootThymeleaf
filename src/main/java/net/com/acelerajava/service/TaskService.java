package net.com.acelerajava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import net.com.acelerajava.repository.TaskRepository;
import net.com.acelerajava.todo.model.Task;

@Service
public class TaskService implements ITaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return (List<Task>) this.taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        return optionalTask.orElse(null);
    }

    @Override
    public Task createTask(Task task) {
        return this.taskRepository.save(task);
    }

    @Transactional
    @Override
    public Task updateTaskById(Task task) {
        if (this.taskRepository.existsById(task.getId())){
            return this.taskRepository.save(task);
        }
        return task;
        
    }

    @Override
    public void deleteTask(Long id) {
        this.taskRepository.deleteById(id);
    }
    
}
