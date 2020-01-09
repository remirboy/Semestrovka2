package GUI;

import Client.ClientConnection;
import Client.ClientStart;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainGUI {


    public final static String TITLE = "Swing Form Example";

    private JFrame mainFrame;
    private JPanel mainPanel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JPanel productFormPanel;
    private JPanel productFormFile;
    private JPanel productFormHelp;
    private JPanel productFormInfo;
    private JPanel productFormAbout;
    private JPanel productFormExit;
    private JLabel categoryLabel;
    private JTextField categoryField;
    private JButton redButton;
    private JButton saveButton;
    private JButton printButton;


   public void createGui() throws IOException {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        // Create main frame and set it up
        mainFrame = new JFrame(MainGUI.TITLE);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher((KeyEvent e) -> {
                    if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                        System.exit(0);
                    }
                    return false;
                });

        mainPanel = new JPanel();

        StatusBar statusBar = new StatusBar();
        mainFrame.add(statusBar, java.awt.BorderLayout.SOUTH);
        JScrollPane scrollStatus = new JScrollPane(statusBar,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


       productFormPanel = new JPanel(new GridBagLayout());
        JMenuBar jMenuBar = new JMenuBar();
        JMenu save = new JMenu("Save");
        JMenu back = new JMenu("Background");
        JMenu pencil = new JMenu("Pencil");
        JMenu rubber = new JMenu("Rubber");
        JMenu server = new JMenu("Server");
        JMenu about = new JMenu("About");
        JMenu exit = new JMenu("Exit");
        jMenuBar.add(save);
        jMenuBar.add(back);
        jMenuBar.add(pencil);
        jMenuBar.add(rubber);
        jMenuBar.add(server);
        jMenuBar.add(about);
        PaintPanel paintArea = new PaintPanel(Color.white);
        paintArea.setStroke(1f);

        JMenuItem jMenuItemSave = new JMenuItem();
        jMenuItemSave.setText("save");
        save.add(jMenuItemSave).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Saver s = new Saver();
                BufferedImage image = s.createImage(paintArea);
                File outputfile = new File("MyImage.png");
                try {
                    ImageIO.write(image, "png", outputfile);
                    statusBar.setMessage("saved");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

       JMenuItem jMenuItemServer = new JMenuItem();
       jMenuItemServer.setText("connect");
       server.add(jMenuItemServer).addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e)  {
               ClientConnection clientConnection = new ClientConnection();
               try {
                   statusBar.setMessage(clientConnection.startClient());
               } catch (IOException ex) {
                   ex.printStackTrace();
               }
           }
       });

       JMenuItem jMenuItemRed = new JMenuItem();
       jMenuItemRed.setText("red");
        back.add(jMenuItemRed).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintArea.setBackground(Color.red);
            }
        });

       JMenuItem jMenuItemGreen = new JMenuItem();
       jMenuItemGreen.setText("green");
       back.add(jMenuItemGreen).addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               paintArea.setBackground(Color.green);
           }
       });
       System.out.println(paintArea.getBackground().toString());
       JMenuItem jMenuItemBlue = new JMenuItem();
       jMenuItemBlue.setText("blue");
       back.add(jMenuItemBlue).addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               paintArea.setBackground(Color.blue);
           }
       });

       JMenuItem jMenuItemDefault = new JMenuItem();
       jMenuItemDefault.setText("default");
       back.add(jMenuItemDefault).addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               paintArea.setBackground(Color.white);
           }
       });

       JMenuItem jMenuItemPencil = new JMenuItem();
       jMenuItemPencil.setText("default");
       pencil.add(jMenuItemPencil).addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               paintArea.setPencilColor(Color.black);
               paintArea.setStroke(1f);
           }
       });

       JMenuItem jMenuItemPencilRed = new JMenuItem();
       jMenuItemPencilRed.setText("red");
       pencil.add(jMenuItemPencilRed).addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               paintArea.setPencilColor(Color.red);
               paintArea.setStroke(1f);
           }
       });

       JMenuItem jMenuItemPencilGreen = new JMenuItem();
       jMenuItemPencilGreen.setText("green");
       pencil.add(jMenuItemPencilGreen).addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               paintArea.setPencilColor(Color.green);
               paintArea.setStroke(1f);
           }
       });

       JMenuItem jMenuItemPencilBlue = new JMenuItem();
       jMenuItemPencilBlue.setText("blue");
       pencil.add(jMenuItemPencilBlue).addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               paintArea.setPencilColor(Color.blue);
               paintArea.setStroke(1f);
           }
       });

       JMenuItem jMenuItemRubber = new JMenuItem();
       jMenuItemRubber.setText("finely");
       rubber.add(jMenuItemRubber).addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               paintArea.setPencilColor(paintArea.getBackground());
               paintArea.setStroke(1f);
           }
       });

       JMenuItem jMenuItemRubber2 = new JMenuItem();
       jMenuItemRubber2.setText("normal");
       rubber.add(jMenuItemRubber2).addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               paintArea.setPencilColor(paintArea.getBackground());
               paintArea.setStroke(5f);
           }
       });

       JMenuItem jMenuItemRubber3 = new JMenuItem();
       jMenuItemRubber3.setText("fat");
       rubber.add(jMenuItemRubber3).addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               paintArea.setPencilColor(paintArea.getBackground());
               paintArea.setStroke(10f);
           }
       });






       jMenuBar.add(exit);
        exit.add(new JMenuItem("yes")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainFrame.setJMenuBar(jMenuBar);
        mainFrame.revalidate();

        Container container = mainFrame.getContentPane();

        productFormPanel = new JPanel(new GridBagLayout());
        container.add(paintArea,BorderLayout.WEST);




        container.add((scrollStatus),BorderLayout.SOUTH);

        mainFrame.add(mainPanel);


        mainFrame.setBounds(100, 50, dimension.width/2, dimension.height/2);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);

       ClientConnection clientConnection = new ClientConnection();
       try {
           statusBar.setMessage(clientConnection.startClient());
       } catch (IOException ex) {
           ex.printStackTrace();
       }

    }
}