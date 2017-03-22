package edu.uca.aca2016.impulse.web;

import edu.uca.aca2016.impulse.repository.ClientDAO;
import org.springframework.web.servlet.ModelAndView;
import edu.uca.aca2016.impulse.objects.Client;
import edu.uca.aca2016.impulse.objects.Interactions;

import edu.uca.aca2016.impulse.objects.Message;
import edu.uca.aca2016.impulse.repository.InteractionsDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import edu.uca.aca2016.impulse.validation.ClientValidator;

/**
 *
 * @author brela
 */
@Controller
public class ClientController {

    private static final Logger logger = Logger.getLogger(ClientController.class.getName());
    @Autowired
    ClientDAO dao;
    
    @Autowired
    InteractionsDAO idao;
    
    @Autowired
    private ClientValidator clientValidator;

    /**
     *New Client form mapping
     * @return
     */
    @RequestMapping("/client/clientform")
    public ModelAndView showform() {
        return new ModelAndView("clientform", "client", new Client());
    }

    /**
     *Save client form and mapping
     * @param client
     * @param result
     * @param request
     * @return
     */
    @RequestMapping(value = "/client/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("client") @Valid Client client, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return new ModelAndView("clientform", "client", client);
        }
        int r = dao.save(client);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Client has been successfully created");
        } else {
            msg = new Message(Message.Level.ERROR, "New client creation failed");
        }

        request.getSession().setAttribute("message", msg);
        return new ModelAndView("redirect:/client/viewclient");
    }

    /**
     *View client form and mapping
     * @param request
     * @return
     */
    @RequestMapping("/client/viewclient")
    public ModelAndView viewclient(HttpServletRequest request) {

        return this.viewclient(1, request);
    }

    /**
     *View client form and mapping
     * @param pageid
     * @param request
     * @return
     */
    @RequestMapping("/client/viewclient/{pageid}")
    public ModelAndView viewclient(@PathVariable int pageid, HttpServletRequest request) {
        int total = 25;
        int start = 1;

        if (pageid != 1) {
            start = (pageid - 1) * total + 1;
        }

        List<Client> list = dao.getClientsByPage(start, total);

        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);

        int count = dao.getClientCount();
        context.put("pages", Math.ceil((float) count / (float) total));

        context.put("page", pageid);

        Message msg = (Message) request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }

        return new ModelAndView("viewclient", context);
    }

    /**
     *Edit client form and mapping
     * @param id
     * @return
     */
    @RequestMapping(value = "/client/editclient/{id}")
    public ModelAndView edit(@PathVariable int id) {
        Client client = dao.getClientById(id);
        
        return new ModelAndView("clienteditform", "client", client);
    }

    /**
     *Summary client form and mapping
     * @param id
     * @return
     */
    @RequestMapping(value = "/client/summaryclient/{id}")
    public ModelAndView summaryclient (@PathVariable int id) {
        Client client = dao.getClientById(id);
        List<Interactions> list = idao.getInteractionsList(id);

        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);
        context.put("client", client);
        return new ModelAndView("summaryclient",  context);
    }

    /**
     *Save method for client edit
     * @param client
     * @param result
     * @param request
     * @return
     */
    @RequestMapping(value = "/client/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("client") @Valid Client client, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return new ModelAndView("clienteditform", "client", client);
        }
        int r = dao.update(client);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Client has been successfully saved");
        } else {
            msg = new Message(Message.Level.ERROR, "Edit client failed");
        }

        request.getSession().setAttribute("message", msg);
        return new ModelAndView("redirect:/client/viewclient");
    }

    /**
     *Client delete form
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/client/deleteclient/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id, HttpServletRequest request) {
        int r = dao.delete(id);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Client has been successfully deleted");
        } else {
            msg = new Message(Message.Level.ERROR, "Delete client failed");
        }

        request.getSession().setAttribute("message", msg);
        return new ModelAndView("redirect:/client/viewclient");
    }

    /**
     *
     * @param webDataBinder
     */
    @InitBinder("client")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(clientValidator);
    }

    /**
     *
     * @return
     */
    public ClientValidator getClientValidator() {
        return clientValidator;
    }

    /**
     *
     * @param clientValidator
     */
    public void setClientValidator(ClientValidator clientValidator) {
        this.clientValidator = clientValidator;
    }
}
