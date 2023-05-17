package day13_ExcelOtomasyonuveScreenshot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.IOException;

public class C04_WebElementScreenShot extends TestBase {

    @Test
    public void test01() throws IOException {


        driver.get("https://www.amazon.com");

        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sonucElementi= driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String actualSonucYazisi=sonucElementi.getText();
        String expectedIcerik="Nutella";
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        ReusableMethods.tumSayfaFotografCek(driver);
        ReusableMethods.webElementFotografCek(driver,sonucElementi);

    }
}
