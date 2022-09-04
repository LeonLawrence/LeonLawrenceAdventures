package main;

import object.OBJ_Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B;
    //    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;


    // delete the two lines below?
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
//        OBJ_Key key = new OBJ_Key(gp);
//        keyImage = key.image;
    }

    public void showMessage(String text) {

        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {

        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.white);

        // PLAY STATE
        if (gp.gameState == gp.playState) {
            // do playState stuff later
        }
        // PAUSE STATE
        if (gp.gameState == gp.pauseState) {
            drawPauseScreen();
        }
        // DIALOGUE STATE
        if (gp.gameState == gp.dialogueState) {
            drawDialogueScreen();
        }


//        if (gameFinished == true) {
//            g2.setFont(arial_40);
//            g2.setColor(Color.white);
//
//            String text;
//            int textLength;
//            int x;
//            int y;
//
//            text = "You found the treasure!";
//            // Returns the length of the text below
//            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
//            x = gp.screenWidth/2 - textLength/2;
//            y = gp.screenHeight/2 - gp.tileSize*3;
//            g2.drawString(text, x, y);
//
//            text = "Your time is: " + dFormat.format(playTime) + "!";
//            // Returns the length of the text below
//            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
//            x = gp.screenWidth/2 - textLength/2;
//            y = gp.screenHeight/2 - gp.tileSize*-1;
//            g2.drawString(text, x, y);
//
//            g2.setFont(arial_80B);
//            g2.setColor(Color.yellow);
//            text = "Congratulations!";
//            // Returns the length of the text below
//            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
//            x = gp.screenWidth/2 - textLength/2;
//            y = gp.screenHeight/2 + gp.tileSize*-1;
//            g2.drawString(text, x, y);
//
//            gp.gameThread = null;
//
//        } else {
//
//            g2.setFont(arial_40);
//            g2.setColor(Color.white);
//            g2.drawImage(keyImage, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null); // 24x24 pixels
//            g2.drawString("x " + gp.player.hasKey, 100, 80);
//
//            // TIME
//            playTime += (double) 1/60;
//            g2.drawString("Time: " + dFormat.format(playTime), gp.tileSize*19, 80);
//
//
//            // MESSAGE
//            if (messageOn == true) {
//                g2.setFont(g2.getFont().deriveFont(30F));
//                g2.drawString(message, gp.tileSize / 2, gp.tileSize * 3);
//
//                messageCounter++;
//
//                if (messageCounter > 120) { // 120 = 60 FPS
//                    messageCounter = 0;
//                    messageOn = false;
//                }
//            }
//        }

    }

    public void drawPauseScreen() {

        g2.setFont(gp.getFont().deriveFont(Font.BOLD, 80F));
        String text = "PAUSED";
        int x;
        int length = (getXForCenteredText(text));
        x = gp.screenWidth / 2 - length / 4;
        int y = gp.screenHeight / 2;

        g2.drawString(text, x, y);
    }

    public void drawDialogueScreen() {
        // WINDOW
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 3;

        drawSubWindow(x, y, width, height);
    }

    public void drawSubWindow(int x, int y, int width, int height) {

        Color c = new Color(0,0,0);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,35,35);
    }

    public int getXForCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        return x;
    }
}
