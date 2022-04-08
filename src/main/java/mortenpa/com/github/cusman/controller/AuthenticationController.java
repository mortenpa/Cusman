package mortenpa.com.github.cusman.controller;

import mortenpa.com.github.cusman.model.User;
import mortenpa.com.github.cusman.model.dto.LoginFormDTO;
import mortenpa.com.github.cusman.model.dto.RegisterFormDTO;
import mortenpa.com.github.cusman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;

    private static final String userSessionKey = "user";

    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return null;
        }

        return user.get();
    }

    private static void setUserInSession(HttpSession session, User user){
        session.setAttribute(userSessionKey, user.getId());
    }

    @GetMapping("/register")
    public String registrationForm(Model model) {
        model.addAttribute(new RegisterFormDTO());
        model.addAttribute("title", "User registration");
        return("registration");
    }

    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute @Valid RegisterFormDTO registerFormDTO,
                                          Errors errors,
                                          HttpServletRequest request,
                                          Model model){
        if (errors.hasErrors()){
            errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists!");
            model.addAttribute("title", "User registration");
            return ("registration");
        }

        String password = registerFormDTO.getPassword();
        String passwordVerification = registerFormDTO.getPasswordVerification();
        if (!password.equals(passwordVerification)) {
            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match!");
            model.addAttribute("title", "User registration");
            return("registration");
        }

        if (userRepository.findByUsername(registerFormDTO.getUsername()) != null){
            errors.rejectValue("username", "username.exists", "Username already exists!");
            model.addAttribute("title", "User registration");
            return("registration");
        }

        User newUser = new User(registerFormDTO.getUsername(), registerFormDTO.getPassword());

        userRepository.save(newUser);
        setUserInSession(request.getSession(), newUser);
        return "redirect:";
    }

    @GetMapping("/login")
    public String processLoginForm(Model model){
        model.addAttribute(new LoginFormDTO());
        model.addAttribute("title", "Log in");
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO,
                                   Errors errors,
                                   HttpServletRequest request,
                                   Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Log in");
            return "login";
        }

        User user = userRepository.findByUsername(loginFormDTO.getUsername());
        if (user == null) {
            errors.rejectValue("username", "user.invalid", "username does not exist");
            model.addAttribute("title", "Log in");
            return "login";
        }

        String password = loginFormDTO.getPassword();

        if (!user.passwordIsCorrect(password)) {
            errors.rejectValue("password", "password.invalid", "Invalid password");
            model.addAttribute("title", "Log in");
            return "login";
        }

        setUserInSession(request.getSession(), user);

        return "redirect:";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return("redirect:/login");
    }

}
