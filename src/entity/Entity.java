package entity;

import java.awt.image.BufferedImage;

// This class will store variables that will be used for player, monster and NPC classes
public class Entity {

    public int x;
    public int y;
    public int speed;

    public BufferedImage up1;
    public BufferedImage up2;
    public BufferedImage down1;
    public BufferedImage down2;
    public BufferedImage left1;
    public BufferedImage left2;
    public BufferedImage right1;
    public BufferedImage right2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;


}
