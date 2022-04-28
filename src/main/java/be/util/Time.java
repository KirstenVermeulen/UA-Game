package be.util;

public class Time {

    private static double drawInterval = 1E+9 / 60; // Time in nanoseconds / FPS
    private static double nextDrawTime = 0;

    public static void start() {
        nextDrawTime = System.nanoTime() + drawInterval;
    }

    public static void sleep() {
        try {
            double remainingTime = (nextDrawTime - System.nanoTime()) / 1E+6; // Milliseconds

            System.out.println(remainingTime);

            if (remainingTime < 0) {
                remainingTime = 0;
                System.out.println("No time remaining");
            }

            Thread.sleep((long) remainingTime);

            nextDrawTime += drawInterval;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
