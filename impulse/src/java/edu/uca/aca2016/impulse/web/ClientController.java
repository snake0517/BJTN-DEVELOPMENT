package edu.uca.aca2016.impulse.web;

import edu.uca.aca2016.impulse.repository.ClientDAO;
import org.springframework.web.servlet.ModelAndView;
import edu.uca.aca2016.impulse.Client;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientController {

    @Autowired
    ClientDAO dao;

    @RequestMapping("/client/clientform")
    public ModelAndView showform() {
        return new ModelAndView("clientform", "command", new Client());
    }

    @RequestMapping(value = "/client/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("client") Client client) {
        dao.save(client);
        return new ModelAndView("redirect:/client/viewclient");
    }

    @RequestMapping("/client/viewclient")
    public ModelAndView viewclient() {
        List<Client> list = dao.getClientsList();
        return new ModelAndView("viewclient", "list", list);
    }

    @RequestMapping(value = "/client/editclient/{id}")
    public ModelAndView edit(@PathVariable int id) {
        Client client = dao.getClientById(id);
        return new ModelAndView("clienteditform", "command", client);
    }

    @RequestMapping(value = "/client/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("client") Client client) {
        dao.update(client);
        return new ModelAndView("redirect:/client/viewclient");
    }

    @RequestMapping(value = "/client/deleteclient/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id) {
        dao.delete(id);
        return new ModelAndView("redirect:/client/viewclient");
    }
}
