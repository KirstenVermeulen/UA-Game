package ua.game;

public class Timer {

    private final double drawInterval;
    private double nextDrawTime;

    /* CONSTRUCTOR */

    public Timer(int fps) {
        this.drawInterval = 1000000000 / fps; // 1 second / wanted number of frames
    }

    /* METHODS */

    public void start() {
        this.nextDrawTime = System.nanoTime() + this.drawInterval;
    }

    public void sleep() {
        try {
            double remainingTime = (this.nextDrawTime - System.nanoTime()) / 1000000; // Milliseconds

            if (remainingTime < 0) {
                remainingTime = 0;
            }

            Thread.sleep((long) remainingTime);

            this.nextDrawTime += this.drawInterval;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
