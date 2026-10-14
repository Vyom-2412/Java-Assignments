class NumberThread extends Thread {
    private String threadName;
    private int start;
    private int end;
    NumberThread(String threadName, int start, int end) {
        this.threadName = threadName;
        this.start = start;
        this.end = end;
    }
    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println(threadName + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted.");
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println(threadName + " finished.");
    }
}
public class MultipleThreads {
    public static void main(String[] args) throws InterruptedException {
        NumberThread t1 = new NumberThread("Thread 1", 1, 5);
        NumberThread t2 = new NumberThread("Thread 2", 6, 10);
        NumberThread t3 = new NumberThread("Thread 3", 11, 15);
        System.out.println("Before start: " + t1.getState());
        t1.start();
        t2.start();
        t3.start();
        System.out.println("After start: " + t1.getState());
        t1.join();
        t2.join();
        t3.join();
        System.out.println("After completion: " + t1.getState());
        System.out.println("All threads have completed.");
    }
}
