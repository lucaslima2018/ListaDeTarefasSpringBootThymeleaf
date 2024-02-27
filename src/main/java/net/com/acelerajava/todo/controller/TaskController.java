package net.com.acelerajava.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import net.com.acelerajava.provider.JwtTokenProvider;
import net.com.acelerajava.service.TaskService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.jsonwebtoken.Claims;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@Controller
@RequestMapping("/api/todo")
public class TaskController {
    
    private final TaskService taskService;
    // private final JwtTokenProvider tokenProvider;

    @Autowired
    public TaskController(TaskService taskService/* , JwtTokenProvider tokenProvider*/){
        this.taskService = taskService;
        // this.tokenProvider = tokenProvider;
    }


    @GetMapping(produces = "application/json")    
    // public ResponseEntity<List<Task>> getAllTask(@RequestHeader("Autorization") String token) {
    //     if(token == null || !token.startsWith("Bearer ")) {
    //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    //     }

    //     String jwtToken = token.substring(7);
    //     Claims claims - tokenProvider.validateToken(jwtToken);
    //     if(claims == null){
    //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    //     }

    //     List<Task> tasks = taskService.getAllTasks();
    //     return ResponseEntity.ok(tasks);
    // }
    public TaskController getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public TaskController getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    @PostMapping
    public TaskController createTask(@RequestBody TaskController task){
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public TaskController updateTaskByI(@RequestBody TaskController task){
        return taskService.getTaskById(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
