package main;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    final int originalTileSize = 32; // 32x32 tile
    final int scale = 2;

    public final int tileSize = originalTileSize * scale; // 64x64 tile
    public final int maxScreenCol = 23;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    // WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxScreenCol;
    public final int worldHeight = tileSize * maxScreenRow;

    //FPS SETTINGS
    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this, keyH);

    // OBJECT SETTINGS - Too Many Objects Can Slow Down The Game.
    // OBJECT STORAGE SETTINGS. CAN DISPLAY UP TO 10 OBJECTS AT THE SAME TIME
    public SuperObject obj[] = new SuperObject[10];


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame() {
        aSetter.setObject();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

//    @Override
//    public void run() {
//
//        double drawInterval = 1000000000 / FPS; // 0.01666 seconds
//        double nextDrawTime = System.nanoTime() + drawInterval;
//
//        while (gameThread != null) {
//
//            update();
//
//            repaint();
//
//            try {
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime = remainingTime/1000000;
//
//                if (remainingTime < 0) {
//                    remainingTime = 0;
//                }
//
//                Thread.sleep((long) remainingTime);
//
//                nextDrawTime += drawInterval;
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000d) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // TILE
        tileM.draw(g2);

        // OBJECT
        for (int i = 0; i < obj.length; i++) {
            if(obj[i] != null) {
                obj[i].draw(g2, this);
            }
        }

        // PLAYER
        player.draw(g2);

        g2.dispose();
    }
}
