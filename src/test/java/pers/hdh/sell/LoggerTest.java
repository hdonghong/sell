package pers.hdh.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * LoggerTest class<br/>
 *
 * @author hdonghong
 * @date 2018/04/02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

//    @Slf4j注解代替
//    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1() {
   /*
        logger.debug("debug...");
        logger.info("info...");
        logger.error("error...");
    */
        String user = "root";
        String pwd = "toor";
        log.info("user: {}, password: {}", user, pwd);
        log.debug("debug...");
        log.info("info...");
        log.error("error");
        log.warn("warn");
    }
}
