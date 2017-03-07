package edu.uca.aca2016.impulse.web;

import edu.uca.aca2016.impulse.objects.Client;
import edu.uca.aca2016.impulse.objects.Interactions;
import edu.uca.aca2016.impulse.objects.Message;
import edu.uca.aca2016.impulse.repository.ClientDAO;
import edu.uca.aca2016.impulse.repository.InteractionsDAO;
import java.util.HashMap;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
     @Autowired
    ClientDAO dao;
     
     @Autowired
    InteractionsDAO idao;

    @RequestMapping("/")
    public ModelAndView viewclient( HttpServletRequest request) {
        List<Interactions> ilist = idao.getLastInteractions();

        List<Client> clist = dao.getLastClient();

        HashMap<String, Object> context = new HashMap<>();
        context.put("clist", clist);
        context.put("ilst", ilist);
        
 int crow = dao.getClientCount();
 context.put("crow", crow);
 
 int irow = idao.getInteractionCount();
 context.put("irow", irow);
        

        Message msg = (Message) request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }
        return new ModelAndView("index", context);
    }
    
}
