package asap.challenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asap.challenge.domain.Apolice;
import asap.challenge.domain.Client;
import asap.challenge.repositories.ApoliceRepository;
import asap.challenge.repositories.ClientRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApoliceServiceImpl implements ApoliceService {

    private ApoliceRepository apoliceRepository;

    @Autowired
    public void ApoliceServiceImpl(ApoliceRepository apoliceRepository) {
        this.apoliceRepository = apoliceRepository;
    }


    public List<Apolice> listAll() {
        List<Apolice> apolices = new ArrayList<>();
        apoliceRepository.findAll().forEach(apolices::add); //fun with Java 8
        return apolices;
    }

    public Apolice getById(String id) {
        return apoliceRepository.findById(id).orElse(null);
    }

    @Override
    public Apolice saveOrUpdate(Apolice apolice) {
    	apoliceRepository.save(apolice);
        return apolice;
    }

    @Override
    public void delete(String id) {
    	apoliceRepository.deleteById(id);
    }


}
