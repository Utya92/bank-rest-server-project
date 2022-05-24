package com.project.dao;

import com.project.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ClientDAOImpl implements ClientDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Client> getAllClients() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Client", Client.class)
                .getResultList();
    }

    @Override
    public void saveClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(client);
    }

    @Override
    public Client getClient(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Client.class, id);
    }

    @Override
    public void deleteClient(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Client where id=" + id).executeUpdate();
    }
}
