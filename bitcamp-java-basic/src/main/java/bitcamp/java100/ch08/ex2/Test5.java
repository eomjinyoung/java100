// 다형성(polymorphism) - 다형적 변수의 활용
// 
package bitcamp.java100.ch08.ex2;

import java.io.File;
import java.net.ServerSocket;

public class Test5 {

    public static void main(String[] args) throws Exception {
        
        Vehicle[] cars = new Vehicle[10];
        cars[0] = new Car();
        
        cars[1] = new Boat();
        cars[2] = new Truck();
        cars[3] = new Sedan();
        
        Object[] objs = new Object[10];
        objs[0] = new Car();
        objs[1] = new String("hello");
        objs[2] = new Integer(10);
        objs[3] = new File("");
        objs[4] = new StringBuffer();
        objs[5] = new ServerSocket(9999);
        
        
    }

}










