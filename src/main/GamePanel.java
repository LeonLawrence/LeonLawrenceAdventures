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

    Thread gameThread;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        // Improves game's rendering performance
        this.setDoubleBuffered(true); // If set to true, all the drawing from this component will be done in an offscreen painting buffer
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

    }
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D)graphics;

        graphics2D.setColor(Color.white);

        graphics2D.fillRect(100, 100, tileSize, tileSize);

        graphics2D.dispose();
    }
}
