package asap.challenge.repositories;

import org.springframework.data.repository.CrudRepository;

import asap.challenge.domain.Client;


public interface ClientRepository extends CrudRepository<Client, String> {
}
