package Day06_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assert {
    //Amazona gidip title'ın amazon içerdigini test edin
    @Test
    public void test01(){
        /*
        JUnit calistirilan test method(ları)ndan kac tanesinin dogru calışıp calışmadıgını gösterir
        kodların içinde test olup olmadıgını bilemez
        Eger Junitin test sonuclarını dogru raporlamasını istiyorsak Assert Classından
        hazır methodlar kullanarak test yapmalıyız

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com");
        String expectedicerik="AMAZON";
        String actualIcerik= driver.getTitle();
        /*
        if (actualIcerik.contains(expectedicerik)) System.out.println("Title testi PASSED");
        else System.out.println("Title testi FAILED");
        System.out.println(actualIcerik);

        */
        Assert.assertTrue(actualIcerik.contains(expectedicerik));
        driver.close();

    }
}
