// Byte 스트림 응용 => 파일 복사하기 - 버퍼 적용
//

package bitcamp.java100.ch14.ex3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test3 {
    public static void main(String[] args) throws Exception {
        
        FileInputStream in = new FileInputStream(
                                    new File("sample/jls9.pdf"));
        
        FileOutputStream out = new FileOutputStream(
                                    new File("sample/jls9-3.pdf"));
                
        
        byte[] buf = new byte[8192];
        int len = 0;
        
        long start = System.currentTimeMillis();
        
        while ((len = in.read(buf)) != -1) {
            out.write(buf, 0, len);
        }
        
        long end = System.currentTimeMillis();
        System.out.printf("걸린시간 = %d\n", end - start);
        
        // 4) 항상 사용을 마친 자원은 해제시킨다.
        in.close();
        out.close();
        
        System.out.println("파일 복사 완료했음!");
    }
}






