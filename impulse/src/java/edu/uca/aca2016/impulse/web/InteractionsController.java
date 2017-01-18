package edu.uca.aca2016.impulse.web;

import org.springframework.web.servlet.ModelAndView;
import edu.uca.aca2016.impulse.Interactions;
import edu.uca.aca2016.impulse.repository.InteractionsDAO;
import edu.uca.aca2016.impulse.Message;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.HashMap;


@Controller
public class InteractionsController {

    @Autowired
    InteractionsDAO dao;

    @RequestMapping("/interactions/interactionsform")
    public ModelAndView showform() {
        return new ModelAndView("interactionsform", "command", new Interactions());
    }

    @RequestMapping(value = "/interactions/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("interactions") Interactions interactions, HttpServletRequest request) {
         int r = dao.save(interactions);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Client has been successfully created");
        }
        else {
            msg = new Message(Message.Level.ERROR, "New client creation failed");
        }
        
        request.getSession().setAttribute("message", msg);
        return new ModelAndView("redirect:/interactions/viewinteractions");
    }

    @RequestMapping("/interactions/viewinteractions")
    public ModelAndView viewinteractions(HttpServletRequest request) {
        
        return this.viewartist(1, request);
    }
@RequestMapping("/interactions/viewinteraction/{pageid}")
    public ModelAndView viewartist(@PathVariable int pageid, HttpServletRequest request){
        int total = 25;
        int start = 1;
        
        if(pageid != 1) {
            start = (pageid-1) * total + 1;  
        }  
        
        List<Interactions> list = dao.getInteractionssByPage(start, total);
        
        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);
        
        int count = dao.getInteractionCount();
        context.put("pages", Math.ceil((float)count/(float)total));
        
        context.put("page", pageid);
        
        Message msg = (Message)request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }
       
        return new ModelAndView("viewinteraction", context);
    }
    
    @RequestMapping(value = "/interactions/editinteractions/{id}")
    public ModelAndView edit(@PathVariable int id) {
        Interactions interactions = dao.getInteractionsById(id);
        return new ModelAndView("interactionseditform", "command", interactions);
    }

    @RequestMapping(value = "/interactions/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("interactions") Interactions interactions,  HttpServletRequest request) {
        int r = dao.update(interactions);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Interaction has been successfully saved");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Edit interaction failed");
        }
        
        request.getSession().setAttribute("message", msg);
        return new ModelAndView("redirect:/interactions/viewinteractions");
    }

    @RequestMapping(value = "/interactions/deleteinteractions/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id,HttpServletRequest request ) {
        int r = dao.delete(id);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Interaction has been successfully deleted");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Delete interaction failed");
        }
        
        request.getSession().setAttribute("message", msg);
        return new ModelAndView("redirect:/interactions/viewinteractions");
    }
}
