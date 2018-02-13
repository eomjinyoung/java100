package java100.app.service.impl;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java100.app.service.FacebookService;

@Service
public class FacebookServiceImpl implements FacebookService {

    @Override
    public <T> T me(String accessToken, Class<T> clazz) {
        HashMap<String,String> parameters = new HashMap<>();
        parameters.put("access_token", accessToken);
        parameters.put("fields", "id,name,email");
        
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            protected void handleError(ClientHttpResponse response, HttpStatus statusCode) throws IOException {
                System.out.println("Facebook에서 사용자 정보를 가져올 수 없습니다!");
            }
        });
        return restTemplate.getForObject(
                "https://graph.facebook.com/v2.12/me?access_token={access_token}&fields={fields}", 
                clazz, 
                parameters);
    }
    
}
