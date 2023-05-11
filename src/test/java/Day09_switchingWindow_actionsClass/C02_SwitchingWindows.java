package Day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C02_SwitchingWindows extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        /*
        driver.switchTo().newWindow() kullanarak actigimiz
        window'a driver otomatik olarak gecer

        ANCAKKK...
        biz newWindow() method'unu kullanmadan
        bir link tikladigimizda yeni window aciliyorsa
        driver eski window'da kalir
        Yeni window'a driver'i gecirebilmek icin
        yeni window'un WindowHandleDegerine ihtiyacimiz var
         */
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement openingWindowYaziElementi= driver.findElement(By.tagName("h3"));
        String expectedYazi="Opening a new window";
        String actualYazi=openingWindowYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        String ilkSayfaWHD=driver.getWindowHandle();
        //  ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle= "The Internet";
        String actualTitle=driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
        //  ● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        //40.satır itibari ile yeni window acıldı
        Set<String> whdegerleriSet=driver.getWindowHandles();
        //  ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        System.out.println(driver.getTitle());
         /* Yeni window'a driver'i gecirebilmek icin
            yeni window'un WindowHandleDegerine ihtiyacimiz var
         */
        String ikinciWhd="";
        for (String eachWHD: whdegerleriSet
             ) {
            if(!eachWHD.equals(ilkSayfaWHD)){
                ikinciWhd=eachWHD;
            }
        }
        //  ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        driver.switchTo().window(ikinciWhd);
        System.out.println(driver.getTitle());
        String expectedTitle2= "New Window";
        String actualTitle2=driver.getTitle();
        Assert.assertEquals(expectedTitle2,actualTitle2);

        WebElement yaziElementi= driver.findElement(By.tagName("h3"));
        expectedYazi="New Window";
        actualYazi=yaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        //  ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWHD);
        expectedTitle="The Internet";
        actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }


}
