package com.example.newrest.controller;

import com.example.newrest.model.Client;
import com.example.newrest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Client client) {
        client.setRegistrationDate();
        clientService.create(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

    @GetMapping(value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getString() {
        String response = "{\n\"Request success\"\n}";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}