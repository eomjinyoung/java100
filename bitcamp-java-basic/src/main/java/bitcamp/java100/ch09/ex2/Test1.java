// 컬렉션 - LinkedList
package bitcamp.java100.ch09.ex2;

public class Test1 {

    public static void main(String[] args) {
        
        LinkedList list = new LinkedList();
        
        list.add("홍길동");
        list.add("임꺽정");
        list.add("유관순");
        list.add("안중근");
        list.add("윤봉길");
        
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s ", list.get(i));
        }
        System.out.println();
        System.out.println("--------------------------------");
    }

}
