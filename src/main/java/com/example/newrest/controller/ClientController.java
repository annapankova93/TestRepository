package com.example.newrest.controller;

import com.example.newrest.model.User;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    @PostMapping(value = "/")
    public ResponseEntity<?> create(@Valid @RequestBody User newuser, BindingResult result) {
        if (newuser.getLogin() == null || newuser.getPassword() == null || newuser.getLogin().isEmpty() || newuser.getPassword().isEmpty()) {
            return new ResponseEntity<>("500: Incorrect data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        newuser.setRegistrationDate();
        return new ResponseEntity<>(newuser, HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<String> getString() {
        String response = "{\n\"Request success\"\n}";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}