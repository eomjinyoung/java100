package java100.app.web.json;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java100.app.domain.Member;
import java100.app.service.FacebookService;
import java100.app.service.MemberService;

@RestController
@RequestMapping("/auth")
@SessionAttributes("loginUser")
public class LoginController {
    
    @Autowired MemberService memberService;
    @Autowired FacebookService facebookService; 
    
    @RequestMapping(value="login", method=RequestMethod.POST)
    public Object login(
            String email, 
            String password,
            boolean saveEmail,
            HttpServletResponse response,
            HttpSession session, /* 세션 객체가 없을 경우 미리 생성할 필요가 있다.*/
            Model model) {
        
        Member member = memberService.get(email, password);
        
        if (saveEmail) {
            Cookie cookie = new Cookie("email", email);
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("email", "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        
        HashMap<String,Object> result = new HashMap<>();
        
        if (member == null) {
            model.addAttribute("loginUser", null);
            result.put("status", "fail"); 
        } else {
            model.addAttribute("loginUser", member);
            result.put("status", "success");
        }
        return result;
    }
    
    @RequestMapping("logout")
    public Object logout(HttpSession session, SessionStatus status) {
        
        // @SessionAttributes에서 관리하는 세션 데이터를 모두 제거한다.
        status.setComplete();
        
        // HttpSession 객체를 무효화시킨다.
        session.invalidate();
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        return result;
    }
    
    @RequestMapping("loginUser")
    public Object loginUser(HttpSession session) {
        
        Member member = (Member)session.getAttribute("loginUser");
        
        HashMap<String,Object> result = new HashMap<>();
        
        if (member != null) {
            result.put("status", "success");
            result.put("member", member);
        } else {
            result.put("status", "fail");
        }
            
        return result;
    }
    
    
    @RequestMapping(value="facebookLogin")
    public Object facebookLogin(
            String accessToken, 
            HttpSession session, /* 세션 객체가 없을 경우 미리 생성할 필요가 있다.*/
            Model model) {
        
        
        // Facebook에서 사용자 정보를 가져온다.
        @SuppressWarnings("rawtypes")
        Map fbResponse = facebookService.me(accessToken, Map.class);
        
        if (fbResponse.get("error") != null) {
            model.addAttribute("loginUser", null);
            HashMap<String,Object> result = new HashMap<>();
            result.put("status", "fail"); 
            return result;
        }
        
        // 이메일로 회원 정보를 찾는다.
        Member member = memberService.get((String)fbResponse.get("email"));
        
        if (member == null) {
            // 회원 정보가 없으면 페이스북 회원 정보를 등록한다.
            member = new Member();
            member.setName((String)fbResponse.get("name"));
            member.setEmail((String)fbResponse.get("email"));
            member.setPassword("1111");
            memberService.add(member);
        }
        
        model.addAttribute("loginUser", member);
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        return result;
    }      
}










