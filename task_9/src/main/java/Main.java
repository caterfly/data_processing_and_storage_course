import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int i = 0;
        ArrayList<Thread> threads = new ArrayList<>(5);
        Object[] forks = new Object[5];
        for (i = 0; i < 5; i++) {
            forks[i] = new Object();
        }
        Semaphore sem = new Semaphore(2, true);
        for (i = 0; i < 5; i++) {
            Thread thread = new Thread(new Philosopher(sem, forks, i));
            threads.add(thread);
            threads.get(i).start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            System.out.print(ex.getMessage());
        }
        for(i = 0 ; i < 5;i++){
            threads.get(i).interrupt();
        }

        for(i = 0; i < 5;i++){
            try {
                threads.get(i).join();
            } catch (InterruptedException ex){
                System.out.print(ex.getMessage());
            }
        }


    }
}