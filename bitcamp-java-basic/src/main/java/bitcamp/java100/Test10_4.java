// ## printf() 사용법
// - printf()의 사용법을 알아보자.

package bitcamp.java100;

public class Test10_4 {

    public static void main(String[] args) {
// printf(): 특정 형식의 문자열을 만들어 출력한다.
// => 형식
//    %[argument_index$][flags][width][.precision]conversion
//
// 문자열 넣기
// => %s : 문자열 값 넣기.
// => 번호$ : 값의 인덱스를 가리킨다. 1부터 시작한다.
//            값의 인덱스를 지정하지 않으면, 순서대로 대입한다.
//    예) 4$ : 4번째 값을 가리킨다.
// => %자릿수s : 문자열을 출력할 때 차지할 칸 수를 의미한다.
//    예) %5s : 5칸에 문자열을 출력한다. 빈 자리는 공백으로 둔다.
        System.out.printf("%4$2s,%3$3s,%2$4s,%1$5s\n", "a", "b", "c", "d");

    }
}