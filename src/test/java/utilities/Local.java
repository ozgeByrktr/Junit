package utilities;

import org.junit.Test;

import java.time.LocalTime;

public class Local {
    @Test
    public void test1(){
        // x saniyelik sayac yapalim
        int x=3;
        LocalTime baslangic=LocalTime.now();
        int basSaniye= baslangic.getSecond();
        int saniyeKontrol=123;
        int bitisSaniyesi=basSaniye+x >60 ? basSaniye+x-60 : basSaniye+x ;

        while(bitisSaniyesi!=saniyeKontrol){
            saniyeKontrol=LocalTime.now().getSecond();
        }
        System.out.println("Baslangıç saniyesi: "+basSaniye);
        System.out.println("Saniye Kontrol: "+saniyeKontrol);
    }
}
