// 세션 다루기 - @SessionAttributes 애노테이션 사용 
//
package java100.app.web.v03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/v03/test07")

// Model 객체에 보관되는 값은 프론트 컨트롤러가 JSP를 실행하기 전에 
// ServletRequest 보관소에 복사를 하는데,
// 다음 애노테이션에 지정된 값은 세션 보관소에도 복사한다.
@SessionAttributes({"name","age"})
public class Test07 {
    
    // 세션에 저장하고 싶은 값이 있으면,
    // Map/Model 객체에 담는다.
    @RequestMapping(value="/m1", produces="text/plain;charset=UTF-8")
    public String m1(Model model) {
        
        // 프론트 컨트롤러가 준 Model 객체에 값을 저장하면,
        // 이 값은 ServletRequest 저장소에 보관된다.
        // 만약 Model에 저장되는 값의 이름이 
        // 클래스 선언부에 붙인 @SessionAttributes에 설정되어 있다면,
        // 그 값은 HttpSession 객체에 보관된다.
        model.addAttribute("name", "홍길동");
        model.addAttribute("age", 20); // auto-boxing : Integer 객체 저장
        model.addAttribute("working", true); // auto-boxing : Boolean 객체 저장
        
        // Model에 보관된 값이 ServletRequest에 저장되었는지 확인해보자!
        return "v03/test07/m1";
    }
    
    
}










