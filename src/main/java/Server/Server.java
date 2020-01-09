package Server;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    private static Socket clientSocket; //сокет для общения
    private static ServerSocket server; // серверсокет
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public void startServer(){
        boolean w = true;
        while (w) {
            try {
                server = new ServerSocket(80);
                clientSocket = server.accept();
                try {
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
//                    String request = in.readLine();
//                    System.out.println("dsadsa");
//                    System.out.println(request);
//                    if (request.substring(0,request.indexOf('?')).equals("take")){
//                        String param= request.substring(request.indexOf('='),request.length()) ;
//                        out.write("You took:"+param);
//                        out.flush();
//                    }
//                    else {
//                        switch (request) {
//                            case "start":
//                                out.write("Hello, you can paint");
//                                out.flush();
//                            case "save":
//                                out.write("Image saved");
//                                out.flush();
//                            case "exit":
//                                out.write("Goodbye!!!");
//                                out.flush();
//                        }
//                    }
                    out.write("Hello, you can paint");
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                    w = false;
                }
                finally {
                    in.close();
                    out.close();
                    clientSocket.close();
                    server.close();
                }

            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}


