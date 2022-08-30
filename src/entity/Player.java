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

            up1 = ImageIO.read(getClass().getResourceAsStream("../res/player/player_up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("../res/player/player_up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("../res/player/player_down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("../res/player/player_down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("../res/player/player_left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("../res/player/player_left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("../res/player/player_right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("../res/player/player_right2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyHandler.upPressed == true || keyHandler.downPressed == true || keyHandler.leftPressed == true || keyHandler.rightPressed == true) {

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

            spriteCounter++;
            if (spriteCounter > 7) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
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
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
        }

        graphics2D.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);

    }

//    public void draw(Graphics2D graphics2D) {
//        graphics2D.setColor(Color.white);
//        graphics2D.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);
//    }
}
