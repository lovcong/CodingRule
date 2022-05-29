package com.lovcong.codingrule;

import com.lovcong.codingrule.impls.segments.FixedRuleSegment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CodingruleApplication {

    @Autowired
    ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(CodingruleApplication.class, args);
    }


}
