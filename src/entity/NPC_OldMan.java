package entity;

import main.GamePanel;

public class NPC_OldMan extends Entity {

    public NPC_OldMan(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;

        getImage();
    }

    public void getImage() {

        up1 = setUp("/res/npc/oldman_up_1");
        up2 = setUp("/res/npc/oldman_up_2");
        down1 = setUp("/res/npc/oldman_down_1");
        down2 = setUp("/res/npc/oldman_down_2");
        left1 = setUp("/res/npc/oldman_left_1");
        left2 = setUp("/res/npc/oldman_left_2");
        right1 = setUp("/res/npc/oldman_right_1");
        right2 = setUp("/res/npc/oldman_right_2");

    }
}
