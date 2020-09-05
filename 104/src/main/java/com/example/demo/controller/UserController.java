package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    Map<Long, User> users = new HashMap<>();

    @PostConstruct
    public void init() throws Exception {
        users.put(Long.valueOf(1), new User(1, "Song", 39));
        users.put(Long.valueOf(2), new User(2, "Vijay", 29));
    }

    @GetMapping("/list")
    public Flux<User> getAll() {
        return Flux.fromIterable(users.entrySet().stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable Long id) {
        return Mono.justOrEmpty(users.get(id));
    }

    @PostMapping("")
    public Mono<ResponseEntity<String>> addUser(User user) {
        users.put(user.getId(), user);
        return Mono.just(new ResponseEntity<>("Successfully added", HttpStatus.CREATED));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<User>> putUser(@PathVariable Long id, User user) {
        user.setId(id);
        users.put(id, user);
        return Mono.just(new ResponseEntity<>(user, HttpStatus.CREATED));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<String>> deleteUser(@PathVariable Long id) {
        users.remove(id);
        return Mono.just(new ResponseEntity<>("Successfully deleted", HttpStatus.ACCEPTED));
    }
}