/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.portal.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author pauloborges
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping(method = RequestMethod.GET)
    public String loginPage() {
        return "auth/signin";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String loginLout() {
        
        //TODO Close Session at redirect to home page 
        return "redirect:/";
        
    }
    
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String registerPage(Model model) {
        return "auth/signup";
    }
}
