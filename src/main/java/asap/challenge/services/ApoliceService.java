package asap.challenge.services;

import java.util.List;

import asap.challenge.domain.Apolice;
import asap.challenge.domain.Client;


public interface ApoliceService {

    List<Apolice> listAll();

    Apolice getById(String id);

    Apolice saveOrUpdate(Apolice apolice);

    void delete(String id);

}
