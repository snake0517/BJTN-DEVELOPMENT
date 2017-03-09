package edu.uca.aca2016.impulse.web;

import edu.uca.aca2016.impulse.repository.UsersDAO;
import org.springframework.web.servlet.ModelAndView;
import edu.uca.aca2016.impulse.objects.Users;
import edu.uca.aca2016.impulse.objects.Message;
import edu.uca.aca2016.impulse.validation.UsersValidator;
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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 *
 * @author brela
 */
@Controller
public class UsersController {

    @Autowired
    UsersDAO dao;

    @Autowired
    private UsersValidator usersValidator;

    /**
     *
     * @return
     */
    @RequestMapping("/users/usersform")
    public ModelAndView showform() {
        return new ModelAndView("usersform", "users", new Users());
    }

    /**
     *
     * @param users
     * @param result
     * @param request
     * @return
     */
    @RequestMapping(value = "/users/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("users") @Valid Users users, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return new ModelAndView("usersform", "users", users);
        }
        int r = dao.save(users);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "User has been successfully created");
        } else {
            msg = new Message(Message.Level.ERROR, "New user creation failed");
        }

        request.getSession().setAttribute("message", msg);
        return new ModelAndView("redirect:/users/viewusers");
    }

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping("/users/viewusers")
    public ModelAndView viewuser_role(HttpServletRequest request) {

        return this.viewusers(1, request);
    }

    /**
     *
     * @param pageid
     * @param request
     * @return
     */
    @RequestMapping("/user/viewuser/{pageid}")
    public ModelAndView viewusers(@PathVariable int pageid, HttpServletRequest request) {
        int total = 25;
        int start = 1;

        if (pageid != 1) {
            start = (pageid - 1) * total + 1;
        }

        List<Users> list = dao.getUsersByPage(start, total);

        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);

        int count = dao.getUsersCount();
        context.put("pages", Math.ceil((float) count / (float) total));

        context.put("page", pageid);

        Message msg = (Message) request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }

        return new ModelAndView("viewusers", context);
    }

    /**
     *
     * @param username
     * @return
     */
    @RequestMapping(value = "/users/editusers/{username}")
    public ModelAndView edit(@PathVariable String username) {
        Users users = dao.getUsersbyUsername(username);
        return new ModelAndView("userseditform", "users", users);
    }

    /**
     *
     * @param users
     * @param result
     * @param request
     * @return
     */
    @RequestMapping(value = "/users/editsave", method = RequestMethod.POST)

    public ModelAndView editsave(@ModelAttribute("users") @Valid Users users, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return new ModelAndView("userseditform", "users", users);
        }
        int r = dao.update(users);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Interaction has been successfully saved");
        } else {
            msg = new Message(Message.Level.ERROR, "Edit interaction failed");
        }

        request.getSession().setAttribute("message", msg);
        return new ModelAndView("redirect:/users/viewusers");
    }

    /**
     *
     * @param users
     * @param request
     * @return
     */
    @RequestMapping(value = "/users/deleteusers/{username}", method = RequestMethod.GET)
    public ModelAndView delete(@ModelAttribute("users") Users users, HttpServletRequest request) {
        int r = dao.delete(users);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "User has been successfully deleted");
        } else {
            msg = new Message(Message.Level.ERROR, "Delete user failed");
        }

        request.getSession().setAttribute("message", msg);
        return new ModelAndView("redirect:/users/viewusers");
    }

    /**
     *
     * @param webDataBinder
     */
    @InitBinder("users")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(usersValidator);
    }

    /**
     *
     * @return
     */
    public UsersValidator getUsersValidator() {
        return usersValidator;
    }

    /**
     *
     * @param usersValidator
     */
    public void setUsersValidator(UsersValidator usersValidator) {
        this.usersValidator = usersValidator;
    }

}
