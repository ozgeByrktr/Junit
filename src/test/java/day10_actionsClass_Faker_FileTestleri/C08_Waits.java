package day10_actionsClass_Faker_FileTestleri;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_Waits {

    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
            https://the-internet.herokuapp.com/dynamic_controls adresine gidin
            Remove butonuna basin.
            “It’s gone!” mesajinin goruntulendigini dogrulayin.
            Add buttonuna basin
            It’s back mesajinin gorundugunu test edin
         */


        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeButonu = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeButonu.click();
        WebElement itsGone = driver.findElement(By.xpath("//*[@id='message']"));
        Assert.assertTrue(itsGone.isDisplayed());


    }


}
