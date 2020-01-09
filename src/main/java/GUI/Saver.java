package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Saver {



    public Saver() {
    }

    public BufferedImage createImage(JPanel panel) {
        Point p = new Point(0, 0);
        SwingUtilities.convertPointToScreen(p, panel);
        Rectangle region = panel.getBounds();
        region.x = p.x;
        region.y = p.y;
        BufferedImage bi = null;
        try {
            bi = new Robot().createScreenCapture( region );
        } catch (AWTException ex) {
            ex.printStackTrace();
        }

        return bi;
    }
}
