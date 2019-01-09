package com.infoshareacademy.springdemo.controller;

import com.infoshareacademy.springdemo.model.Status;
import com.infoshareacademy.springdemo.model.Task;
import com.infoshareacademy.springdemo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @GetMapping
    public List<Task> getAll(){
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable Long id) {
        return taskRepository.findById(id)
                .map(player -> ResponseEntity.ok().body(player))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id){
        taskRepository.deleteById(id);
    }

    @GetMapping("/status/{status}")
    public List<Task> getStatus(@PathVariable Status status ){
        return taskRepository.findAllByStatus(status);
    }

    @PutMapping("/{id}/{status}")
    public ResponseEntity changeStatus(@PathVariable long id, @PathVariable Status status){
         Optional<Task> optionalTask = taskRepository.findById(id);
         if(optionalTask.isPresent()){
             Task task = optionalTask.get();
             task.setStatus(status);
             taskRepository.save(task);
             return ResponseEntity.ok().build();
         }else {
             return ResponseEntity.notFound().build();
         }
    }
}
