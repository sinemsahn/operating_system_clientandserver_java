import java.net.*;
import java.io.*;
import java.util.Scanner;


public class CClinet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try{
            Socket sock = new Socket("localhost",6013);
            int i;
            int puan=0;
            for(i=0;i<3;i++){
                DataOutputStream ToServer = new DataOutputStream(sock.getOutputStream());
                DataInputStream FromServer = new DataInputStream(sock.getInputStream());
               // String merhaba;
               // merhaba = FromServer.readUTF();
               // System.out.println(merhaba);
                System.out.println("Client sayinizi giriniz: ");
                int gidensayi = input.nextInt();
                int gelensayi;
                //kullanıcıdan veri alıp atadık
                //servera gönderdik diyelim
               
                // than use ToServer.writeInt() and FromServer.readInt()
                ToServer.writeInt(gidensayi);
                gelensayi=FromServer.readInt();
                //sock.close();//gönderdikten sonra kapansın
                if(gelensayi==1){
                    System.out.println("Tahmin doğru: "+gidensayi);
                    puan=1;
                    break;
                    //kazanı değerleri yaz break ver fordan sonra closela
                    
                }
                else if(gelensayi==-1){
                    //kaybetti i. şansını yaz  küçülmesi lazım
                    System.out.println("Tahmin yanlış: "+gidensayi);
                    System.out.println("Tahminin küçülmesi lazım.");
                }
                else if(gelensayi == 2){
                    //kaybetti şans ve büyümesi lazım
                    System.out.println("Tahmin yanlış: "+gidensayi);
                    System.out.println("Tahminin büyümesi lazım.");

                }
                else{
                    System.out.println("Sayi:" + gelensayi);
                    
                    break;
                }
            }
            if(puan==0){
                System.out.println("Kaybettiniz...");
            }
            else{
                System.out.println("Kazandınız...");

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
//tarihi alıp yazan clinet serve ryapmış oluyor

//PrintWriter pout = new PrintWriter(client.getOutputStream(),true);
//yazma için pout.println(new java.util.Date().toString());
//veri almak için 

//1. adım client kullanıcıdan değer almalı
//2.adım veriiyi ervera yollasın
//bunu yazdıralım serverda

//okuma için 
//BufferedReader bin = new BufferedReader(new InputStreamReader(in));
//String line;