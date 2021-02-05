
import java.net.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class JavaSocketServer {
	
	
	public static void main(String[] args) {
		try {
			//System.out.println("Waiting for clients...."); //konsola beklediğine dair yazıyor
            ServerSocket ss = new ServerSocket(9806);
            while(true){
                Socket soc = ss.accept();
                //System.out.println("Connected."); //bağlantı tamamalanınca konsola çıktı veriyor
                DataInputStream dis=new DataInputStream(soc.getInputStream());   //clientdan gelen mesajı alıp
                String  str=(String)dis.readUTF();   //clientdan gelen mesajı okuyup
                System.out.println("message= "+str);  //konsola gelen mesajı yazıyor.
                ss.close(); 

            }
			 
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		
	}

}
