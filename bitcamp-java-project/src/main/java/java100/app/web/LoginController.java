package java100.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth")
public class LoginController {
    
    @RequestMapping(value="login", method=RequestMethod.GET)
    public String form() {
        return "auth/loginform";
    }
}
