package asap.challenge.controllers;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

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

import asap.challenge.domain.Apolice;
import asap.challenge.domain.Client;
import asap.challenge.services.ApoliceService;
import asap.challenge.services.ClientService;
import asap.challenge.utils.ListAllApolicesDTO;


/**
 * 
 * @author jp
 *
 */
@RestController
@RequestMapping("/apolices/")
public class ApoliceController {
   
	private static final Gson gson = new Gson();
	private ApoliceService apoliceService;
	private ClientService clientService;


    @Autowired
    public void setApoliceService(ApoliceService apoliceService) {
    	
    	this.apoliceService = apoliceService;
    	
    }
    
    private static Long autoGenerateNumber() {
       
    	return new Long((long) Math.floor(Math.random()*(100000000-10000000+1)+10000000));
    }
    
    /**
     * Recupera apolice por numero
     * @param cpf
     * @return
     */
    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/{numero}")
    public @ResponseBody String getById(@PathVariable Long numero){
        
        Apolice c = null; 
        
        try {
        	c = apoliceService.getById(String.valueOf(numero));	
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        if(c!=null)        
        	return gson.toJson(c);
        
        return HttpStatus.NOT_FOUND.toString();

    }
    
    /**
     * Remove apolice por numero
     * @param cpf
     * @return
     */
    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/remove/{numero}")
    public @ResponseBody String remove(@PathVariable Long numero){
        
        Apolice c = null; 
        
        try {
        	apoliceService.delete(String.valueOf(numero));
        	return HttpStatus.OK.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return HttpStatus.INTERNAL_SERVER_ERROR.toString();
		}

    }
    
    /**
     * salva apolice
     * @return
     */
    @PostMapping(
    		  value = "/create", consumes = "application/json", produces = "application/json")
    public HttpStatus save(@RequestBody Apolice apolice) {
                
        try {
        	apolice.setNumero(autoGenerateNumber());
        	apoliceService.saveOrUpdate(apolice);	
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        System.out.println("Salvo");
        
        return HttpStatus.OK;

    }
    
    /**
     * salva apolice
     * @return
     */
    @PostMapping(
    		  value = "/update", consumes = "application/json", produces = "application/json")
    public HttpStatus update(@RequestBody Apolice apolice) {
                
        try {
        	apolice.setNumero(autoGenerateNumber());
        	apoliceService.saveOrUpdate(apolice);	
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        System.out.println("Salvo");
        
        return HttpStatus.OK;

    }
    
    /**
     * Recupera todos
     * @return
     */
    
    @RequestMapping("/")
    public String getAll(){
                        
        try {
        	System.out.println(apoliceService.listAll());
            ListAllApolicesDTO r = new ListAllApolicesDTO();
            r.setT(apoliceService.listAll());
        	return gson.toJson(r);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
        
       }
}
