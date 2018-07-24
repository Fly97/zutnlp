package edu.zut.cs.zutnlp.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages="edu.zut.cs")
@RestController
public class AdminApplication {
    @RequestMapping(value = "/index")
    String index(){
        return "index";
    }
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class,args);
    }
}
