package day10_actionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C05_FileDownloadTest extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/download adresine gidelim.
        // foto.png dosyasını indirelim
        // Dosyanın başarıyla indirilip indirilmediğini test edelim
        driver.get("https://the-internet.herokuapp.com/download");

        WebElement potoPNG=driver.findElement(By.linkText("foto.png"));
        Thread.sleep(5000);
        potoPNG.click();
        String dosyaYolu="C:/Users/MONSTER/Downloads/foto.png";

        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));





    }



}
