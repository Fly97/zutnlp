package edu.zut.cs.zutnlp.cv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "edu.zut.cs")
@Controller
public class Application {
    @RequestMapping("/")
    String index(){
        return"main/index";
    }
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
