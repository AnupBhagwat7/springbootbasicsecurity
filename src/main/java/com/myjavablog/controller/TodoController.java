package com.myjavablog.controller;

import com.myjavablog.model.Todo;
import com.myjavablog.model.User;
import com.myjavablog.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping(produces = "application/json")
    @RequestMapping({ "/validateLogin" })
    public User validateLogin()
    {
        return new User("User successfully authenticated");
    }

    @GetMapping("/todos")
    public List<Todo> getTodos(){
        return getTodoList();
    }

    public static List<Todo> getTodoList(){

        List<Todo> list = new ArrayList<>();
        list.add(new Todo("Play", "Badminton at 6 am", "Pending"));
        list.add(new Todo("Play", "Cricket at 7 am", "Pending"));
        list.add(new Todo("Play", "Football at 8 am", "Pending"));
        list.add(new Todo("Play", "Cards at 6 am", "Pending"));
        list.add(new Todo("Play", "TT at 6 am", "Pending"));
        list.add(new Todo("Play", "Golf at 6 am", "Pending"));
        list.add(new Todo("Play", "Running at 6 am", "Pending"));
        list.add(new Todo("Play", "Walking at 6 am", "Pending"));
        list.add(new Todo("Play", "Swimming at 6 am", "Pending"));
        list.add(new Todo("Play", "Reading at 6 am", "Pending"));

        return list;
    }

    @GetMapping("/todo/{id}")
    public Optional<Todo> getTodo(@PathVariable Long id)
    {
        return todoRepository.findById(id);
    }

    @DeleteMapping("/todo/{id}")
    public boolean deleteTodo(@PathVariable Long id){
        todoRepository.deleteById(id);
        return true;
    }

    @PostMapping("/todo")
    public Todo createTodo(@RequestBody Todo todo){

        return todoRepository.save(todo);
    }

    @PutMapping("/todo")
    public Todo updateTodo(@RequestBody Todo todo){
        return todoRepository.save(todo);
    }

}
