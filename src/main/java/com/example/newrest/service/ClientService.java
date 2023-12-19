package com.example.newrest.service;

import com.example.newrest.model.Client;

import java.util.List;

public interface ClientService {


    void create(Client client);
    List<Client> readAll();

}
