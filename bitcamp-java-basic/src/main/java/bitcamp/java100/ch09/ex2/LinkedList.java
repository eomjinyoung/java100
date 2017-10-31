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
    
    public void insert(int index, Object value) {
        if (index < 0 || index >= len)
            return;
        
        Box box = new Box();
        box.value = value;
        
        len++;
        
        if (index == 0) {
            box.next = head;
            head = box;
            return;
        }
        
        Box pre = head;
        
        // 값을 삽입할 박스의 바로 전 박스를 알아낸다. 
        for (int count = 1; count < index; count++) {
            pre = pre.next;
        }
        
        // 새 박스가 삽입할 위치의 박스를 가리키게 한다.
        box.next = pre.next;
        
        // 바로 전 박스는 새 박스를 가리키게 한다.
        pre.next = box;
    }
    
    public Object remove(int index) {
        return null;
    }
}










