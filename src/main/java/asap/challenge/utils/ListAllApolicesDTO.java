package asap.challenge.utils;

import java.util.ArrayList;
import java.util.List;

import asap.challenge.domain.Apolice;

public class ListAllApolicesDTO {
	
	private List<Apolice> t = new ArrayList<>();

	public List<Apolice> getT() {
		return t;
	}

	public void setT(List<Apolice> t) {
		this.t = t;
	}
	
}
