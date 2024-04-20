package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FeildServiceTest {

    private FieldService fieldService = new FieldService();

    @Test void field() {
        log.info("name start");
        Runnable userA = () -> {
            fieldService.logic("userA");
        };
        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("userA");
        Thread threadB = new Thread(userB);
        threadB.setName("userB");

        threadA.start();
        //sleep(2000); // 동시성 문제 발생 X
        sleep(100); // 동시성 문제 발생 O

        threadB.start();
        sleep(3000);

        log.info("main exit");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
