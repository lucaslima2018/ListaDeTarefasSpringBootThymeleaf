package net.com.acelerajava.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import net.com.acelerajava.todo.model.Task;
import net.com.acelerajava.todo.repository.TaskRepository;

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
    public Task findTaskById(Long id) {
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        return optionalTask.orElse(null);
    }

    @Override
    public Task createTask(Task task) {
        return this.taskRepository.save(task);
    }    

    @Override
    public void deleteTask(Long id) {
        this.taskRepository.deleteById(id);
    }

    public static Task populate(Model model) {
        if (model.containsAttribute("taskForEdit")) {
            return (Task) model.getAttribute("taskForEdit");
        }
        return new Task();
    }    
}
