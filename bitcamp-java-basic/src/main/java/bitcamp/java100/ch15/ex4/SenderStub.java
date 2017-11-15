package bitcamp.java100.ch15.ex4;

import java.net.Socket;
import java.util.Scanner;

public class SenderStub {
    Socket socket;
    Scanner in;
    
    public SenderStub(Socket socket) throws Exception {
        this.socket = socket;
        
        System.out.printf("송신자(%s)가 연결되었음\n", 
                socket.getInetAddress().getHostAddress());
        
        // sender는 서버쪽으로 데이터를 보내기만 한다.
        // 그래서 서버에서는 데이터를 읽는 도구만 필요하다.
        in = new Scanner(socket.getInputStream());
    }

    // 소켓과 연결된 클라이언트로부터 메시지를 한 줄 읽어서 리턴한다.
    // => 주의!
    //    - 클라이언트가 메시지를 한 줄 보내지 않으면 영원히 여기에 갇힌다.
    public String nextMessage() {
        return in.nextLine();
    }
}




