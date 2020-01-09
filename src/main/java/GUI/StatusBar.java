package GUI;

import javax.swing.*;
import java.awt.*;

public class StatusBar extends JLabel {

    public StatusBar() {
        super.setPreferredSize(new Dimension(100, 16));
    }

    public void setMessage(String message) {
        setText(" "+message);
    }
}