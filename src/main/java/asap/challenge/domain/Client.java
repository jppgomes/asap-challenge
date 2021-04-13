package asap.challenge.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * Created by jt on 1/10/17.
 */
@Document
public class Client {
    
	@Id
    private String cpf;
    private String nome;
    private String cidade;
    private String uf;
	
    public Client(String cpf, String nome, String cidade, String uf) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.cidade = cidade;
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "Client [cpf=" + cpf + ", nome=" + nome + ", cidade=" + cidade + ", uf=" + uf + "]";
	}

    
}
