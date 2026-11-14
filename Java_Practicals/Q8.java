class BankAccount {
    int balance = 1000;

    synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName()
                + " deposited: " + amount);
        System.out.println("Current Balance: " + balance);
    }

    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName()
                    + " withdrew: " + amount);
            System.out.println("Current Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}

public class Q8 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> account.deposit(500), "Deposit Thread");
        Thread t2 = new Thread(() -> account.withdraw(300), "Withdraw Thread");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("Final Balance: " + account.balance);
    }
}
