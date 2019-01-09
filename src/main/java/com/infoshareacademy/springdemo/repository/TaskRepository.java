package com.infoshareacademy.springdemo.repository;

import com.infoshareacademy.springdemo.model.Status;
import com.infoshareacademy.springdemo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByStatus(Status status);
}
