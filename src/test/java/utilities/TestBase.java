package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBase {
    /*
    TestBase classı parent edinecek classlarda driver oluşturmamak ve ayarları yeniden yapmamak için kullanıyoruz.
     */
       protected WebDriver driver;
        @Before
    public void setup(){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        @After
    public void tearDown(){

            driver.quit();
        }


















}
