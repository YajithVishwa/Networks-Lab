import java.io.*;
import java.net.*;
import java.util.*;
class summationThread extends Thread{
Socket clientSocket;
summationThread(Socket cs){ clientSocket = cs; }
public void run( ){
try{
BufferedReader br = new BufferedReader(new
InputStreamReader(clientSocket.getInputStream( )));
String name=br.readLine();
String i1=br.readLine();
String i2=br.readLine();
int gst=Integer.parseInt(i1);
int total=Integer.parseInt(i2);
float a=(gst*total)/100;
float sum=a+total;
Thread.sleep(200);
PrintStream ps = new PrintStream(clientSocket.getOutputStream( ));
ps.println(sum);
System.out.println("Served : "+name);
ps.flush( );
clientSocket.close( );
}
catch(Exception e){e.printStackTrace( );}
}
}
class summationServer{
public static void main(String[ ] args){
try{
System.out.print("Enter the port address");
Scanner s=new Scanner(System.in);
int serverPort =s.nextInt();
ServerSocket calcServer = new ServerSocket(serverPort);
while (true){
Socket clientSocket = calcServer.accept( );
summationThread thread = new summationThread(clientSocket);
thread.start( );
}
}
catch(Exception e){e.printStackTrace( );}
}
}