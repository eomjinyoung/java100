package java100.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java100.app.dao.MemberDao;
import java100.app.domain.Member;

//@Controller
@RequestMapping("/member")
public class MemberController {
    
    @Autowired MemberDao memberDao;
    
    @RequestMapping("list")
    public String list(Model model) throws Exception {
        model.addAttribute("list", memberDao.selectList());
        return "member/list";
    }
    
    @RequestMapping("add")
    public String add(Member member) throws Exception {
        
        memberDao.insert(member);
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(int no) throws Exception {

        memberDao.delete(no);
        return "redirect:list";
    }
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "member/form";
        
    }
    
    @RequestMapping("update")
    public String update(Member member) throws Exception {
        
        memberDao.update(member);
        return "redirect:list";
    }
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {

        model.addAttribute("member", memberDao.selectOne(no));
        return "member/view";
    }
}








