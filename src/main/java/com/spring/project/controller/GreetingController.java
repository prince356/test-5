package com.spring.project.controller;

import com.spring.project.dto.GreetingDTO;
import com.spring.project.dto.UserDTO;
import com.spring.project.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
    @Autowired
    private IGreetingService greetingService;

    @PostMapping("")
    public GreetingDTO getGreeting(@RequestParam(value = "firstName", defaultValue = "", required = false) String firstName, @RequestParam(value = "lastName", defaultValue = "", required = false) String lastName) {
        UserDTO user = new UserDTO();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.addGreeting(user);
    }

    @GetMapping("/{id}")
    public GreetingDTO getGreetingById(@PathVariable(value = "id") long id) {
        return greetingService.getGreetingById(id);
    }

    @GetMapping("/all")
    public Iterable<GreetingDTO> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @PutMapping("/edit/{id}")
    public GreetingDTO editGreeting(@PathVariable(value = "id") long id, @RequestParam(value = "firstName", defaultValue = "", required = false) String firstName, @RequestParam(value = "lastName", defaultValue = "", required = false) String lastName) {
        UserDTO user = new UserDTO();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.editGreeting(id, user);
    }
}