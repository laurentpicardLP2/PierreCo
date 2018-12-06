package controller;

public class ParallelBootStarter {
    public static void main(String[] args) {
    	System.out.println("Thread0");
        Thread thread = new Thread(ParallelBootStarter::run);
        thread.setDaemon(true);
        thread.start();
    }

    private static void run() {
        Application.main(new String[] {});
    }
}
