package com.project.service;

import com.project.dao.ClientDAO;
import com.project.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAO clientDAO;

    @Override
    public List<Client> getAllClients() {
        return clientDAO.getAllClients();
    }

    @Override
    public void saveClient(Client client) {
        clientDAO.saveClient(client);
    }

    @Override
    public Client getClient(int id) {
        return clientDAO.getClient(id);
    }

    @Override
    public void deleteClient(int id) {
        clientDAO.deleteClient(id);
    }
}
