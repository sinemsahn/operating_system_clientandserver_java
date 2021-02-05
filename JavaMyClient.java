
import java.io.*;  
import java.net.*; 
import java.net.Socket;



public class JavaMyClient {
	public static void main(String[] args) {  
		try {
			//System.out.println("Client Started"); //konsola yazıyor bağlantı için
			Socket soc = new Socket("localhost",9806);
			DataOutputStream dout=new DataOutputStream(soc.getOutputStream());   //mesaj çıktısı yolluyor servera
            dout.writeUTF("Hello Server");  
            dout.flush();  
            dout.close();  
            soc.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
	}
		
}
