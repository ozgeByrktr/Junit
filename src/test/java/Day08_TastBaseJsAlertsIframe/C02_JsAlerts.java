package Day08_TastBaseJsAlertsIframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;
import utilities.TestBaseBeforeClass;

public class C02_JsAlerts extends TestBaseBeforeClass {

/*
        Otomasyon yaparken iki tur alert ile karsilasabiliriz
        1- HTML alerts :
           HTML kodlari ile olusturulmus alert'lerdir
           HTML ile olusturuldugu icin inspect edilebilir,
           locate edilebilir ve driver ile kullanilabilir
        2- JavaScript Alerts :
           Inspect yapilamaz, locate edilemez
           Testlerimiz sirasinda JS alert ile karsilasirsak
           driver.switchTo().alert() method'larini kullanarak
           alert'e gecis yapabilir ve alert uzerinde
           OK, Cancel, Alert yazisini alma getText()
           ve alert'e yazi yollama sendKeys()
           method'larini kullanabiliriz.
     */

  /*  3 test method’u olusturup asagidaki gorevi tamamlayin
1. Test
 - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            - 1.alert’e tiklayin
 - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
 - OK tusuna basip alert’i kapatin
2.Test
 - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            - 2.alert’e tiklayalim
 - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
3.Test
 - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            - 3.alert’e tiklayalim
 - Cikan prompt ekranina “Abdullah” yazdiralim
 - OK tusuna basarak alert’i kapatalim
 - Cikan sonuc yazisinin Abdullah icerdigini test edelim

   */
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        String alertYazisi=driver.switchTo().alert().getText();
        String expectedyazi="I am a JS Alert";
        Assert.assertEquals(expectedyazi,alertYazisi);
        driver.switchTo().alert().accept();
    }
    @Test
    public void test02(){
        driver.findElement(By.xpath("(//button[@onclick='jsConfirm()'])")).click();
        driver.switchTo().alert().dismiss();
        String actualYazi=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedsonucYazisi="You clicked: Cancel";
        Assert.assertEquals(expectedsonucYazisi,actualYazi);

    }
    @Test
    public void test03(){
        driver.findElement(By.xpath("(//button[@onclick='jsPrompt()'])")).click();

       // Cikan prompt ekranina “Abdullah” yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");
        // OK tusuna basarak alert’i kapatalim
        driver.switchTo().alert().accept();

        //Cikan sonuc yazisinin Abdullah icerdigini test edelim

        String actualPrompYazi=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedsonucYazi="Abdullah";
        Assert.assertTrue(actualPrompYazi.contains(expectedsonucYazi));
    }
}
