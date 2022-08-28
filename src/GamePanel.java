import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3; // 16 x 3(scale) = 48

    final int tileSize = originalTileSize * scale; // 48*48 tile
    final int maxScreenWidth = 16;
    final int maxScreenHeight = 12;
    final int screenWidth = tileSize * maxScreenWidth; // 768 pixels = 48 * 16
    final int screenHeight = tileSize * maxScreenHeight; // 576 pixels = 48 * 12

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        // Improves game's rendering performance
        this.setDoubleBuffered(true); // If set to true, all the drawing from this component will be done in an offscreen painting buffer

    }
}
