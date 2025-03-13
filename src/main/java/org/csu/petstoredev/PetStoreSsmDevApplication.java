package org.csu.petstoredev;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan (basePackages={"org.csu.petstoredev.interceptor","org.csu.petstoredev.config","org.csu.petstoredev.persistence"})
//@ComponentScan(basePackages={"org.csu.petstoredev.interceptor","org.csu.petstoredev.config"})

public class PetStoreSsmDevApplication {

    public static void main(String[] args) {


        SpringApplication.run(PetStoreSsmDevApplication.class, args);
    }

}
