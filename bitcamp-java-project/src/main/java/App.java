//: ## ver 08
//: - 클래스를 관리하기 쉽도록 별도의 파일로 분리하다. 
//: - 메서드를 사용하여 반복 코드를 분리한다.
//: 
//: 여러 명의 성적을 저장하고 다음과 같이 출력하라!
//:
//: 출력내용:
//: ```
//: 홍길동, 100,  90,  80, 270,  90.0
//: 임꺽정,  80,  80,  80, 240,  80.0
//: 유관순, 100, 100, 100, 300, 100.0
//: ```
 
public class App {
    
    //: 합계와 평균을 계산하는 코드를 다음과 같이 별도의 메서드로 분리한다.
    static void compute(Score score) {
        for (int sub : score.subjects) {
            score.sum += sub;
        }
        score.aver = score.sum / 3f;
    }
    
    //: 성적 데이터를 출력하는 코드를 별도의 메서드로 분리한다.
    static void print(Score score) {
        System.out.printf("%-4s, %4d, %4d, %4d, %4d, %6.1f\n",  
                score.name, 
                score.subjects[0], 
                score.subjects[1], 
                score.subjects[2], 
                score.sum, 
                score.aver);
    }

    public static void main(String[] args) {
        
        Score[] scores = {new Score(), new Score(), new Score()};
        
        scores[0].name = "홍길동";
        scores[0].subjects[0] = 100;
        scores[0].subjects[1] = 90;
        scores[0].subjects[2] = 80;
        compute(scores[0]);
        
        scores[1].name = "임꺽정";
        scores[1].subjects[0] = 80;
        scores[1].subjects[1] = 80;
        scores[1].subjects[2] = 80;
        compute(scores[1]);
        
        scores[2].name = "유관순";
        scores[2].subjects[0] = 100;
        scores[2].subjects[1] = 100;
        scores[2].subjects[2] = 100;
        compute(scores[2]);
        
        //: 학생 성적을 출력한다.
        for (Score s : scores) {
            print(s);
        }
        
        
    }
}




