import java.net.*;
import java.time.Year;
import java.io.*;

public class DataServer {
     public static void main(String[] args) {
        try{
            ServerSocket sock = new ServerSocket(6013);
            while(true){
                //dinlemeye alıyor kendini
                Socket client = sock.accept();
                PrintWriter pout = new PrintWriter(client.getOutputStream(),true);
                //clientla haberleşmek için
                pout.println(new java.util.Date().toString());
                client.close(); //Tarihi yollayıp kapatıyor clientı kapatıyor ama kendisi duruyor
            }

        }
        catch(IOException ioe){
                System.err.println(ioe);
                
        }
    }
    
}
