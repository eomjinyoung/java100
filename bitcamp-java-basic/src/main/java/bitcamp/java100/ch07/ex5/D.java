// 생성자를 정의하지 않으면
// 컴파일러는 기본 생성자를 자동으로 추가한다.
// 그 기본 생성자는 내부에서 수퍼 클래스의 기본 생성자를 호출한다.
// 
package bitcamp.java100.ch07.ex5;

public class D extends C {
    // 생성자를 만들지 않으면 다름과 같이 기본 생성자가 추가된다.
    /*
    D() {
        super();  // <== 문제는 컴파일러가 추가한 기본 생성자는
                  //     수퍼 클래스의 기본 생성자를 호출한다는 것이다.
                  //     D의 수퍼 클래스인 C에는 기본 생성자가 없다.
    }
    */
    
    // 이런 경우 개발자가 직접 생성자를 추가해야 한다.
    
    D() {
        // 또한 수퍼 클래스 C에 기본 생성자가 없기 때문에 
        // 수퍼 클래스의 존재하는 생성자를 호출하도록 명시적으로 작성해야 한다.
        super("hi");
        
        // 왜? 수퍼 클래스의 생성자 호출을 생략하면 다음과 같이
        // 수퍼 클래스의 기본 생성자를 호출하는 코드가 자동으로 추가되기 때문이다.
        //super();
    }
    
}









