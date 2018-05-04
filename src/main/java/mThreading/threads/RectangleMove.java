package mThreading.threads;

import javafx.scene.shape.Rectangle;

import java.util.Random;

public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private int xStep = 1;
    private int yStep = 1;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
        genNewX();
        genNewY();
        int tmp =1;


    }

    @Override
    public void run() {
        while (true) {
            if ((this.rect.getX() >= 300) || (this.rect.getX() <= 0)) {
                genNewX();
            }
            if ((this.rect.getY() >= 300) || (this.rect.getY() <= 0)) {
                genNewY();
            }
            this.rect.setX(this.rect.getX() + this.xStep);
            this.rect.setY(this.rect.getY() + this.yStep);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private void genNewX() {
        this.xStep = new Random().nextInt(3);
        if (this.rect.getX() >= 300) {
            xStep = xStep - 6;
        }
    }

    private void genNewY() {
        this.yStep = new Random().nextInt(3);
        if (this.rect.getY() >= 300) {
            yStep = yStep - 6;
        }
    }
}