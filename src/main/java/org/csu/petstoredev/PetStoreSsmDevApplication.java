package org.csu.petstoredev;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan ("org.csu.petstoredev.persistence")
public class PetStoreSsmDevApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetStoreSsmDevApplication.class, args);
    }

}
