package asap.challenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import asap.challenge.domain.Client;
import asap.challenge.services.ClientService;
import asap.challenge.utils.ListAllClientsDTO;


/**
 * 
 * @author jp
 *
 */
@RestController
@RequestMapping("/clients/")
public class ClientController {
   
	private static final Gson gson = new Gson();
	private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
    	
    	this.clientService = clientService;
    	
    }
    
    /**
     * Recupera cliente por cpf
     * @param cpf
     * @return
     */
    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/client/{cpf}")
    public @ResponseBody String getById(@PathVariable String cpf){
        
        Client c = null; 
        
        try {
        	c = clientService.getById(cpf);	
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        if(c!=null)        
        	return gson.toJson(c);
        
        return HttpStatus.NOT_FOUND.toString();

    }
    
    /**
     * remove cliente por cpf
     * @param cpf
     * @return
     */
    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/remove/client/{cpf}")
    public @ResponseBody String removeById(@PathVariable String cpf){
                
        try {
        	clientService.delete(cpf);	
        	return HttpStatus.OK.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return HttpStatus.NOT_FOUND.toString();
		}
        
    }
    
    /**
     * salva cliente
     * @return
     */
    @PostMapping(
    		  value = "/save", consumes = "application/json", produces = "application/json")
    public HttpStatus save(@RequestBody Client client){
        
        try {
        	clientService.saveOrUpdate(client);
        	return HttpStatus.OK;
		} catch (Exception e) {
			e.printStackTrace();
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}       
        
    }
    
    
    /**
     * salva cliente
     * @return
     */
    @PostMapping(
    		  value = "/update", consumes = "application/json", produces = "application/json")
    public HttpStatus update(@RequestBody Client client){
        
        try {
        	clientService.saveOrUpdate(client);
        	return HttpStatus.OK;
		} catch (Exception e) {
			e.printStackTrace();
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}       
        
    }
    
    /**
     * Recupera todos
     * @return
     */
    
    @RequestMapping("/")
    public String getAll(){
                        
        try {
        	List<Client> c = clientService.listAll();
        	ListAllClientsDTO all = new ListAllClientsDTO();
        	all.setT(c);
        	return gson.toJson(all);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
               
       }
}
