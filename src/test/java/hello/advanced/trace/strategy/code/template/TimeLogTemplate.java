package hello.advanced.trace.strategy.code.template;

import hello.advanced.trace.strategy.code.strategy.template.Callback;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {

    public void execute(Callback callback) {
        long startTime = System.currentTimeMillis();
        //비지니스 로직 실행
        callback.Call(); //위임
        //비지니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

}
