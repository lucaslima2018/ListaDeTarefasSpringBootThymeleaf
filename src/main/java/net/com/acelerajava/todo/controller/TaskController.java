package net.com.acelerajava.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.com.acelerajava.todo.model.Task;
import net.com.acelerajava.todo.service.TaskService;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/tasks")
public class TaskController {
    
    private final TaskService taskService;
    // private final JwtTokenProvider tokenProvider;

    @Autowired
    public TaskController(TaskService taskService/* , JwtTokenProvider tokenProvider*/){
        this.taskService = taskService;
        // this.tokenProvider = tokenProvider;
    }


    @GetMapping()
    public String showTasks(Model model){
        Task task = TaskService.populate(model);
        model.addAttribute("task", task);
        model.addAttribute("tasks", this.taskService.getAllTasks());
        return "layout";
    }

    @GetMapping("/edit/{id}")
    public String editTask(RedirectAttributes attributes, @PathVariable("id") Long id) {
        attributes.addFlashAttribute("taskForEdit", this.taskService.findTaskById(id));
        return "redirect:/tasks";
    }

    @PostMapping("/save")
    public String saveTask(Task task){
        this.taskService.createTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id){
        this.taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}
