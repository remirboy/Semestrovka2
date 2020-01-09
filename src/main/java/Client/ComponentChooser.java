package Client;

import GUI.StatusBar;

import java.io.*;
import java.net.Socket;

public class ComponentChooser {
    private static Socket clientSocket;
    private static BufferedReader in;
    private static BufferedWriter out;


    public void componentTake(String component) throws IOException {
//        try {
//            clientSocket = new Socket("localhost", 80);
//            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
//            out.write("take?component="+component);
//            String serverName = in.readLine();
//            System.out.println(serverName);
//            StatusBar statusBar = new StatusBar();
//            statusBar.setMessage(serverName);
//            out.flush();
//            return statusBar;
//        } catch (IOException e) {
//            System.err.println(e);
//        }
//        finally {
//            clientSocket.close();
//            in.close();
//            out.close();
//        }
//        return null;
    }

}
