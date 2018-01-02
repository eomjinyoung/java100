package java100.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java100.app.dao.RoomDao;
import java100.app.domain.Room;

//@Controller
@RequestMapping("/room")
public class RoomController {
    
    @Autowired RoomDao roomDao;
    
    @RequestMapping("list")
    public String list(Model model) throws Exception {
        model.addAttribute("list", roomDao.selectList());
        return "room/list";
    }
    
    @RequestMapping("add")
    public String add(Room room) throws Exception {
        
        roomDao.insert(room);
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(int no) throws Exception {
        
        roomDao.delete(no);
        return "redirect:list";
    }
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "room/form";
    }
}








