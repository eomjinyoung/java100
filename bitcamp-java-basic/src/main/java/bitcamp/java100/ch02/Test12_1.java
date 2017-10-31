// ## 메모리 준비
// 값을 저장하기 위해 메모리를 준비하는 방법을 알아보자!
//

package bitcamp.java100;

public class Test12_1 {

    public static void main(String[] args) {
// 자바 원시 타입의 메모리 준비하기
        byte b;   //정수를 저장할 1바이트 크기의 메모리 준비
        short s;  //정수를 저장할 2바이트 크기의 메모리 준비
        int i;    //정수를 저장할 4바이트 크기의 메모리 준비
        long l;   //정수를 저장할 8바이트 크기의 메모리 준비
        float f;  //부동소수점을 저장할 4바이트 크기의 메모리 준비
        double d; //부동소수점을 저장할 8바이트 크기의 메모리 준비
        boolean bool; //논리 값을 저장할 4바이트 크기의 메모리 준비
        char c; //유니코드 값을 저장할 2바이트 크기의 메모리 준비

// 메모리에 값 저장하기: '=' 연산자를 사용한다.
// => '=' 연산자는 "assignment" 연산자라 부른다.
// => l-value = r-value 
// => l-value는 항상 메모리여야 한다.
// => r-value 값이거나 메모리가 될 수 있다.
        b = 100;
        s = 100;
        i = 100;
        l = 100;
        f = 3.14f;
        d = 3.14;
        bool = true;
        c = 44032;        
        
// 메모리에 저장된 값 출력하기
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(bool);
        System.out.println(c);
    }
}

// ### 메모리 준비 
// - 메모리를 준비할 때 어떤 종류의 값을 저장할 것인지 지정해야 한다.
// - 그리고 그 용도로만 사용할 수 있다.
// - 이것을 "변수 선언" 이라 부른다.
// - 값 종류를 "데이터 타입" 이라 부른다.
// - 문법 
//   [값 종류] 메모리이름;
//   [데이터타입] 변수명;
// 
// ### 메모리와 데이터 타입
// 1) 정적 타입 바인딩(static type binding)
// - 메모리를 특정 용도로 묶어 놓는 것.
// - 메모리를 준비할 때 그 메모리에 담을 값의 종류를 한 번 결정하면,
//   다시 바꿀 수 없는 방식
// - Java, C/C++ 등이 이에 해당한다.
// - 메모리를 한 가지 용도로 제한하는 이유?
//   => 유지보수할 때 혼동을 줄이기 위함.
//   => 변수를 잘못 사용하는 경우를 줄임으로써 시스템의 안정성을 높이기 위함이다.
// 
// 2) 동적 타입 바인딩(dynamic type binding)
// - 메모리가 특정 용도에 묶이지 않는 것.
// - 메모리에 값을 넣을 때 그 메모리의 용도가 결정된다.
// - 다른 종류의 값을 넣으면 그 메모리의 용도가 바뀐다.
// - 보통 JavaScript, Python 등 스크립트류의 프로그래밍 언어에서 사용하는 방식이다.
//
// ### 자바에서 제공하는 메모리 종류[데이터 타입]
// 1) 정수 값 
//    byte      : 1바이트 메모리. -128 ~ +127
//    short     : 2바이트 메모리. -32768 ~ + 32767
//    int       : 4바이트 메모리. 약 -21억 ~ +21억
//    long      : 8바이트 메모리. 약 -900경 ~ +900경 
//    char      : 2바이트 메모리. 0 ~ +65535
//  
// * 참고 
// - 자바에서 정수 값을 표현할 때 두 가지 크기로만 표현한다.
// - 4바이트 정수와 8바이트 정수 
// - 1바이트, 2바이트 정수를 표현하는 방법은 없다.
//
// 2) 부동소수점 값
//    float     : 4바이트 메모리. 유효자릿수 7자리.
//    double    : 8바이트 메모리. 유효자릿수 15자리.
//
// 3) 논리 값
//    boolean   : 4바이트 메모리. 배열일 때는 1바이트를 사용.
// 
// 4) 주소 값 
//    배열이나 인스턴스의 주소를 담는 경우에 사용한다.
//
// ### 자바 원시 데이터 타입(primitive data type)
// - 자바 언어에서 기본으로 정의한 데이터 타입이다.
// - byte, short, int, long, float, double, boolean, char 이렇게 8가지의 데이터 타입을 자바 원시 타입이라 부른다.
// - 시스템을 개발하는 동안에 기본 데이터 타입 이외의 다른 종류의 데이터를 메모리에 저장하고 싶다면, 개발자가 직접 자신만의 데이터 타입을 정의해서 써야 한다.
// - 이렇게 개발자가 추가로 정의한 데이터 타입을 "사용자 정의 데이터 타입" 이라 부른다. 이때 사용자란? 그 언어를 사용하는 자. 즉 개발자를 의미한다.
// - 사용자 정의 데이터 타입을 만드는 문법?
//   => class 문법을 사용하여 만든다.
//
// ### class
// - 사용자 정의 데이터 타입을 만드는 문법
// - 메서드를 관리하기 쉽게 분류하는 문법 
   