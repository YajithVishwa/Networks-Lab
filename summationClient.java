import java.io.*;
import java.util.*;
import java.net.*;
class summationClient{
public static void main(String[ ] args){
try{
InetAddress serverHost = InetAddress.getByName("localhost");
System.out.print("Enter the port address");
Scanner s=new Scanner(System.in);
int serverPort =s.nextInt();
long startTime = System.currentTimeMillis( );
System.out.println("Enter the name");
String name=s.next();
System.out.println("Enter the vehicle id:\n1.Bike\n2.Car\n3.Cycle");
String types=s.next();
System.out.print("Enter the hours");
int gst=s.nextInt();
Socket clientSocket = new Socket(serverHost, serverPort);
PrintStream ps = new PrintStream(clientSocket.getOutputStream());
ps.println(name);
ps.println(String.valueOf(types));
ps.println(String.valueOf(gst));
BufferedReader br = new BufferedReader(new
InputStreamReader(clientSocket.getInputStream()));
String sum = br.readLine();
System.out.println(" sum = "+sum);
long endTime = System.currentTimeMillis();
System.out.println(" Time consumed for receiving the feedback from the server:"+(endTime-startTime)+" milliseconds");
clientSocket.close( );
}
catch(Exception e){e.printStackTrace( );}
}
}