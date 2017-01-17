package edu.uca.aca2016.impulse.web;

import edu.uca.aca2016.impulse.repository.User_RoleDAO;
import org.springframework.web.servlet.ModelAndView;
import edu.uca.aca2016.impulse.User_Role;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class User_RoleController {

    @Autowired
    User_RoleDAO dao;

    @RequestMapping("/user_role/user_roleform")
    public ModelAndView showform() {
        return new ModelAndView("user_roleform", "command", new User_Role());
    }

    @RequestMapping(value = "/user_role/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("user_role") User_Role user_role) {
        dao.save(user_role);
        return new ModelAndView("redirect:/user_role/viewuser_role");
    }

    @RequestMapping("/user_role/viewuser_role")
    public ModelAndView viewuser_role() {
        List<User_Role> list = dao.getUser_RoleList();
        return new ModelAndView("viewuser_role", "list", list);
    }

    @RequestMapping(value = "/user_role/edituser_role/{id}")
    public ModelAndView edit(@PathVariable int id) {
        User_Role user_role = dao.getUser_RoleById(id);
        return new ModelAndView("user_roleeditform", "command", user_role);
    }

    @RequestMapping(value = "/user_role/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("user_role") User_Role user_role) {
        dao.update(user_role);
        return new ModelAndView("redirect:/user_role/viewuser_role");
    }

    @RequestMapping(value = "/user_role/deleteuser_role/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id) {
        dao.delete(id);
        return new ModelAndView("redirect:/user_role/viewuser_role");
    }
}
