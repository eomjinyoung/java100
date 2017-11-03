package java100.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BoardController {
    
    static Scanner keyScan = new Scanner(System.in);
    private ArrayList<Board> list = new ArrayList<>();
    
    public void execute() {
        loop:
        while (true) {
            System.out.print("게시판> ");
            String input = keyScan.nextLine();
            
            // 명령어를 처리하는 각 코드를 별도의 메서드로 추출한다.
            switch (input) {
            case "list": this.doList(); break;
//            case "add": this.doAdd(); break;
//            case "view": this.doView(); break;
//            case "update": this.doUpdate(); break;
//            case "delete": this.doDelete(); break;
            case "main": break loop;
            default: 
                System.out.println("해당 명령이 없습니다.");
            }
        }
    }
    
    private void doList() {
        System.out.println("[게시물 목록]");
        
        Iterator<Board> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().print();
        }
    }
}
