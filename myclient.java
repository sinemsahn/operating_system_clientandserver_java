import java.net.*;
import java.io.*;
import java.util.Scanner;


public class myclient {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try{
            Socket sock = new Socket("localhost",6013);
            int i;
            
            for(i=0;i<3;i++){
                DataOutputStream ToServer = new DataOutputStream(sock.getOutputStream());
                DataInputStream FromServer = new DataInputStream(sock.getInputStream());
               
                //System.out.println("Client sayinizi giriniz: ");
                int gidensayi = input.nextInt();
                int gelensayi;
                //kullanıcıdan veri alıp atadık
                //servera gönderdik diyelim
               
             
                ToServer.writeInt(gidensayi);
                gelensayi=FromServer.readInt();
               
                if(gelensayi==1){
                    System.out.println("doğru: "+gidensayi);
                    //puan=1;
                    break;
                    //kazanı değerleri yaz break ver fordan sonra closela
                    
                }
                else if(gelensayi==-1){
                    //kaybetti i. şansını yaz  küçülmesi lazım
                    //System.out.println(gidensayi);
                    System.out.println("düşür ");
                }
                else if(gelensayi == 2){
                    //kaybetti şans ve büyümesi lazım
                    //System.out.println("Tahmin yanlış: "+gidensayi);
                    System.out.println("yükselt ");

                }
                else{
                    System.out.println("yanlış-olması gereken rakam " + gelensayi);
                    
                    break;
                }
            }
           
            sock.close();
            //Kapama işlemlerine bak
            
        }
        catch(IOException ioe){
            System.err.println(ioe);
            }
        
    }
    //gelenei al sayiyi 
    
    
}
