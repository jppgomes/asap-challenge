package asap.challenge.services;

import java.util.List;

import asap.challenge.domain.Client;


public interface ClientService {

    List<Client> listAll();

    Client getById(String id);

    Client saveOrUpdate(Client client);

    void delete(String id);

}
