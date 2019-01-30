package web.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String paginaInicial(Model model) {
        
        //TODO present home page with 
        //return "redirect:/dashboard";
        return "index";
    }
}
