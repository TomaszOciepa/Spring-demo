package com.infoshareacademy.springdemo.component;

import com.infoshareacademy.springdemo.model.Status;
import com.infoshareacademy.springdemo.model.Task;
import com.infoshareacademy.springdemo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;


@Component
public class InsertDataTask {

    private TaskRepository taskRepository;

    @Autowired
    public InsertDataTask(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostConstruct
    public void addTask(){
        Task task = new Task("first-Task", Status.FINISHED);
        taskRepository.save(task);

        Task task2 = new Task("second-Task", Status.IN_PROGRESS);
        taskRepository.save(task2);

    }
}
