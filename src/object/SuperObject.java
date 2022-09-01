package object;

import java.awt.image.BufferedImage;

// Parent class of all object class
public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
}
