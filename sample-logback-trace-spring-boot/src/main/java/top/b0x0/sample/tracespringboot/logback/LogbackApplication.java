package top.b0x0.sample.tracespringboot.logback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author tanglinghan Created By 2022-08-31 22:40
 **/
@SpringBootApplication
@EnableScheduling
public class LogbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogbackApplication.class, args);
    }

}
