package com.infoshareacademy.springdemo;

import com.infoshareacademy.springdemo.controller.TaskController;
import com.infoshareacademy.springdemo.model.Task;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDemoApplicationTests {

    @Autowired
    private TaskController taskController;

    @Test
    public void shouldGetAllPlaters(){
        List<Task> tasks = taskController.getAll();
        Assertions.assertThat(tasks).hasSize(2);
    }

    @Test
    public void shouldGetIdPlayer(){
        ResponseEntity<Task> taskResponseEntity = taskController.getById(2L);
        boolean status = taskResponseEntity.getStatusCode().is2xxSuccessful();
        Assertions.assertThat(status).isTrue();
    }

}

