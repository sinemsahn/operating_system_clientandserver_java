import java.net.*;

import java.io.*;
import java.util.Random;

public class SServer {
     public static void main(String[] args) {
        try{
            ServerSocket sock = new ServerSocket(6013);
            System.out.println("Baglanti Bekleniyor");
            while(true){
                //dinlemeye alıyor kendini
                Random r=new Random(); //random sınıfı
                int randomvalue=r.nextInt(10); //1 den 10 a kadar değer üretir
                //her yeni bağlantı için ayrı bir değer okunacak
                System.out.println("Server random değeri: "+randomvalue );

                Socket client = sock.accept();
                System.out.println("Baglanti Gerceklesti");
                //clientla haberleşmek için
               //String merhaba="Tahmin oyununa hoşgeldiniz.Doğru tahmin için 3 hakkınız var.";
               
                Integer gelensayi;
                int gidenserversayi;
                DataInputStream InFromClient = new DataInputStream(client.getInputStream());
                DataOutputStream OutToClient = new DataOutputStream(client.getOutputStream());
                //than use OutToClient.writeInt() and InFromClient.readInt()
                //sayi = InFromClient.readInt();
                //System.out.println("Clientdan gelen sayımız: " + sayi);
                //böyle yazarsam sadece 1 kere geleni okur
                //OutToClient.writeChars(merhaba);
                int i;
                for(i=0;i<3;i++){
                    gelensayi = InFromClient.readInt();
                    System.out.println("Clientdan gelen sayımız: " + gelensayi);
                    if(gelensayi == randomvalue){
                        //i oradada var değerde var zaten 
                        //göndermem gereken 1 veya 0 
                        // 1 yolla socketleri kapatmak için break ver 
                        //fordan sonra close olacak 
                        gidenserversayi = 1;
                        OutToClient.writeInt(gidenserversayi);
                        break;
                        //işlemler tamamlandığı için
                        

                    }
                    else if(gelensayi < randomvalue){
                        if (i == 2){
                            gidenserversayi = gelensayi;
                            OutToClient.writeInt(gidenserversayi);
                            break;


                        }
                        //1 den büyük yolla
                        gidenserversayi = 2;
                        OutToClient.writeInt(gidenserversayi);

                    }
                    else if (gelensayi > randomvalue){
                        if (i ==2){
                            //bu son hakkı oluyor sayıyı yolla
                            gidenserversayi = gelensayi;
                        OutToClient.writeInt(gidenserversayi);
                        }
                        // 1 den küçük yolla 
                        gidenserversayi = -1;
                        OutToClient.writeInt(gidenserversayi);

                    }
                    else{
                        //hata break ver
                        break;

                    }

                }
                
             //Kapatma işlemine bir bak
               
                sock.close(); 
            }

        }
        catch(IOException ioe){
                System.err.println(ioe);
                
        }
    }
    
}


// if den sonra burada da puanla tut puan sıfır olsa da olmasada değeri yolla 
//clientın orada asil değer olarak al
