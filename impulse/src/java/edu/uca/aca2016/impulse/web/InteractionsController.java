package edu.uca.aca2016.impulse.web;


import org.springframework.web.servlet.ModelAndView;
import edu.uca.aca2016.impulse.Interactions;
import edu.uca.aca2016.impulse.repository.InteractionsDAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InteractionsController {

    @Autowired
    InteractionsDAO dao;

    @RequestMapping("/interactions/interactionsform")
    public ModelAndView showform() {
        return new ModelAndView("interactionsform", "command", new Interactions());
    }

    @RequestMapping(value = "/interactions/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("interactions") Interactions interactions) {
        dao.save(interactions);
        return new ModelAndView("redirect:/interactions/viewinteractions");
    }

    @RequestMapping("/interactions/viewinteractions")
    public ModelAndView viewinteractions() {
        List<Interactions> list = dao.getInteractionsList();
        return new ModelAndView("viewinteractions", "list", list);
    }

    @RequestMapping(value = "/interactions/editinteractions/{id}")
    public ModelAndView edit(@PathVariable int id) {
        Interactions interactions = dao.getInteractionsById(id);
        return new ModelAndView("interactionseditform", "command", interactions);
    }

    @RequestMapping(value = "/interactions/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("client") Interactions interactions) {
        dao.update(interactions);
        return new ModelAndView("redirect:/interactions/viewinteractions");
    }

    @RequestMapping(value = "/interactions/deleteclient/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id) {
        dao.delete(id);
        return new ModelAndView("redirect:/interactions/viewinteractions");
    }
}
