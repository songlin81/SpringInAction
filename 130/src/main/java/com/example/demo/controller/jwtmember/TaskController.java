package com.example.demo.controller.jwtmember;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jwt/tasks")
public class TaskController {

    @GetMapping
    public String listTasks(){
        return "Task list";
    }

    @PostMapping

    @PreAuthorize("hasRole('USER')")
    public String newTasks(){
        return "ROLE, create a new task";
    }

    @PutMapping("/{taskId}")
    public String updateTasks(@PathVariable("taskId")Integer id){
        return "Update id: "+id;
    }

    @DeleteMapping("/{taskId}")
    public String deleteTasks(@PathVariable("taskId")Integer id){
        return "delete id:"+id;
    }
}
