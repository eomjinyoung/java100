// 역할:
// => Box를 이용하여 여러 개의 값을 보관하고 꺼내는 일을 한다.
// => 값을 저장할 때 Box에 보관한다.
// => 체인처럼 Box와 Box 사이에 주소를 이용하여 연결을 관리한다.
//   
package bitcamp.java100.ch09.ex2;

public class LinkedList {
    // 시작 상자와 끝 상자의 주소
    Box head;
    Box tail;
    
    // 전체 상자 개수
    int len;
    
    public void add(Object value) {
        // 값을 보관할 상자를 준비한다.
        Box box = new Box();
        
        // 상자에 값을 담는다.
        box.value = value;
        
        // 목록의 끝에 상자를 연결한다.
        if (tail == null) {
            head = box;
            tail = box;
        } else {
            tail.next = box;
            tail = box;
        }
        
        len++;
    }
    
    public int size() {
        return len;
    }
    
    public Object get(int index) {
        if (index < 0 || index >= len)
            return null;
        
        Box box = head;
        for (int count = 1; count <= index; count++) {
            box = box.next;
        }
        
        return box.value;
    }
}










