import java.net.*;

import java.io.*;
import java.util.Random;

public class myserver {
     public static void main(String[] args) {
        try{
            ServerSocket sock = new ServerSocket(6013);
            //System.out.println("Baglanti Bekleniyor");
            while(true){
                //dinlemeye alıyor kendini
                Random r=new Random(); //random sınıfı
                int randomvalue=r.nextInt(10);
                if (randomvalue == 0){
                    randomvalue=r.nextInt(10);

                } //1 den 10 a kadar değer üretir
                //her yeni bağlantı için ayrı bir değer okunacak
                

                Socket client = sock.accept();
                //System.out.println("Baglanti Gerceklesti");
                //clientla haberleşmek için
               //String merhaba="Tahmin oyununa hoşgeldiniz.Doğru tahmin için 3 hakkınız var.";
               
                Integer gelensayi;
                int gidenserversayi;
                DataInputStream InFromClient = new DataInputStream(client.getInputStream());
                DataOutputStream OutToClient = new DataOutputStream(client.getOutputStream());
                
                int i;
                for(i=0;i<3;i++){
                    gelensayi = InFromClient.readInt();
                    //System.out.println("Server random değeri: "+randomvalue );
                    System.out.println(randomvalue );
                    //System.out.println("Clientdan gelen sayımız: " + gelensayi);
                    System.out.println(  gelensayi);
                    if(gelensayi == randomvalue){
                        //i oradada var değerde var zaten 
                        //göndermem gereken 1 veya 0 
                        // 1 yolla socketleri kapatmak için break ver 
                        //fordan sonra close olacak 
                        gidenserversayi = 1;
                        System.out.println("doğru: "+randomvalue);
                        OutToClient.writeInt(gidenserversayi);
                        break;
                        //işlemler tamamlandığı için
                        

                    }
                    else if(gelensayi < randomvalue){
                        if (i == 2){
                            gidenserversayi = randomvalue;
                            OutToClient.writeInt(gidenserversayi);
                            break;


                        }
                        //1 den büyük yolla
                        gidenserversayi = 2;
                        System.out.println("yükselt ");
                        OutToClient.writeInt(gidenserversayi);

                    }
                    else if (gelensayi > randomvalue){
                        if (i ==2){
                            //bu son hakkı oluyor sayıyı yolla
                            gidenserversayi = randomvalue;
                        OutToClient.writeInt(gidenserversayi);
                        }
                        // 1 den küçük yolla 
                        gidenserversayi = -1;
                        System.out.println("düşür ");
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



//soru her tahminde random düşecek mi
//düşür yazıları gibi serverda mı yazılacak clienta değer gits client o değere göre düşür felan yazsa olmaz mı
