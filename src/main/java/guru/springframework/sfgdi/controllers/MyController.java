package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

/**
 * Created by jt on 12/26/19.
 */
@Controller
public class MyController implements InitializingBean {

    @Value("string value")
    private String stringValue;

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        System.out.println("SET STRING VALUE");
        this.stringValue = stringValue;
    }

    private GreetingService greetingService;

    public GreetingService getGreetingService() {
        return greetingService;
    }

    @Autowired
    public void setGreetingService(GreetingService greetingService) {
        System.out.println("CALLED SETTING GREETING SERVICE");
        this.greetingService = greetingService;
    }

    public String sayHello(){
        return greetingService.sayGreeting();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("NAKON ŠTO SU PROPERTYI POSTAVLJENI..");
    }

    @PostConstruct
    public void test(){
        System.out.println("NAKON ŠTO JE BEAN GOTOV ALI PRIJE KORIŠTENJA");
    }
}
