package java100.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java100.app.dao.BoardDao;
import java100.app.domain.Board;

@Controller
@RequestMapping("/board")
public class BoardController {
    
    @Autowired BoardDao boardDao;
    
    @RequestMapping("list")
    public String list(Model model) throws Exception {

        model.addAttribute("list", boardDao.selectList());
        return "board/list";
    }
    
    @RequestMapping("add")
    public String add(Board board) throws Exception {
        
        boardDao.insert(board);
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(int no) throws Exception {

        boardDao.delete(no);
        return "redirect:list";
    }
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "board/form";
        
    }
    
    @RequestMapping("update")
    public String update(Board board) throws Exception {
        
        boardDao.update(board);
        return "redirect:list";
    }
    
    @RequestMapping("view")
    public String view(int no, Model model) throws Exception {

        model.addAttribute("board", boardDao.selectOne(no));
        return "board/view";
    }
}








