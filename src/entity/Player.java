package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {

        try {


            up1 = ImageIO.read(getClass().getResourceAsStream("../res/player/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("../res/player/up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("../res/player/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("../res/player/down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("../res/player/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("../res/player/left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("../res/player/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("../res/player/right2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        
        if (keyHandler.upPressed == true) {
            direction = "up";
            y -= speed;
        } else if (keyHandler.downPressed == true) {
            direction = "down";
            y += speed;
        } else if (keyHandler.leftPressed == true) {
            direction = "left";
            x -= speed;
        } else if (keyHandler.rightPressed == true) {
            direction = "right";
            x += speed;
        }
    }

    public void draw(Graphics2D graphics2D) {
//        graphics2D.setColor(Color.white);
//        graphics2D.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }

        spriteCounter++;
        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

        graphics2D.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);

    }
}
