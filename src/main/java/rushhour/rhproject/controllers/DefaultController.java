package rushhour.rhproject.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import rushhour.rhproject.entities.UserDto;

import javax.validation.Valid;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String home1() {
        return "mainpages/index";
    }

    @GetMapping("/home")
    public String home() {
        return "mainpages/index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "mainpages/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "mainpages/user";
    }

    @GetMapping("/about")
    public String about() {
        return "mainpages/about";
    }

    @GetMapping("/login")
    public String login() {
        return "mainpages/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/mainpages/403";
    }

    @GetMapping("/for_users")
    @PreAuthorize("hasRole('ROLE_USER')")
    public @ResponseBody String users(){
        return "I am USER method";
    }



    /*@RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "register";
    }*/


}