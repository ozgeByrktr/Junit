package Day08_TastBaseJsAlertsIframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_IFrame extends TestBase {
    // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
    // 2 ) Bir metod olusturun: iframeTest
    // “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
    // - Text Box’a “Merhaba Dunya!” yazin.
    // - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement iframeYaziElementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(iframeYaziElementi.isDisplayed());
        System.out.println(iframeYaziElementi.getText());
        WebElement frameElementi=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElementi);
        WebElement textBoxElementi= driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBoxElementi.clear();
        textBoxElementi.sendKeys("Merhaba Dunya!");
        driver.switchTo().defaultContent();

        WebElement elementalLinkText= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalLinkText.isDisplayed());
        System.out.println(elementalLinkText.getText());

    }
}
