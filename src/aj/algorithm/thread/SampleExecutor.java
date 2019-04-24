package aj.algorithm.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Printer implements Runnable {
    private final String item;

    public Printer(String item) {
        this.item = item;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": item = " + item);
    }
}
public class SampleExecutor {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(Integer i=0;i<10; i++) {
            executorService.submit(new Printer(i.toString()));
        }
        executorService.shutdown();
    }
}
