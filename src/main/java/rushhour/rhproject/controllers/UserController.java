package rushhour.rhproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import rushhour.rhproject.entities.User;
import rushhour.rhproject.entities.UserDto;
import rushhour.rhproject.services.interfaces.UserService;

import javax.validation.Valid;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/register")
    public String register(WebRequest request, Model model) {
        model.addAttribute("User", new UserDto());
        return "mainpages/register";
    }

    @PostMapping(value = "/register")
    public ModelAndView registerUserAccount(
            @ModelAttribute("User") @Valid UserDto accountDto) {

        User registered = new User();
            registered = createUserAccount(accountDto);
        return new ModelAndView("/mainpages/login");
    }

    private User createUserAccount(UserDto accountDto) {
        User registered = null;
        registered = userService.registerNewUserAccount(accountDto);
        return registered;
    }
}
