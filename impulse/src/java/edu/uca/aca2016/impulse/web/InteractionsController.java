package edu.uca.aca2016.impulse.web;

import edu.uca.aca2016.impulse.objects.Client;
import org.springframework.web.servlet.ModelAndView;
import edu.uca.aca2016.impulse.objects.Interactions;
import edu.uca.aca2016.impulse.repository.InteractionsDAO;
import edu.uca.aca2016.impulse.objects.Message;
import edu.uca.aca2016.impulse.repository.ClientDAO;
import edu.uca.aca2016.impulse.validation.InteractionsValidator;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.HashMap;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Controller
public class InteractionsController {

    @Autowired
    InteractionsDAO dao;

    @Autowired
    ClientDAO cdao;
    
    @Autowired
    private InteractionsValidator interactionsValidator;


    @RequestMapping("/interactions/interactionsform")
    public ModelAndView showform() {
        Interactions interactions = new Interactions();
        interactions.setClients(dao.getClientsMap());

        return new ModelAndView("interactionsform", "interactions", interactions);
    }

    @RequestMapping("/interactions/interactionsform/{id}")
    public ModelAndView showformWithClient(@PathVariable int id) {
        Client client = cdao.getClientById(id);

        Interactions interactions = new Interactions();
        interactions.setClientid(id);
        interactions.setClient(client);

        interactions.setClients(dao.getClientsMap());

        return new ModelAndView("interactionsform", "interactions", interactions);
    }

    @RequestMapping(value = "/interactions/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("interactions") @Valid Interactions interactions, BindingResult result, HttpServletRequest request) {
        int r = dao.save(interactions);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Client has been successfully created");
        } else {
            msg = new Message(Message.Level.ERROR, "New client creation failed");
        }

        request.getSession().setAttribute("message", msg);
        return new ModelAndView("redirect:/interactions/viewinteractions");
    }

    @RequestMapping("/interactions/viewinteractions")
    public ModelAndView viewinteractions(HttpServletRequest request) {

        return this.viewinteractions(1, request);
    }

    @RequestMapping("/interactions/viewinteraction/{pageid}")
    public ModelAndView viewinteractions(@PathVariable int pageid, HttpServletRequest request) {
        int total = 25;
        int start = 1;

        if (pageid != 1) {
            start = (pageid - 1) * total + 1;
        }

        List<Interactions> list = dao.getInteractionssByPage(start, total);

        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);

        int count = dao.getInteractionCount();
        context.put("pages", Math.ceil((float) count / (float) total));

        context.put("page", pageid);

        Message msg = (Message) request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }

        return new ModelAndView("viewinteractions", context);
    }

    @RequestMapping(value = "/interactions/editinteractions/{id}")
    public ModelAndView edit(@PathVariable int id) {
        Interactions interactions = dao.getInteractionsById(id);
        return new ModelAndView("interactionseditform", "interactions", interactions);
    }

    @RequestMapping(value = "/interactions/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("interactions") @Valid Interactions interactions, BindingResult result, HttpServletRequest request) {
         if(result.hasErrors()){
            return new ModelAndView("interactionseditform", "interactions", interactions);
        }
        int r = dao.update(interactions);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Interaction has been successfully saved");
        } else {
            msg = new Message(Message.Level.ERROR, "Edit interaction failed");
        }

        request.getSession().setAttribute("message", msg);
        return new ModelAndView("redirect:/interactions/viewinteractions");
    }

    @RequestMapping(value = "/interactions/deleteinteractions/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id, HttpServletRequest request) {
        int r = dao.delete(id);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Interaction has been successfully deleted");
        } else {
            msg = new Message(Message.Level.ERROR, "Delete interaction failed");
        }

        request.getSession().setAttribute("message", msg);
        return new ModelAndView("redirect:/interactions/viewinteractions");
    }
     @InitBinder("interactions")
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setValidator(interactionsValidator);
    }
    
    public InteractionsValidator getInteractionsValidator() {
        return interactionsValidator;
    }
 
    public void setInteractionsValidator(InteractionsValidator interactionsValidator) {
        this.interactionsValidator = interactionsValidator;
    }
}
