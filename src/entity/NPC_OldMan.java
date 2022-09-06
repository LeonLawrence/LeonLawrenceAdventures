package entity;

import main.GamePanel;

import java.util.Random;

public class NPC_OldMan extends Entity {

    public NPC_OldMan(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;

        getImage();
        setDialogue();
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

    public void setDialogue() {
        dialogues[0] = "Hello, sir.";
        dialogues[1] = "I'm Tony Le, the wizard.";
        dialogues[2] = "I see that you have no powers. \nCome back to me when you've found the master Sword";
        dialogues[3] = "Fight Monsters and Level up to become stronger.";
        dialogues[4] = "Good luck on your adventure!";
    }

    //Very simple AI?
    public void setAction() {

        actionLockCounter++;

        // NPC FPS
        if (actionLockCounter == 120) {

            Random random = new Random();
            int i = random.nextInt(100) + 1; //pick up a number from 1 to 100

            if (i <= 25) {
                direction = "up";
            }
            if (i >= 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i > 75 && i <= 100) {
                direction = "right";
            }

            actionLockCounter = 0;
        }
    }

    public void speak() {

        // Do this character specific stuff

        super.speak();
    }
}
