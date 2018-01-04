// AOP(Aspect-Oriented Programming) - advice 적용 위치 
// 
package bitcamp.java100.ch21.ex5;

public class Test1 {

    public static void main(String[] args) {
        
        
        
        Front obj;

        obj.test("홍길동");
        
        System.out.println("------------------------------------------");
        
        obj.test(null); // 예외가 발생하는 경우!
        
    }
}








