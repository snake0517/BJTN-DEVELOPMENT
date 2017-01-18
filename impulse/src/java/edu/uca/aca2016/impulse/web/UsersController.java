package edu.uca.aca2016.impulse.web;

import edu.uca.aca2016.impulse.repository.UsersDAO;
import org.springframework.web.servlet.ModelAndView;
import edu.uca.aca2016.impulse.Users;
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
public class UsersController {

    @Autowired
    UsersDAO dao;

    @RequestMapping("/users/usersform")
    public ModelAndView showform() {
        return new ModelAndView("usersform", "command", new Users());
    }

    @RequestMapping(value = "/users/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("users") Users users, HttpServletRequest request) {
        int r = dao.save(users);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "User has been successfully created");
        }
        else {
            msg = new Message(Message.Level.ERROR, "New user creation failed");
        }
        
        request.getSession().setAttribute("message", msg);
        return new ModelAndView("redirect:/users/viewusers");
    }

    @RequestMapping("/users/viewusers")
    public ModelAndView viewuser_role(HttpServletRequest request) {
        
        return this.viewartist(1, request);
    }
@RequestMapping("/user/viewuser/{pageid}")
    public ModelAndView viewartist(@PathVariable int pageid, HttpServletRequest request){
        int total = 25;
        int start = 1;
        
        if(pageid != 1) {
            start = (pageid-1) * total + 1;  
        }  
        
        List<Users> list = dao.getUsersByPage(start, total);
        
        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);
        
        int count = dao.getUsersCount();
        context.put("pages", Math.ceil((float)count/(float)total));
        
        context.put("page", pageid);
        
        Message msg = (Message)request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }
       
        return new ModelAndView("viewuser", context);
    }
    @RequestMapping(value = "/users/editusers/{username}")
    public ModelAndView edit(@PathVariable String username) {
        Users users = dao.getUsersbyUsername("username");
        return new ModelAndView("userseditform", "command", users);
    }

    @RequestMapping(value = "/users/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("users") Users users, HttpServletRequest request) {
        int r = dao.update(users);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Interaction has been successfully saved");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Edit interaction failed");
        }
        
        request.getSession().setAttribute("message", msg);
        return new ModelAndView("redirect:/users/viewusers");
    }

    @RequestMapping(value = "/users/deleteusers/{username}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable String username, HttpServletRequest request) {
        int r = dao.delete(username);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "User has been successfully deleted");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Delete user failed");
        }
        
        request.getSession().setAttribute("message", msg);
        return new ModelAndView("redirect:/users/viewusers");
    }
}
