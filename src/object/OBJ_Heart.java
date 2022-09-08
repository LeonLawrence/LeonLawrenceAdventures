package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Heart extends Entity {

    public OBJ_Heart(GamePanel gp) {
        super(gp);

        name = "Heart";
        image = setUp("/res/objects/heart_full");
        image2 = setUp("/res/objects/heart_half");
        image3 = setUp("/res/objects/heart_blank");

    }
}
