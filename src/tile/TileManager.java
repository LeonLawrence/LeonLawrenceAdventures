package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gamePanel;
    Tile[] tile;
    int mapTileNumber[][];

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        //update this to increase tile space.
        tile = new Tile[10];
        mapTileNumber = new int[gamePanel.maxScreenWidth][gamePanel.maxScreenHeight];

        getTileImage();
    }

    public void getTileImage() {

        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/wall.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/water.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("../res/maps.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            int row = 0;
            int column = 0;

            while (row < gamePanel.maxScreenHeight && row < gamePanel.maxScreenWidth) {
                String line = bufferedReader.readLine();

                while (row < gamePanel.maxScreenWidth) {
                    String numbers[] = line.split(" ") ;

                    int number = Integer.parseInt(numbers[column]);

                    mapTileNumber[row][column] = number;
                    row++;
                }
                if (row == gamePanel.maxScreenHeight) {
                    row = 0;
                    column++;
                }
            }
            bufferedReader.close();

        }catch (Exception e) {

            }
    }

    public void draw(Graphics2D graphics2D) {

//graphics2D.drawImage(tile[0].image, 0, 0, gamePanel.tileSize, gamePanel.tileSize,null);
//graphics2D.drawImage(tile[1].image, 48, 0, gamePanel.tileSize, gamePanel.tileSize,null);
//graphics2D.drawImage(tile[2].image, 96, 0, gamePanel.tileSize, gamePanel.tileSize,null);

        int column = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (column < gamePanel.maxScreenWidth && row < gamePanel.maxScreenHeight) {
            graphics2D.drawImage(tile[0].image, x, y, gamePanel.tileSize, gamePanel.tileSize,null);
            column++;
            x += gamePanel.tileSize;

            if (column == gamePanel.maxScreenWidth) {
                column = 0;
                x = 0;
                row++;
                y += gamePanel.tileSize;
            }
        }
    }
}
