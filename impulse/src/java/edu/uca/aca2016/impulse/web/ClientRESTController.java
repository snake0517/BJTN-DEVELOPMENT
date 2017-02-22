package edu.uca.aca2016.impulse.web;



import edu.uca.aca2016.impulse.objects.Client;
import edu.uca.aca2016.impulse.repository.ClientDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ClientRESTController{

    @Autowired
    ClientDAO dao;

    @RequestMapping(value = "/api/client/",method = RequestMethod.GET)
    public ResponseEntity<List<Client>> listAllClients(){
        List<Client> clients = dao.getClientsList();

        if(clients.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(clients,HttpStatus.OK);
    }

    @RequestMapping(value = "/api/client/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getClient(@PathVariable("id") int id){
        Client client = null;
        
        try {
            client = dao.getClientById(id);
        }
        catch (EmptyResultDataAccessException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(client,HttpStatus.OK);
    }

    @RequestMapping(value = "/api/client/",method = RequestMethod.POST)
    public ResponseEntity<Void> createClient(@RequestBody Client client,UriComponentsBuilder ucBuilder){
        dao.save(client);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/client/{id}").buildAndExpand(client.getClientid()).toUri());
        
        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/client/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Client> updateClient(@PathVariable("id") int id,@RequestBody Client client){
        Client currentClient = null;

        try {
            currentClient = dao.getClientById(id);
        }
        catch (EmptyResultDataAccessException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentClient.setFirstName(client.getFirstName());
        currentClient.setLastName(client.getLastName());
        currentClient.setAddress1(client.getAddress1());
        currentClient.setAddress2(client.getAddress2());
        currentClient.setCity(client.getCity());
        currentClient.setState(client.getState());
        currentClient.setZip(client.getZip());
        currentClient.setEmail(client.getEmail());
        currentClient.setPhone(client.getPhone());
        currentClient.setStatus(client.getStatus());

        dao.update(currentClient);
        return new ResponseEntity<>(currentClient,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/client/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Client> deleteClient(@PathVariable("id") int id) {
        Client client = null;
        
        try {
            client = dao.getClientById(id);
        }
        catch (EmptyResultDataAccessException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
 
        dao.delete(id);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
