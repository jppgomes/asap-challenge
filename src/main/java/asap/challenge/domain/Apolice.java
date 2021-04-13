package asap.challenge.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.sql.Timestamp;

@Document
public class Apolice {
    
	@Id
    private Long numero;
    private Date inicio;
    private Date fim;
    private String placa;
    private Double valor;
    private Client cliente;
	
    public Apolice(Long numero, Date inicio, Date fim, String placa, Double valor, Client cliente) {
		super();
		this.cliente=cliente;
		this.numero = numero;
		this.inicio = inicio;
		this.fim = fim;
		this.placa = placa;
		this.valor = valor;
	}

    public void setNumero(Long numero) {
    	this.numero=numero;
    }
    
	@Override
	public String toString() {
		return "Apolice [numero=" + numero + ", inicio=" + inicio + ", fim=" + fim + ", placa=" + placa + ", valor="
				+ valor + "]";
	}
	
}
