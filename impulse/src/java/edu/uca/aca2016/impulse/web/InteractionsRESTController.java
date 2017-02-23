package edu.uca.aca2016.impulse.web;




import edu.uca.aca2016.impulse.objects.Interactions;
import edu.uca.aca2016.impulse.repository.InteractionsDAO;
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
public class InteractionsRESTController{

    @Autowired
    InteractionsDAO dao;

    @RequestMapping(value = "/api/interactions/",method = RequestMethod.GET)
    public ResponseEntity<List<Interactions>> listAllInteractions(){
        List<Interactions> interactionss = dao.getAPIInteractionsList();

        if(interactionss.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(interactionss,HttpStatus.OK);
    }

    @RequestMapping(value = "/api/interactions/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Interactions> getInteraction(@PathVariable("id") int id){
        Interactions interactions = null;
        
        try {
            interactions = dao.getInteractionsById(id);
        }
        catch (EmptyResultDataAccessException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(interactions,HttpStatus.OK);
    }

    @RequestMapping(value = "/api/interactions/",method = RequestMethod.POST)
    public ResponseEntity<Void> createInteractions(@RequestBody Interactions interactions,UriComponentsBuilder ucBuilder){
        dao.save(interactions);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/interactions/{id}").buildAndExpand(interactions.getClientid()).toUri());
        
        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/interactions/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Interactions> updateInteractions(@PathVariable("id") int id,@RequestBody Interactions interactions){
        Interactions currentInteractions = null;

        try {
            currentInteractions = dao.getInteractionsById(id);
        }
        catch (EmptyResultDataAccessException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentInteractions.setOccurredOn(interactions.getOccurredOn());
        currentInteractions.setContactPerson(interactions.getContactPerson());
        currentInteractions.setContactType(interactions.getContactType());
        currentInteractions.setNotes(interactions.getNotes());

        dao.update(currentInteractions);
        return new ResponseEntity<>(currentInteractions,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/interactions/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Interactions> deleteInteractions(@PathVariable("id") int id) {
        Interactions interactions = null;
        
        try {
            interactions = dao.getInteractionsById(id);
        }
        catch (EmptyResultDataAccessException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
 
        dao.delete(id);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
