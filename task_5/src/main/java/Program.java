import static java.lang.Thread.sleep;

class Program {


    public static void main(String[] args) throws InterruptedException {
        final Output out = new Output();
        final Thread thr = new Thread(out);
        thr.start();
        sleep(2000);
        thr.interrupt();
        System.out.println("Hello, i'm parent thread, and stopped child");
    }
}

class Output implements Runnable {


    public void run() {
        for(;;) {
            if(Thread.interrupted()) {
                System.out.println("This thread was interrupted by someone calling this Thread.interrupt()");
                System.out.println("Cancelling task running in thread " + Thread.currentThread().getName());
                System.out.println("After Thread.interrupted() call, JVM reset the interrupted value to: " + Thread.interrupted());
                break;
            }
            System.out.println("I'm child thread doing smth");
        }
    }
}