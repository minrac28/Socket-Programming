import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	
public static void main(String[] args) {
	try {
		
	ServerSocket s1 = new ServerSocket (6453);
	System.out.println("server starts...");
	Socket s=s1.accept();
	
	//get the file from client 
	DataInputStream dis = new DataInputStream(s.getInputStream());
	String filename = (String)dis.readUTF();
	System.out.println("required file is:" +filename);
	//reading of file 
	FileReader f = new FileReader(filename);
	String message = "";
	int i;
	while(( i=f.read())!=-1){
		message+=(char)i;
	}
	System.out.println("file content:"+message);
	f.close();
	
	//sending the file
	DataOutputStream dos = new DataOutputStream(s.getOutputStream());
	dos.writeUTF(message);
}
	catch(Exception e)
	{
	System.out.println(e);
}
	}
}