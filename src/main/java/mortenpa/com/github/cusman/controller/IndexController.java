package mortenpa.com.github.cusman.controller;

import mortenpa.com.github.cusman.CusmanApplication;
import mortenpa.com.github.cusman.model.Client;
import mortenpa.com.github.cusman.model.User;
import mortenpa.com.github.cusman.repository.ClientRepository;
import mortenpa.com.github.cusman.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    AuthenticationController authenticationController;

    @Autowired
    private ClientRepository clients;

    private static final Logger log = LoggerFactory.getLogger(CusmanApplication.class);

    @GetMapping("/")
    public ModelAndView index(HttpServletRequest request) {
        User user = authenticationController.getUserFromSession(request.getSession());
        Iterable<Client> myClients = clients.findByClientManagerUser(user.getUsername());

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("clients", myClients);

        modelAndView.addObject("user", user);
        return modelAndView;
    }

}
