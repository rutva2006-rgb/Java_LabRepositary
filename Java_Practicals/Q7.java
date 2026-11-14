class NumberThread extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

class AlphabetThread extends Thread {
    public void run() {
        for (char ch = 'A'; ch <= 'J'; ch++) {
            System.out.println(Thread.currentThread().getName() + ": " + ch);
        }
    }
}

public class Q7 {
    public static void main(String[] args) {
        NumberThread t1 = new NumberThread();
        AlphabetThread t2 = new AlphabetThread();

        t1.setName("Number Thread");
        t2.setName("Alphabet Thread");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
    }
}
