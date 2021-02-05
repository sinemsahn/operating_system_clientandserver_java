import java.net.*;
import java.io.*;

public class DateClient {
    public static void main(String[] args) {
        try{
            Socket sock = new Socket("localhost",6013);
            InputStream in =sock.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));
            String line;
            while((line = bin.readLine())!= null)
                System.out.println(line);
            sock.close();
            //boş gelene kadar okuma yapar
        }
        catch(IOException ioe){
            System.err.println(ioe);
            }
        
    }
    
    
}
//tarihi alıp yazan clinet serve ryapmış oluyor

