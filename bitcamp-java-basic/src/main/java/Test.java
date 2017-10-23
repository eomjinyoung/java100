import java.io.Console;

public class Test {
    
    static Console console;
    static Score[] scores = new Score[10000];
    static int cursor = 0;
    
    static void prepareScore() {
        console = System.console();
        if (console == null) {
            System.err.println("콘솔 출력을 지원하지 않습니다!");
            System.exit(1);
        }
        
        while (true) {
            Score score = new Score();
            score.name = console.readLine("이름? ");
            score.kor = Integer.parseInt(console.readLine("국어 점수? "));
            score.eng = Integer.parseInt(console.readLine("영어 점수? "));
            score.math = Integer.parseInt(console.readLine("수학점수? "));
            score.sum = score.kor + score.eng + score.math;
            score.aver = score.sum / 3f;

            scores[cursor++] = score;
            
            if (cursor == scores.length) {
                System.out.println("최대 저장 개수를 초과했습니다!");
                break;
            }

            if (!confirm("계속 입력하시겠습니까?")) {
                break;
            }
            
        }
    }
    
    static void printScore() {
        for (int i = 0; i < cursor; i++) {
            System.out.printf("%s, %d, %d, %d, %d, %f\n", 
                scores[i].name, 
                scores[i].kor, 
                scores[i].eng, 
                scores[i].math, 
                scores[i].sum, 
                scores[i].aver);
        }
    }
    
    static boolean confirm(String message) {
        String response = console.readLine(message).toLowerCase();
        if (response.equals("y") || response.equals("yes")) {
            return true;
        }
        return false;
    }
    
    
    public static void main(String[] args) {
        prepareScore();
        printScore();
    }
}
