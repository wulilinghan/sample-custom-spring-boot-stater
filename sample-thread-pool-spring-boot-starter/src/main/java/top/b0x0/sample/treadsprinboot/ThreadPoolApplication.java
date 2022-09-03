package top.b0x0.sample.treadsprinboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author tanglinghan Created By 2022-09-03 14:30
 **/
@SpringBootApplication
public class ThreadPoolApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThreadPoolApplication.class, args);
    }

    @RestController
    public static class EchoController {
        @Resource
        ThreadPoolExecutor myStarterThreadPool;

        @GetMapping("echo")
        public String echo() {
            System.out.println("[ MAIN ] - " + currentThreadName());
            myStarterThreadPool.execute(() -> {
                String currentThreadName = currentThreadName();
                System.out.println("[ MyStarterThreadPool ] - " + currentThreadName);
            });
            System.out.println("[ MAIN ] - " + currentThreadName());
            return currentThreadName();
        }

        @GetMapping("info")
        public Map<String, Object> treadInfo() {
            int activeCount = myStarterThreadPool.getActiveCount();
            long taskCount = myStarterThreadPool.getTaskCount();
            Map<String, Object> map = new HashMap<>(8);
            map.put("activeCount", activeCount);
            map.put("taskCount", taskCount);
            return map;
        }
    }

    static String currentThreadName() {
        return Thread.currentThread().getName();
    }
}
