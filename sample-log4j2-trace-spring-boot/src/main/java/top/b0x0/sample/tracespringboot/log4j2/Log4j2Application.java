package top.b0x0.sample.tracespringboot.log4j2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author tanglinghan Created By 2022-08-31 22:40
 **/
@SpringBootApplication
@EnableScheduling
public class Log4j2Application {

    public static void main(String[] args) {
        SpringApplication.run(Log4j2Application.class, args);
    }

}
