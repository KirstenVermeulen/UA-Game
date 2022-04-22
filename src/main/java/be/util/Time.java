package be.util;

public class Time {

    private static double drawInterval = 1E9 / 60; // FPS
    private static double nextDrawTime = 0;

    public static void start() {
        nextDrawTime = System.nanoTime() + drawInterval;
    }

    public static void sleep() {
        try {
            double remainingTime = (nextDrawTime - System.nanoTime()) / 1E6; // Milliseconds

            if (remainingTime < 0) {
                remainingTime = 0;
            }

            Thread.sleep((long) remainingTime);

            nextDrawTime += drawInterval;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
