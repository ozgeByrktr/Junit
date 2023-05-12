package day10_actionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_DosyaYolunuDinamikYapma {

    @Test
    public void test01(){
        System.out.println(System.getProperty("user.dir"));//C:\Users\MONSTER\com.Team113JUnit
        System.out.println(System.getProperty("user.home"));//C:\Users\MONSTER

        String dosyayoluDegisenKisim=System.getProperty("user.home");
        String dosyaYoluherkesteAyniOlanKisim="/Downloads/foto.png";

        String dosyaYolu= dosyayoluDegisenKisim + dosyaYoluherkesteAyniOlanKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
    @Test
    public void test02(){

     String dosyaYoluDegisenKisim=System.getProperty("user.dir");

     String dosyaYoluherkesteAyniOlanKisim = "/src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt";

     String dosyaYolu = dosyaYoluDegisenKisim + dosyaYoluherkesteAyniOlanKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }



}
