class BankAccount {
    private int balance = 1000;
    synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName()+ " deposited Rs. " + amount);
        System.out.println("Current balance: Rs. " + balance);
    }
    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew Rs. " + amount);
            System.out.println("Current balance: Rs. " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + ": Insufficient balance.");
        }
    }
    synchronized int getBalance() {
        return balance;
    }
}
class DepositTask implements Runnable {
    private BankAccount account;
    DepositTask(BankAccount account) {
        this.account = account;
    }
    public void run() {
        for (int i = 1; i <= 3; i++) {
            account.deposit(500);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
class WithdrawalTask implements Runnable {
    private BankAccount account;
    WithdrawalTask(BankAccount account) {
        this.account = account;
    }
    public void run() {
        for (int i = 1; i <= 3; i++) {
            account.withdraw(300);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
public class BankTransactionRunnable {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();
        System.out.println("Initial balance: Rs. " + account.getBalance());
        DepositTask depositTask = new DepositTask(account);
        WithdrawalTask withdrawalTask = new WithdrawalTask(account);
        Thread t1 = new Thread(depositTask, "Deposit Thread");
        Thread t2 = new Thread(withdrawalTask, "Withdrawal Thread");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final balance: Rs. " + account.getBalance());
        System.out.println("All transactions completed.");
    }
}
