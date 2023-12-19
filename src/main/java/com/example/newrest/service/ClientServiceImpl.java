package com.example.newrest.service;

import com.example.newrest.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ClientServiceImpl implements ClientService {

    // Хранилище клиентов
    private static final List<Client> CLIENT_REPOSITORY_LIST = new ArrayList<>();

    @Override
    public void create(Client client) {
        CLIENT_REPOSITORY_LIST.add(client);
    }

    @Override
    public List<Client> readAll() {
        return new ArrayList<>(CLIENT_REPOSITORY_LIST);
    }
}
