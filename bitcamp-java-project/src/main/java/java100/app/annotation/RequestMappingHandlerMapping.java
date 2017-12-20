package java100.app.annotation;

import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

public class RequestMappingHandlerMapping {
    
    public static class RequestHandler {
        Object controller;
        Method handler;
    }
    
    public RequestMappingHandlerMapping(ApplicationContext iocContainer) {
        
        // 스프링 IoC 컨테이너에서 @Controller 가 표시된 객체를 추출한다.
        // 즉 페이지 컨트롤러를 꺼낸다.
        String[] controllerNames = 
                iocContainer.getBeanNamesForAnnotation(Controller.class);
        
        for (String controllerName : controllerNames) {
            Object controller = iocContainer.getBean(controllerName);
            System.out.println(controller.getClass().getName());
        }
    }
}










