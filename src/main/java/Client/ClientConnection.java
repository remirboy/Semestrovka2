package Client;

import GUI.StatusBar;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.Socket;

public class ClientConnection {
    private static Socket clientSocket; //сокет для общения
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public String startClient() throws IOException {
        try {
            clientSocket = new Socket("localhost", 80);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            out.write("start");
            out.flush();
            System.out.println("asfdas");
            String serverName = in.readLine();
            System.out.println(serverName);
            return serverName;
        } catch (IOException e) {
            System.err.println(e);
        }
        finally {
            clientSocket.close();
            in.close();
            out.close();
        }
    return null;
    }



    public String setcomponent(String component) throws IOException {
        try {
            clientSocket = new Socket("localhost", 80);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            out.write("take?component="+component);
            out.flush();
            System.out.println("asfdas");
            String serverName = in.readLine();
            System.out.println(serverName);
            return serverName;
        } catch (IOException e) {
            System.err.println(e);
        }
        finally {
            clientSocket.close();
            in.close();
            out.close();
        }
        return null;
    }

}
