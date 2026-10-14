class BankAccount {
    private int balance = 1000;
    synchronized void deposit(int amount) {
        balance = balance + amount;
        System.out.println(
            Thread.currentThread().getName() + " deposited: Rs. " + amount);
        System.out.println("Current balance: Rs. " + balance);
    }
    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println(
                Thread.currentThread().getName() + " withdrew: Rs. " + amount);
            System.out.println("Current balance: Rs. " + balance);
        } else {
            System.out.println(
                Thread.currentThread().getName()+ ": Insufficient balance.");
        }
    }
    synchronized int getBalance() {
        return balance;
    }
}
class DepositThread extends Thread {
    private BankAccount account;
    DepositThread(BankAccount account) {
        this.account = account;
        setName("Deposit Thread");
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
class WithdrawalThread extends Thread {
    private BankAccount account;
    WithdrawalThread(BankAccount account) {
        this.account = account;
        setName("Withdrawal Thread");
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
public class BankTransactionThreads {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();
        System.out.println("Initial balance: Rs. " + account.getBalance());
        DepositThread deposit = new DepositThread(account);
        WithdrawalThread withdrawal = new WithdrawalThread(account);
        deposit.start();
        withdrawal.start();
        deposit.join();
        withdrawal.join();
        System.out.println("Final balance: Rs. " + account.getBalance());
        System.out.println("All transactions completed.");
    }
}
