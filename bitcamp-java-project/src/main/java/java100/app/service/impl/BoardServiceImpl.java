package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.BoardDao;
import java100.app.dao.FileDao;
import java100.app.domain.Board;
import java100.app.domain.UploadFile;
import java100.app.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired BoardDao boardDao;
    @Autowired FileDao fileDao;
    
    @Override
    public List<Board> list(int pageNo, int pageSize, Map<String, Object> options) {
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        
        if (options != null) {
            params.putAll(options);
        }
        
        return boardDao.findAll(params);
    }

    @Override
    public Board get(int no) {
        boardDao.updateViewCount(no);
        return boardDao.findByNo(no);
    }
    
    @Override
    public int getTotalCount() {
        return boardDao.countAll();
    }

    @Override
    public int add(Board board) {
        int count = boardDao.insert(board);
        
        List<UploadFile> files = board.getFiles();
        
        for (UploadFile file : files) {
            fileDao.insert(file);
        }
        
        return count;
    }

    @Override
    public int update(Board board) {
        return boardDao.update(board);
    }

    @Override
    public int delete(int no) {
        return boardDao.delete(no);
    }

}
