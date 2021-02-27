package com.kalu.flo;

import com.kalu.flo.model.UserEntity;
import com.kalu.flo.repository.UserEntityRepository;
import com.kalu.flo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.File;

@SpringBootApplication
public class FloApplication {

    public static void main(String[] args) {
        new File(ProductServiceImpl.uploadProduct).mkdir();
        SpringApplication.run(FloApplication.class, args);

    }
}
