package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.ScoreDao;
import java100.app.domain.Score;
import java100.app.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired ScoreDao scoreDao;
    
    @Override
    public List<Score> list(int pageNo, int pageSize, Map<String, Object> options) {
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        
        if (options != null) {
            params.putAll(options);
        }
        
        return scoreDao.findAll(params);
    }

    @Override
    public Score get(int no) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int add(Score score) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(Score score) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(int no) {
        // TODO Auto-generated method stub
        return 0;
    }

}
