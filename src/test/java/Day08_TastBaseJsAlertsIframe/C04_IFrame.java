package Day08_TastBaseJsAlertsIframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_IFrame extends TestBase {
  /*
            iframe'e gecis yapilinca
            driver'i oradan cikis yaptirana kadar driver iframe'in icinde kalir
            driver.switchTo().parentFrame() : ic ice birden fazla iframe varsa, bir uste cikar
            driver.switchTo().defaultContent() : direk anasayfaya cikar
   */
  //  Bir metod olusturun: iframeTest
    @Test
    public void test01(){
       // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
       // “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement iframeYaziElementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(iframeYaziElementi.isDisplayed());
        System.out.println(iframeYaziElementi.getText());
        //Text Box’a “Merhaba Dunya!” yazin.
        WebElement frameElementi=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElementi);
        WebElement textBoxElementi= driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBoxElementi.clear();

        textBoxElementi.sendKeys("Merhaba Dunya!");
        driver.switchTo().defaultContent();
        // - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        // dogrulayin ve  konsolda yazdirin.
        WebElement elementalLinkText= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalLinkText.isDisplayed());
        System.out.println(elementalLinkText.getText());

    }
}
