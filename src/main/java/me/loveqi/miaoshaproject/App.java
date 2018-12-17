package me.loveqi.miaoshaproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot start class
 *
 * @author loveqi
 */
@SpringBootApplication(scanBasePackages = {"me.loveqi.miaoshaproject"})
@MapperScan("me.loveqi.miaoshaproject.dao")
public class App {

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

}
