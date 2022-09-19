package tile;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;

    public TileManager(GamePanel gp) {

        this.gp = gp;

        tile = new Tile[99];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/res/maps/mapV1.txt");
    }

    public void getTileImage() {
        //index 0 - 9 are placeholders
        setUp(0, "001", false);
        setUp(1, "002", false);
        setUp(2, "003", false);
        setUp(3, "004", false);
        setUp(4, "005", false);
        setUp(5, "006", false);
        setUp(6, "007", false);
        setUp(7, "008", false);
        setUp(8, "009", false);
        setUp(9, "010", false);

        setUp(10, "011", false);
        setUp(11, "012", true);
        setUp(12, "013", true);
        setUp(13, "014", true);
        setUp(14, "015", false);
        setUp(15, "016", true);
        setUp(16, "017", true);
        setUp(17, "018", true);
        setUp(18, "019", false);
        setUp(19, "020", true);

        setUp(20, "021", true);
        setUp(21, "022", false);
        setUp(22, "023", false);
        setUp(23, "024", false);
        setUp(24, "025", true);
        setUp(25, "026", true);
        setUp(26, "027", true);
        setUp(27, "028", true);
        setUp(28, "029", true);
        setUp(29, "030", true);

        setUp(30, "031", true);
        setUp(31, "033", false);
        setUp(32, "034", true);
        setUp(33, "035", true);
        setUp(34, "036", true);
        setUp(35, "037", true);
        setUp(36, "038", false);
        setUp(37, "039", false);
        setUp(38, "040", false);
        setUp(39, "041", false);

        setUp(40, "042", false);
        setUp(41, "043", false);
        setUp(42, "044", false);
        setUp(43, "045", false);
        setUp(44, "046", false);
        setUp(45, "047", false);
        setUp(46, "048", true);
        setUp(47, "049", true);
        setUp(48, "050", true);
        setUp(49, "051", true);
        setUp(50, "052", true);
        setUp(51, "053", true);
        setUp(52, "054", false);
        setUp(53, "055", false);
        setUp(54, "056", false);
        setUp(55, "057", false);
        setUp(56, "058", false);
        setUp(57, "059", false);
        setUp(58, "060", false);
        setUp(59, "061", true);
        setUp(60, "062", true);
        setUp(61, "063", true);
        setUp(62, "064", true);
        setUp(63, "065", true);
        setUp(64, "066", true);
        setUp(65, "067", true);
        setUp(66, "068", true);
        setUp(67, "069", true);
        setUp(68, "070", false);
        setUp(69, "071", false);
        setUp(70, "072", true);
        setUp(71, "073", true);
        setUp(72, "074", true);
        setUp(73, "075", false);



    }

    public void loadMap(String filePath) {

        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {

                String line = br.readLine();

                while (col < gp.maxWorldCol) {

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {

        }
    }

    public void setUp(int index, String imageName, boolean collision) {

        UtilityTool uTool = new UtilityTool();

        try {

            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/" + imageName + ".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
//        g2.drawImage(tile[0].image, 0 ,0, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[1].image, 48 ,0, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[2].image, 96 ,0, gp.tileSize, gp.tileSize, null);

        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

//            if (worldX > gp.player.worldX - gp.player.screenX &&
//                    worldX < gp.player.worldX + gp.player.screenX &&
//                    worldY > gp.player.worldY - gp.player.screenY &&
//                    worldY < gp.player.worldY + gp.player.screenY) {
//
//                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
//            }


            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                    worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

                g2.drawImage(tile[tileNum].image, screenX, screenY, null);
            }

            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }


    }
}
