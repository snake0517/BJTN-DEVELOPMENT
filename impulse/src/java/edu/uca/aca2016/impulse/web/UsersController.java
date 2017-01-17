package edu.uca.aca2016.impulse.web;

import edu.uca.aca2016.impulse.repository.UsersDAO;
import org.springframework.web.servlet.ModelAndView;
import edu.uca.aca2016.impulse.Users;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsersController {

    @Autowired
    UsersDAO dao;

    @RequestMapping("/users/usersform")
    public ModelAndView showform() {
        return new ModelAndView("usersform", "command", new Users());
    }

    @RequestMapping(value = "/users/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("users") Users users) {
        dao.save(users);
        return new ModelAndView("redirect:/users/viewusers");
    }

    @RequestMapping("/users/viewusers")
    public ModelAndView viewuser_role() {
        List<Users> list = dao.getUsersList();
        return new ModelAndView("viewusers", "list", list);
    }

    @RequestMapping(value = "/users/editusers/{username}")
    public ModelAndView edit(@PathVariable String username) {
        Users users = dao.getUsersbyUsername("username");
        return new ModelAndView("userseditform", "command", users);
    }

    @RequestMapping(value = "/users/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("users") Users users) {
        dao.update(users);
        return new ModelAndView("redirect:/users/viewusers");
    }

    @RequestMapping(value = "/users/deleteusers/{username}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable String username) {
        dao.delete(username);
        return new ModelAndView("redirect:/users/viewusers");
    }
}
