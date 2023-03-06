package com.lokesh.webclientconsumer.controller;

import com.lokesh.webclientconsumer.model.Task;
import com.lokesh.webclientconsumer.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/todos")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private ReactiveMongoTemplate mongoTemplate;

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/{emailId}")
    public Mono<Task> findTaskByEmailId(@PathVariable("emailId") String emailId) {
        return taskService.findTaskByEmailId(emailId);
    }
    @GetMapping("/tasks")
    public Flux<Task> getUserTask() {
//        return mongoTemplate.aggregate(Aggregation.newAggregation(
//                Aggregation.lookup("users", "user_id", "_id", "user"),
//                Aggregation.project()
//                        .and("task_title").as("title")
//                        .and("task_desc").as("description")
//                        .and("task_completed").as("completed")
//                        .and("name").as("userName")
//        ), "tasks", Task.class);

        return mongoTemplate.aggregate(
                Aggregation.newAggregation(
                        Aggregation.lookup("users", "user_id", "_id", "user"),
                        Aggregation.project("")
                ), "tasks", Task.class
        );
    }

//    @GetMapping(value = "/tasks/{id}")
//    public Task getTaskWithUser(@PathVariable String emailId) {
//        return this.taskService.getTasksWithUser(emailId);
//    }
}
