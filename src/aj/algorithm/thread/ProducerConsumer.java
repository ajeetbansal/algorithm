package aj.algorithm.thread;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Producer implements Runnable {

    private final BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String item = "";
        System.out.println("Enter items to be processed. Enter \"end\" to stop");
        do{
            try {
                item = scanner.nextLine();
                queue.put(item);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while(!item.equals("end"));
    }
}
class Consumer implements Runnable {
    private final BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String item = "";
        do{
            try {
                item = queue.take();
                System.out.println("item = " + item);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while(!item.equals("end"));

    }
}
public class ProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
