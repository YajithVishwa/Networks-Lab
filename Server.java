import java.net.*; 
import java.io.*; 

public class Server 
{ 
	//initialize socket and input stream 
	private Socket		 socket = null; 
	private ServerSocket server = null; 
	private DataInputStream in	 = null; 
	public static int gst(int l,int money)
	{
		int gstamount=(money*l)/100;
		return gstamount;
	}
	// constructor with port 
	public Server(int port) 
	{ 
		int a,n,money,l;
		// starts server and waits for a connection 
		try
		{ 
			server = new ServerSocket(port); 
			System.out.println("Server started"); 

			System.out.println("Waiting for a client ..."); 
			socket = server.accept(); 
			System.out.println("Client accepted"); 

			// takes input from the client socket 
			in = new DataInputStream( 
				new BufferedInputStream(socket.getInputStream())); 

			String line = ""; 

			// reads message from client until "Over" is sent 
			while (!line.equals("Over")) 
			{ 
				try
				{ 
		String list[]=new String[]{"1.Electronics","2.Furnitures","3.Garments"};
		int[] gstper=new int[]{20,13,5};
		String name="";
		System.out.println("\nEnter The Name");
		line=in.readLine();
		System.out.println(line);
		name=line;
		for(int i=0;i<3;i++)
		{
			System.out.println(list[i]);
		}
		line=in.readLine();
		n=Integer.parseInt(line);
		n-=1;
		System.out.println("\nEnter the amount");
		line=in.readUTF();
		money=Integer.parseInt(line);
		// keep reading until "Over" is input 
		System.out.print(n);
		
		l=gstper[n+1];
				//line = input.readLine(); 
				if(n==0)
				{
					a=gst(l,money);
					System.out.println(a);
				//	out.writeUTF(String.valueOf(a));
				}
				if(n==1)
				{
					a=gst(l,money);
						System.out.println(a);
				//	out.writeUTF(String.valueOf(a));
				}
				if(n==2)
				{
					a=gst(l,money);
						System.out.println(a);
				//	out.writeUTF(String.valueOf(a));
				}

				} 
				catch(IOException i) 
				{ 
					System.out.println(i); 
				} 
			} 
			System.out.println("Closing connection"); 

			// close connection 
			socket.close(); 
			in.close(); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
	} 

	public static void main(String args[]) 
	{ 
		Server server = new Server(3000); 
	} 
} 