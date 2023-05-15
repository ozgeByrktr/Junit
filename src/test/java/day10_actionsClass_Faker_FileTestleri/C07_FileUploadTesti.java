package day10_actionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07_FileUploadTesti extends TestBase {
    @Test
    public void test01(){


     driver.get("https://the-internet.herokuapp.com/upload");
        /*
         https://the-internet.herokuapp.com/upload adresine gidelim
        chooseFile butonunu kullanarak
        projemizdeki deneme.txt dosyasini secelim.
        Upload butonuna basalim.
        "File Uploaded!" textinin goruntulendigini test edelim.
        */
        WebElement dosyaSecButonu= driver.findElement(By.id("file-upload"));
        String dosyaYoluPath="/src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt";
        String ayniolan=System.getProperty("user.dir");
        String dosyaYolu=ayniolan+dosyaYoluPath;
        dosyaSecButonu.sendKeys(dosyaYolu);
        driver.findElement(By.id("file-submit")).click();

        String expectedText="File Uploaded!";
        String actualText=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedText,actualText);

    }




}
