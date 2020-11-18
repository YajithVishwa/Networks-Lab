import java.net.*; 
import java.io.*; 

public class Client 
{ 
	// initialize socket and input output streams 
	private Socket socket		 = null; 
	private DataInputStream input = null; 
	private DataOutputStream out	 = null; 
	
	// constructor to put ip address and port 
	public Client(String address, int port) 
	{ 
		// establish a connection 
		try
		{ 
			socket = new Socket(address, port); 
			System.out.println("Connected"); 
			// takes input from terminal 
			input = new DataInputStream(System.in); 
			// sends output to the socket 
			out = new DataOutputStream(socket.getOutputStream()); 
		} 
		catch(UnknownHostException u) 
		{ 
			System.out.println(u); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
			int a,n,money,l;
		// string to read message from input 
		String line = ""; 
	/*	String list[]=new String[]{"1.Electronics","2.Furnitures","3.Garments"};
		int[] gstper=new int[]{20,13,5};
		String name="";
		System.out.println("\nEnter The Name");
		line=input.readLine();
		name=line;
		for(int i=0;i<3;i++)
		{
			System.out.println(list[i]);
		}
		line=input.readLine();
		n=Integer.parseInt(line);
		n-=1;
		System.out.println("\nEnter the amount");
		line=input.readLine();
		money=Integer.parseInt(line);
		// keep reading until "Over" is input 
		
		l=gstper[n-1];*/
		try
			{ 
				
				line=input.readLine();
				out.writeUTF(line); 
			} 
			catch(IOException i) 
			{ 
				System.out.println(i); 
			}
		while (!line.equals("Over")) 
		{ 
			try
			{ 
				
				a=input.readInt();
				out.writeInt(a); 
			} 
			catch(IOException i) 
			{ 
				System.out.println(i); 
			} 
		} 

		// close the connection 
		try
		{ 
			input.close(); 
			out.close(); 
			socket.close(); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
	} 

	public static void main(String args[]) 
	{ 
		Client client = new Client("127.0.0.1", 3000); 
	} 
} 