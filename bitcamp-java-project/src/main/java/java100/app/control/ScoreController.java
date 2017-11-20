package java100.app.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import java100.app.domain.Score;
import java100.app.util.Prompts;

public class ScoreController extends GenericController<Score> {
    
    private String dataFilePath;
    
    public ScoreController(String dataFilePath) {
        this.dataFilePath = dataFilePath;
        this.init();
    }
    
    @Override
    public void destroy() {
        
        try (PrintWriter out = new PrintWriter(
                                   new BufferedWriter(
                                       new FileWriter(this.dataFilePath)))) {
            for (Score score : this.list) {
                out.println(score.toCSVString());
            }
            
            // 버퍼에 남은 찌꺼기를 마저 출력한다.
            // => 물론 close()가 호출되도 버퍼에 남은 찌꺼기가 출력될 것이다.
            // => 그래도 가능한 명시적으로 출력하자!
            out.flush();
            
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }
    
    // CSV 형식으로 저장된 파일에서 성적 데이터를 읽어 
    // ArrayList에 보관한다.
    @Override
    public void init() {
        
        try (BufferedReader in = new BufferedReader(
                                   new FileReader(this.dataFilePath));) {
            
            String csv = null;
            while ((csv = in.readLine()) != null) {
                try {
                    list.add(new Score(csv));
                } catch (CSVFormatException e) {
                    System.err.println("CSV 데이터 형식 오류!");
                    e.printStackTrace();
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void execute(Request request, Response response) {

        switch (request.getMenuPath()) {
        case "/score/add": this.doAdd(request, response); break;
        case "/score/list": this.doList(request, response); break;
        case "/score/view": this.doView(request, response); break;
        case "/score/update": this.doUpdate(request, response); break;
        case "/score/delete": this.doDelete(request, response); break;
        default: 
            response.getWriter().println("해당 명령이 없습니다.");
        }
    }
    
    private void doDelete(Request request, Response response) {
        System.out.println("[성적 삭제]");
        // Prompts 클래스의 input() 메서드를 사용한 예:
        //String name = Prompts.input("이름? ");
        
        String name = Prompts.inputString("이름? ");
        
        Score score = findByName(name);
        
        if (score == null) {
            System.out.printf("'%s'의 성적 정보가 없습니다.\n", name);
        } else {
            if (Prompts.confirm2("정말 삭제하시겠습니까?(y/N) ")) {
                list.remove(score);
                System.out.println("삭제하였습니다.");
            } else {
                System.out.println("삭제를 취소하였습니다.");
            }
        }
    }

    private void doUpdate(Request request, Response response) {
        System.out.println("[성적 변경]");
        String name = Prompts.inputString("이름? ");
        
        Score score = findByName(name);
        
        if (score == null) {
            System.out.printf("'%s'의 성적 정보가 없습니다.\n", name);
        } else {
            int kor = score.getKor();
            try {
                kor = Prompts.inputInt("국어?(%d) ", score.getKor());
            } catch(Exception e) {}
            
            int eng = score.getEng();
            try {
                eng = Prompts.inputInt("영어?(%d) ", score.getEng());
            } catch(Exception e) {}
            
            int math = score.getMath();
            try {
                math = Prompts.inputInt("수학?(%d) ", score.getMath());
            } catch(Exception e) {}
            
            if (Prompts.confirm2("변경하시겠습니까?(y/N) ")) {
                score.setKor(kor);
                score.setEng(eng);
                score.setMath(math);
                System.out.println("변경하였습니다.");
                
            } else {
                System.out.println("변경을 취소하였습니다.");
            }
        }
    }

    private void doView(Request request, Response response) {
        System.out.println("[성적 상세 정보]");
        String name = Prompts.inputString("이름? ");
        
        Score score = findByName(name);
        
        if (score == null) {
            System.out.printf("'%s'의 성적 정보가 없습니다.\n", name);
            return;
        }
        
        System.out.printf("%-4s, %4d, %4d, %4d, %4d, %6.1f\n",  
                score.getName(),
                score.getKor(),
                score.getEng(),
                score.getMath(),
                score.getSum(), 
                score.getAver());
    }

    private void doList(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[성적 목록]");
        
        Iterator<Score> iterator = list.iterator();
        while (iterator.hasNext()) {
            Score score = iterator.next();
            out.printf("%-4s, %4d, %6.1f\n",  
                    score.getName(), 
                    score.getSum(), 
                    score.getAver());
        }
    }

    private void doAdd(Request request, Response response) {
        System.out.println("[성적 등록]");
        
        Score score = new Score();
        
        score.setName(Prompts.inputString("이름? "));
        score.setKor(Prompts.inputInt("국어? "));
        score.setEng(Prompts.inputInt("영어? "));
        score.setMath(Prompts.inputInt("수학? "));
        
        list.add(score);
    }
    
    private Score findByName(String name) {
        Iterator<Score> iterator = list.iterator();
        while (iterator.hasNext()) {
            Score score = iterator.next();
            if (score.getName().equals(name)) {
                return score;
            }
        }
        return null;
    }
}













