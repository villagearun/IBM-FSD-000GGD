package javanetworking.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
/* SERVER � may enhance to work for multiple clients */
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

import comm.example.model.Employee;
import comm.example.service.EmployeeService;
import comm.example.service.EmployeeServiceImpl;

public class NetworkingServer {
    
    public static void main(String [] args) throws SQLException {
    	EmployeeService service=new EmployeeServiceImpl();
    	
        ServerSocket server = null;
        Socket client;
        
        // Default port number we are going to use
        int portnumber = 1234;
       
       
        // Create Server side socket
        try {
            server = new ServerSocket(portnumber);
        } catch (IOException ie) {
            System.out.println("Cannot open socket." + ie);
            System.exit(1);
        }
        System.out.println("ServerSocket is created " + server);
        
        // Wait for the data from the client and reply
        while(true) {
            
            try {
                
                // Listens for a connection to be made to
                // this socket and accepts it. The method blocks until
                // a connection is made
                System.out.println("Waiting for connect request...");
                client = server.accept();
                
                System.out.println("Connect request is accepted...");
                String clientHost = client.getInetAddress().getHostAddress();
                int clientPort = client.getPort();
                System.out.println("Client host = " + clientHost + " Client port = " + clientPort);
                
                // Read data from the client
                InputStream clientIn = client.getInputStream();
                BufferedReader br = new BufferedReader(new
                        InputStreamReader(clientIn));
                String msgFromClient = br.readLine();
                System.out.println("Message received from client = " + msgFromClient);
                
                // Send response to the client
                if (msgFromClient != null && !msgFromClient.equalsIgnoreCase("bye")) {
                    OutputStream clientOut = client.getOutputStream();
                    PrintWriter pw = new PrintWriter(clientOut, true);
//                    int ansMsg=1;
//                    for(int i=1;i<=Integer.parseInt(msgFromClient);i++)
//                    {
//                    	ansMsg*=i;
//                    }
//                    pw.println(Integer.toString(ansMsg));
                    String ansMsg=msgFromClient;
                    //Array values to pass into the database
                    String[] arg=msgFromClient.split(" ");
                    ansMsg="Welcome "+ansMsg;
                    pw.println(ansMsg);
                    //System.out.println(Integer.parseInt(arg[0])+" "+arg[1]+" "+arg[2]+" "+arg[3]);
                    service.createEmployee(new Employee(Integer.parseInt(arg[0]),arg[1],arg[2],arg[3]));
                    
                }
                
                // Close sockets
                if (msgFromClient != null && msgFromClient.equalsIgnoreCase("bye")) {
                    server.close();
                    client.close();
                    break;
                }
                
            } catch (IOException ie) {
            }
        }
    }

	public ResultSet getallEmployee(String msg) throws SQLException {
		RS2XMLconfig rs2config=new RS2XMLconfig();
		ResultSet rs=rs2config.getEmployeeById(Integer.parseInt(msg));
		return rs;
	}
}
