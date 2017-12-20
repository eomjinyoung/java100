package java100.app.control.score;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.annotation.RequestMapping;
import java100.app.annotation.RequestParam;
import java100.app.dao.ScoreDao;
import java100.app.domain.Score;

@Component("/score/add")
public class ScoreAddController {
    
    @Autowired ScoreDao scoreDao;
    
    @RequestMapping
    public String add(
            @RequestParam("name") String name,
            @RequestParam("kor") int kor,
            @RequestParam("eng") int eng,
            @RequestParam("math") int math,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        Score score = new Score();
        score.setName(name);
        score.setKor(kor);
        score.setEng(eng);
        score.setMath(math);
        
        scoreDao.insert(score);
        
        return "redirect:list.do";
    }
}








