class NumberTask implements Runnable {
    private String taskName;
    private int start;
    private int end;
    NumberTask(String taskName, int start, int end) {
        this.taskName = taskName;
        this.start = start;
        this.end = end;
    }
    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println(taskName + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(taskName + " interrupted.");
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println(taskName + " completed.");
    }
}
public class MultipleRunnableThreads {
    public static void main(String[] args) throws InterruptedException {
        NumberTask task1 = new NumberTask("Task 1", 1, 5);
        NumberTask task2 = new NumberTask("Task 2", 6, 10);
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        System.out.println("Starting threads...");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("All tasks completed.");
    }
}
