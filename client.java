import java.net.*;
import java.util.*;
import java.io.*;
 public class client{
	 public static void main(String[] args) {
		 try {
		Socket s= new Socket ("127.0.0.1", 6453);
		System.out.println("server connected");
		
		Scanner in =new Scanner(System.in);
		System.out.println("enter the filename");
		String filename = in.nextLine();
		
		//sending the filename
		DataOutputStream dos= new DataOutputStream(s.getOutputStream());
		dos.writeUTF(filename);
		
		//receiving the file
		DataInputStream dis= new DataInputStream(s.getInputStream());
		String message =(String)dis.readUTF();
		System.out.println("file content:"+message);
		
		FileWriter f1 =new FileWriter("Rec" +filename);
		f1.write(message);
		f1.close();
		s.close();
	}
	 catch(Exception e) {
		 System.out.println(e);
	 }
 }
 } 
 
