package object;

import entity.Entity;
import entity.Projectile;
import main.GamePanel;

import java.awt.*;

public class OBJ_Rock extends Projectile {

    GamePanel gp;

    public OBJ_Rock(GamePanel gp) {
        super(gp);
        this.gp = gp;

        name = "Rock";
        // SPEED
        speed = 8;

        // FPS FOR LENGTH
        maxLife = 80;
        life = maxLife;
        attack = 2;
        useCost = 1;
        alive = false;
        getImage();
    }

    public void getImage() {
        up1 = setup("/res/projectile/rock_down_1", gp.tileSize, gp.tileSize);
        up2 = setup("/res/projectile/rock_down_1", gp.tileSize, gp.tileSize);

        down1 = setup("/res/projectile/rock_down_1", gp.tileSize, gp.tileSize);
        down2 = setup("/res/projectile/rock_down_1", gp.tileSize, gp.tileSize);

        left1 = setup("/res/projectile/rock_down_1", gp.tileSize, gp.tileSize);
        left2 = setup("/res/projectile/rock_down_1", gp.tileSize, gp.tileSize);

        right1 = setup("/res/projectile/rock_down_1", gp.tileSize, gp.tileSize);
        right2 = setup("/res/projectile/rock_down_1", gp.tileSize, gp.tileSize);
    }

    public boolean haveResource(Entity user) {
        boolean haveResource = false;
        if (user.ammo >= useCost) {
            haveResource = true;
        }
        return haveResource;
    }

    public void subtractResource(Entity user) {
        user.ammo -= useCost;
    }

    public Color getParticleColor() {
//        Color color = new Color(240, 50, 0); // orange looking colour
        Color color = new Color(40, 50, 0); // brown looking colour
        return color;
    }

    public int getParticleSize() {
        int size = 10;
        return size;
    }

    public int getParticleSpeed() {
        int speed = 1;
        return speed;
    }

    public int getParticleMaxLife() {
        int maxLife = 20;
        return maxLife;
    }
}