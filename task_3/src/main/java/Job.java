class Job implements Runnable {

    static String[] exampleString = {" - 1", " - 2", " - 3", " - 4", " - 5", " - 6", " - 7", " - 8", " - 9", " - 10"};

    private static Thread [] jobs = new Thread[4];

    private int threadID;

    public Job(int ID) {

        threadID = ID;

    }

    public void run() {
        int chunk = exampleString.length / 4;
        for(int i = threadID * chunk; i < (threadID + 1) * chunk; ++i) {

            printString(exampleString[i], threadID);
        }
        int remain = exampleString.length % 4;
       if (remain > 0 && threadID == 3) {
            for(int i = (threadID + 1) * chunk; i < (threadID + 1) * chunk + remain; ++i) {
                printString(exampleString[i], threadID);
            }
        }

    }

    private void printString(String output, int ID) {
        System.out.println(Integer.toString(ID) + output);
    }

    public static void main(String [] args) {

        for(int i=0; i<jobs.length; i++) {

            jobs[i] = new Thread(new Job(i));

            jobs[i].start();

        }

        try {

            for(int i=0; i<jobs.length; i++) {

                jobs[i].join();

            }

        } catch(InterruptedException e) { System.out.println(e); }

    }

}


