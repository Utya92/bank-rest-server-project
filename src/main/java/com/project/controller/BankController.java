package com.project.controller;

import com.project.custom_exception_handler.NoSuchClientException;
import com.project.entity.Client;
import com.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public List<Client> showAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/client/{id}")
    public Client getClientByID(@PathVariable int id) {
        Client client = clientService.getClient(id);
        if (client == null) {
            throw new NoSuchClientException("client with id " + id + " doesnt exist");
        }
        return client;
    }

    @RequestMapping("/client")
    public Client addNewClientOrUpdate(@RequestBody Client client) {
        clientService.saveClient(client);
        return client;
    }

    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable int id) {
        Client client = clientService.getClient(id);
        if (client == null) {
            throw new NoSuchClientException("Client with id "
                    + id + " wasn't found");
        }
        clientService.deleteClient(id);
    }

}
