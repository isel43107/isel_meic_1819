/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.portal.controller;

import domain.dto.UserDto;
import domain.entity.User;
import domain.exception.EmailAlreadyExistException;
import domain.exception.UserAlreadyExistException;
import domain.services.IUserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author pauloborges
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String signinPage() {
        return "auth/signin";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signinPage(Model model) {
        return "auth/signup";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String loginLout() {

        //TODO Close Session at redirect to home page 
        return "redirect:/";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signupPage(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "auth/signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView signupAction(
            @ModelAttribute("user") @Valid UserDto accountDto,
            BindingResult result, WebRequest request, Errors errors) {

        User registered = new User();
        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto, result);
        }

        if (registered == null) {
            
        }
        if (result.hasErrors()) {
            return new ModelAndView("auth/signup", "user", accountDto);
        } else {
            return new ModelAndView("auth/signup_success", "user", accountDto);
        }
    }
    
    @RequestMapping(value = "/signup/confirm", method = RequestMethod.GET)
    public String signupConfirmPage(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "auth/signup_confirm";
    }

    private User createUserAccount(UserDto accountDto, BindingResult result) {
        User registered = null;
        try {
            registered = userService.registerNewUser(accountDto);
        } catch (EmailAlreadyExistException e) {
            result.rejectValue("email", "sigin.email.exist");
        }catch (UserAlreadyExistException e){
            result.rejectValue("username", "sigin.username.exist");
        }
        return registered;
    }

}
