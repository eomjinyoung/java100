package java100.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java100.app.dao.ScoreDao;
import java100.app.domain.Score;

@Controller
@RequestMapping("/score")
public class ScoreController {
    
    @Autowired ScoreDao scoreDao;
    
    @RequestMapping("list")
    public String list(Model model) throws Exception {

        model.addAttribute("list", scoreDao.selectList());
        return "score/list";
    }
    
    @RequestMapping("add")
    public String add(Score score) throws Exception {
        
        scoreDao.insert(score);
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(int no) throws Exception {
        
        scoreDao.delete(no);
        return "redirect:list";
    }
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "score/form";
    }
    
    @RequestMapping("update")
    public String update(Score score) throws Exception {
        
        scoreDao.update(score);
        return "redirect:list";
    }
    
    @RequestMapping("view")
    public String view(int no, Model model) throws Exception {
        
        model.addAttribute("score", scoreDao.selectOne(no));
        return "score/view";        
    }
}








