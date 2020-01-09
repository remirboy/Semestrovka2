import GUI.MainGUI;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main extends JFrame {


        public static void main(String[] args) throws IOException {
            MainGUI app = new MainGUI();
            app.createGui();
    }
}
