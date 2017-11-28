package java100.app.beans;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

// 1) 빈 컨테이너를 여러 개 만들어 쓸 수 있도록
//    변수와 메서드를 인스턴스 멤버로 전환한다.
//
public class ApplicationContext {
    HashMap<String,Object> beanContainer = 
            new HashMap<>();
    
    // 프로퍼티 파일을 로딩하지 않을 경우를 대비하여 기본 생성자를 만든다.
    public ApplicationContext() {} 
    
    // 2) 생성자에서 프로퍼티 파일을 읽어서 
    //    등록된 클래스의 인스턴스를 생성한다.
    //
    public ApplicationContext(String propPath) {
        Properties props = new Properties();
        
        try (FileReader in = new FileReader(propPath)){
            
            props.load(in); // 주어진 프로퍼티 파일을 읽어 들인다.
            
            Set<Object> keySet = props.keySet();
            for (Object key : keySet) {
                System.out.printf("%s ==> %s\n", key, props.get(key));
            }
            
        } catch (Exception e) {
            throw new BeansException("프로퍼티 파일 로딩 중 오류 발생!");
        }
    }
    
    public Object getBean(String name) {
        Object bean = beanContainer.get(name);
        if (bean == null)
            throw new BeansException("빈을 찾을 수 없습니다.");
        return bean;
    }
    
    public void addBean(String name, Object bean) {
        beanContainer.put(name, bean);
    }
}






