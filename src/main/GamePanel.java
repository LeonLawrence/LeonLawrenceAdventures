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
    public void run() {
        while (gameThread != null) {
//            System.out.println("The game loop is running");

            // 1 UPDATE: update information such as character positions.
            update();

            // 2 DRAW: draw the screen with the updated information
            repaint(); // calling the paintComponent method
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
