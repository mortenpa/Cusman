package mortenpa.com.github.cusman.controller;

import mortenpa.com.github.cusman.model.Client;
import mortenpa.com.github.cusman.model.Country;
import mortenpa.com.github.cusman.model.User;
import mortenpa.com.github.cusman.model.dto.ClientFormDTO;
import mortenpa.com.github.cusman.model.dto.LoginFormDTO;
import mortenpa.com.github.cusman.model.dto.RegisterFormDTO;
import mortenpa.com.github.cusman.repository.ClientRepository;
import mortenpa.com.github.cusman.repository.CountryRepository;
import mortenpa.com.github.cusman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


@Controller
public class ClientController {

    @Autowired
    private CountryRepository countries;

    @Autowired
    AuthenticationController authenticationController;

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/client")
    public String addClientView(Model model, ClientFormDTO clientFormDTO) {
        model.addAttribute(clientFormDTO);
        //TODO would be nice to sort countries by name
        model.addAttribute("countries", countries.findAll());
        model.addAttribute("existing_client", false);
        return "client";
    }

    @GetMapping("/client/{id}")
    public String modifyClientView(@PathVariable("id") Long id, Model model){
        Client client = clientRepository.findById(id).orElse(null);
        if (client == null){
            return "redirect:";
        }

        ClientFormDTO clientFormDTO = new ClientFormDTO(client);

        model.addAttribute(clientFormDTO);
        model.addAttribute("existing_client", true);
        model.addAttribute("countries", countries.findAll());
        return "client";
    }

    @PostMapping("/client/{id}")
    public String updateClient(@ModelAttribute @Valid ClientFormDTO clientFormDTO,
                               Errors errors,
                               HttpServletRequest request,
                               Model model) {



        Client client = clientRepository.findById(clientFormDTO.getId());
        if (client == null) {
            return "redirect:/";
        }

        if (errors.hasErrors()) {

            model.addAttribute(clientFormDTO);
            model.addAttribute("existing_client", true);
            model.addAttribute("countries", countries.findAll());
            return "client";
        }
        client.setFirstName(clientFormDTO.getFirstName());
        client.setLastName(clientFormDTO.getLastName());
        client.setUsername(clientFormDTO.getUsername());
        client.setAddress(clientFormDTO.getAddress());
        client.setEmail(clientFormDTO.getEmail());
        client.setCountry(clientFormDTO.getCountry());

        clientRepository.save(client);
        return "redirect:/";
    }

    @PostMapping("/client")
    public String addClient(@ModelAttribute @Valid ClientFormDTO clientFormDTO,
                                  Errors errors,
                                  HttpServletRequest request,
                                  Model model) {

        User user = authenticationController.getUserFromSession(request.getSession());
        if (user == null){
            return "redirect:";
        }

        if (errors.hasErrors()) {
            model.addAttribute("countries", countries.findAll());
            return "client";
        }

        Client newClient = new Client(clientFormDTO.getFirstName(),
                                      clientFormDTO.getLastName(),
                                      user.getUsername());
        clientRepository.save(newClient);

        return "redirect:/";
    }

    @PostMapping("/client/delete/{id}")
    public String deleteClient(@PathVariable (value = "id") Long id){

        clientRepository.deleteById((id));

        return "redirect:/";
    }
}


