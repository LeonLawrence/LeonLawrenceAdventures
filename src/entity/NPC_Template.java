package entity;

import main.GamePanel;
import object.*;

public class NPC_Template extends Entity {

        public NPC_Template(GamePanel gp) {
            super(gp);

            direction = "down";
            speed = 1;

            getImage();
            setDialogue();
            setItems();
        }

        public void getImage() {

//            up1 = setup("/res/npc/merchant_down_1", gp.tileSize, gp.tileSize);
//            up2 = setup("/res/npc/merchant_down_2", gp.tileSize, gp.tileSize);
//            down1 = setup("/res/npc/merchant_down_2", gp.tileSize, gp.tileSize);
//            down2 = setup("/res/npc/merchant_down_2", gp.tileSize, gp.tileSize);
//            left1 = setup("/res/npc/merchant_down_2", gp.tileSize, gp.tileSize);
//            left2 = setup("/res/npc/merchant_down_2", gp.tileSize, gp.tileSize);
//            right1 = setup("/res/npc/merchant_down_1", gp.tileSize, gp.tileSize);
//            right2 = setup("/res/npc/merchant_down_2", gp.tileSize, gp.tileSize);

        }

        public void setDialogue() {
            dialogues[0] = "Welcome.";
            dialogues[1] = "So you found me";
            dialogues[2] = "I have some good stuff.\n";
            dialogues[3] = "Do you want to trade";
        }

        public void setItems() {
            inventory.add(new OBJ_Potion_Red(gp));
            inventory.add(new OBJ_Key(gp));
            inventory.add(new OBJ_Sword_Normal(gp));
            inventory.add(new OBJ_Axe(gp));
            inventory.add(new OBJ_Shield_Wood(gp));
            inventory.add(new OBJ_Shield_Blue(gp));
        }
    }
