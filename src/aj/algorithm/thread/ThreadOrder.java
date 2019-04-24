package aj.algorithm.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

class PreThread implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();

    private final CountDownLatch latch;
    private final String name;

    public PreThread(String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
    }
    @Override
    public void run() {
//        synchronized(latch) {
            lock.lock();
            System.out.println("PreThread: " + name + ". latch.getCount() = " + latch.getCount());
            latch.countDown();
            lock.unlock();
//        }
    }
}

class PostThread implements Runnable {

    private final CountDownLatch latch;
    private final String name;

    public PostThread(String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
    }
    @Override
    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("PostThread: "+ name + ". latch.getCount() = " + latch.getCount());
    }
}
public class ThreadOrder {
    public static void main(String[] args) {
        int count = 10;
        CountDownLatch latch = new CountDownLatch(count);
        List<PreThread> preThreads = new ArrayList<PreThread>();
        for(Integer i=0;i<count;i++){
            preThreads.add(new PreThread(i.toString(), latch));
        }
        PostThread postThread = new PostThread("1", latch);
        new Thread(postThread).start();

        preThreads.stream()
                .map(thread -> new Thread(thread))
        .forEach(thread -> thread.start());

    }
}
