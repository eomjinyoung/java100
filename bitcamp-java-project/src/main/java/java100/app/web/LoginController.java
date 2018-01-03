package java100.app.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java100.app.dao.MemberDao;
import java100.app.domain.Member;

@Controller
@RequestMapping("/auth")
public class LoginController {
    
    @Autowired MemberDao memberDao;
    
    @RequestMapping(value="login", method=RequestMethod.GET)
    public String form() {
        return "auth/loginform";
    }
    
    @RequestMapping(value="login", method=RequestMethod.POST)
    public String login(String email, String password) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        
        Member member = memberDao.findByEmailAndPassword(params);
        
        if (member == null) {
            return "auth/loginfail"; 
        }
        
        return "redirect:../score/list";
    }
}










