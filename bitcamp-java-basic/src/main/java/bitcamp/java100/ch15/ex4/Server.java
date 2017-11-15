package bitcamp.java100.ch15.ex4;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws Exception {
        // sender와 receiver를 담을 저장소 준비
        ArrayList<SenderStub> senders = new ArrayList<>();
        ArrayList<ReceiverStub> receivers = new ArrayList<>();
        
        // 서버 소켓을 준비한다.
        ServerSocket ss = new ServerSocket(9999);
        
        // 클라이언트 연결을 기다린다.
        for (int i = 0; i < 46; i++) {
            Socket socket = ss.accept();
            
            Scanner in = new Scanner(socket.getInputStream());
            String message = in.nextLine();
            
            if (message.equals("receiver")) {
                // ReceiverStub에 소켓을 담아서 보관한다.
                receivers.add(new ReceiverStub(socket));
            } else {
                // SenderStub에 소켓을 담아서 보관한다.
                senders.add(new SenderStub(socket));
            }
        }
        
        // sender가 보낸 데이터를 읽어서 
        // 모든 receiver에게 전달한다.
        for (SenderStub sender : senders) {
            String message = sender.nextMessage();
            
            for (ReceiverStub receiver : receivers) {
                receiver.receive(message);
            }
        }
    }
}







