package asap.challenge.utils;

import java.util.ArrayList;
import java.util.List;

import asap.challenge.domain.Apolice;
import asap.challenge.domain.Client;

public class ListAllClientsDTO {
	
	private List<Client> t = new ArrayList<>();

	public List<Client> getT() {
		return t;
	}

	public void setT(List<Client> t) {
		this.t = t;
	}
	
}
