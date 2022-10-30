package was.counter;

// 멀티쓰레드 환경에서 하나의 자원을 공유하게 되면 원치 않는 결과 발생할 수 있다.
// RaceCondition : 여러 프로세스 혹은 쓰레드가 동시에 하나의 자원에 접근하기 위해 경쟁하는 상태
// 동기화 처리로 해결가능하다.
public class RaceConditionDemo {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread th1 = new Thread(counter, "Thread-1");
        Thread th2 = new Thread(counter, "Thread-2");
        Thread th3 = new Thread(counter, "Thread-3");

        th1.start();
        th2.start();
        th3.start();
    }
}
