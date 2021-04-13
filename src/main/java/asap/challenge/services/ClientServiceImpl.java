package asap.challenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asap.challenge.domain.Client;
import asap.challenge.repositories.ClientRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public void ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public List<Client> listAll() {
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add); //fun with Java 8
        return clients;
    }

    @Override
    public Client getById(String id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client saveOrUpdate(Client client) {
    	clientRepository.save(client);
        return client;
    }

    @Override
    public void delete(String id) {
    	clientRepository.deleteById(id);
    }


}
