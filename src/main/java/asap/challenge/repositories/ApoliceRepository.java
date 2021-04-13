package asap.challenge.repositories;

import org.springframework.data.repository.CrudRepository;

import asap.challenge.domain.Apolice;
import asap.challenge.domain.Client;


public interface ApoliceRepository extends CrudRepository<Apolice, String> {
}
