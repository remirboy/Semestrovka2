package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PaintPanel extends JPanel{
    private static int DEFAULT_WIDTH = 955;
    private static int DEFAULT_HEIGHT = 400;
    private int x1, y1, x2, y2;
    private Graphics g;
    private Color pencilColor;
    private Float stroke;

    public Graphics getG() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }

    public Float getStroke() {
        return stroke;
    }

    public void setStroke(Float stroke) {
        this.stroke = stroke;
    }

    public Color getPencilColor() {
        return pencilColor;
    }



    public void setPencilColor(Color pencilColor) {
        this.pencilColor = pencilColor;
    }

    public PaintPanel(Color color) {
        setBackground(color);
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));



        MyMouseHandler handler = new MyMouseHandler();


        this.addMouseListener(handler);
        this.addMouseMotionListener(handler);

    }


    private class MyMouseHandler extends MouseAdapter {



        public void mousePressed(MouseEvent e) {

            x1 = e.getX();
            y1 = e.getY();

            g = getGraphics();

            x2 = x1;
            y2 = y1;
        }

        public void mouseDragged(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY();

            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(pencilColor);
            g2.setStroke(new  BasicStroke(stroke));
            g2.drawLine(x1, y1, x2, y2);

            x2 = x1;
            y2 = y1;
        }
    }
}
