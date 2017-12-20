package java100.app.control.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.annotation.RequestMapping;
import java100.app.annotation.RequestParam;
import java100.app.dao.MemberDao;
import java100.app.domain.Member;

@Component("/member/add")
public class MemberAddController {
    
    @Autowired MemberDao memberDao;
    
    @RequestMapping
    public String add(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        Member member = new Member();
        member.setName(name);
        member.setEmail(email);
        member.setPassword(password);
        
        memberDao.insert(member);
        
        return "redirect:list.do";
    }
}








