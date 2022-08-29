package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3; // 16 x 3(scale) = 48

    final int tileSize = originalTileSize * scale; // 48*48 tile
    final int maxScreenWidth = 16;
    final int maxScreenHeight = 12;
    final int screenWidth = tileSize * maxScreenWidth; // 768 pixels = 48 * 16
    final int screenHeight = tileSize * maxScreenHeight; // 576 pixels = 48 * 12

    //FPS
    int FPS = 60;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;

    // Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        // Improves game's rendering performance
        this.setDoubleBuffered(true); // If set to true, all the drawing from this component will be done in an offscreen painting buffer
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
//    public void run() {
//
//        double drawInterval = 1000000000 / FPS; // 0.01666 seconds
//        double nextDrawTime = System.nanoTime() + drawInterval;
//
//        while (gameThread != null) {
//
//            // 1 UPDATE: update information such as character positions.
//            update();
//
//            // 2 DRAW: draw the screen with the updated information.
//            repaint(); // calling the paintComponent method
//
//
//            try {
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime = remainingTime / 1000000;
//
//                if (remainingTime < 0) {
//                    remainingTime = 0;
//                }
//
//                Thread.sleep((long) remainingTime);
//
//                nextDrawTime = nextDrawTime + drawInterval;
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
////            System.out.println("The game loop is running");
//
//            // 1,000,000,000 nanoseconds = 1 second
//            // System.nanoTime: returns the current value of the running JVMs high-res time in nanoseconds.
////            long currentTime = System.nanoTime();
////            System.out.println("Current Time: " + currentTime);
//
//            //1,000 milliseconds = 1 second. nanoTime is more accurate than currentTimeMillis method.
////            long currentTime2 = System.currentTimeMillis();
//
//
//        }
//    }

    public void run() {

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime(); // check current time

            delta += (currentTime - lastTime) / drawInterval; // subtract last time by cur
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        // X value increases to the right
        // Y value increases as they go down
        if (keyHandler.upPressed == true) {
            playerY = playerY - playerSpeed;
        } else if (keyHandler.downPressed == true) {
            playerY = playerY + playerSpeed;
        } else if (keyHandler.leftPressed == true) {
            playerX = playerX - playerSpeed;
        } else if (keyHandler.rightPressed == true) {
            playerX = playerX + playerSpeed;
        }
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setColor(Color.white);

        graphics2D.fillRect(playerX, playerY, tileSize, tileSize);

        graphics2D.dispose();
    }
}
