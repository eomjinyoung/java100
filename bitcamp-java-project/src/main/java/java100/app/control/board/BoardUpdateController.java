package java100.app.control.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.annotation.RequestMapping;
import java100.app.annotation.RequestParam;
import java100.app.dao.BoardDao;
import java100.app.domain.Board;

@Component("/board/update")
public class BoardUpdateController {
    
    @Autowired BoardDao boardDao;
    
    @RequestMapping
    public String update(
            @RequestParam("no") int no,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        Board board = new Board();
        board.setNo(no);
        board.setTitle(title);
        board.setContent(content);
        
        boardDao.update(board);
        
        return "redirect:list.do";
    }
}








