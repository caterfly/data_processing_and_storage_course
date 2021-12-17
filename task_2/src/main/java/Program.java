
class Program {
    public static void main(String[] args) {
        Output out = new Output("Hello, i'm daughter thread");
        Thread thr = new Thread(out);
        thr.start();
        try {
            thr.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < 10; ++i) {
            System.out.println("Hello, i'm parent thread");
        }
    }
}

class Output implements Runnable {
    private String toSay;
    public Output(String st) {
        toSay = st;
    }

    public void run() {
        for(int i = 0; i < 10; ++i) {
            System.out.println(toSay);
        }
    }
}
