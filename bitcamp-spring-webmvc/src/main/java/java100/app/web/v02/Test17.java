// 요청 핸들러의 파라미터 - @RequestBody II
//
package java100.app.web.v02;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

@Controller
@RequestMapping("/v02/test17")
public class Test17 {

    // 테스트 방법:
    // => http://localhost:9999/spring-webmvc/v02/test17.html
    
    // JSON 문자열 ==> 자바 객체
    // => google-json 라이브러리를 이용하여 처리한다.
    // => mvnrepository.com에서 "google-gson"으로 검색한다.
    // => 라이브러리 정보를 build.gradle에 추가한다.
    // => "gradle eclipse"를 실행하여 라이브러리를 다운로드하고 
    //    이클립스 설정 파일을 갱신한다.
    // => 프로젝트를 "Refresh" 한다.
    // 
    @RequestMapping("/m1")
    public String m1(@RequestBody String json) {
        
        // JSON 문자열 ==> Map 객체
        @SuppressWarnings("rawtypes")
        Map obj = new Gson().fromJson(json, Map.class);
        
        System.out.printf("name=%s\n", obj.get("name"));
        System.out.printf("age=%f\n", obj.get("age"));
        System.out.printf("tel=%s\n", obj.get("tel"));
        System.out.printf("email=%s\n", obj.get("email"));
        
        System.out.println("--------------------");
        return "/hello.jsp";
    }
    
    // // JSON 문자열 ==> 특정 자바 객체
    // 
    
    class User {
        String name;
        int age;
        String tel;
        String email;
    }
    
    @RequestMapping("/m2")
    public String m2(@RequestBody String json) {
        
        User user = new Gson().fromJson(json, User.class);
        
        System.out.printf("name=%s\n", user.name);
        System.out.printf("age=%d\n", user.age);
        System.out.printf("tel=%s\n", user.tel);
        System.out.printf("email=%s\n", user.email);
        
        System.out.println("--------------------");
        return "/hello.jsp";
    }
    
}










