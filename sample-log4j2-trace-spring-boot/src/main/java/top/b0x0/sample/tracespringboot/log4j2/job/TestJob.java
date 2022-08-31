package top.b0x0.sample.tracespringboot.log4j2.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TestJob {
    private static final Logger log = LoggerFactory.getLogger(TestJob.class);

    /**
     * 5秒钟执行一次
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void printCurTime() {
        log.info("TestJob.printCurTime:{}", getCurTime());
    }

    private String getCurTime() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowTime = df.format(LocalDateTime.now());
        log.info("getCurTime:{}", nowTime);
        return nowTime;
    }

    @Scheduled(cron = "0/30 * * * * ?")
    public void printError() {
        log.error("TestJob.printError 【this is error log】{}", getCurTime());
    }
}