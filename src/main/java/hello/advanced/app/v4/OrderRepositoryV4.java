package hello.advanced.app.v4;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace logTrace;

    public void save(String itemId) {
        TraceStatus status = null;
        try{
            status = logTrace.begin("OrderRepository.request()");
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e; // 예외를 꼭 다시 던져주어야 한다.
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
