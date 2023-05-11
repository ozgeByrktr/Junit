package Day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.time.LocalTime;
import java.util.Set;

public class C03_ActionsClass extends TestBase {


    @Test
    public void test01(){
        /*
        2- https://the-internet.herokuapp.com/context_menu sitesine gidin
3- Cizili alan uzerinde sag click yapin
4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
5- Tamam diyerek alert’i kapatalim
6- Elemental Selenium linkine tiklayalim
7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
         */
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement ciziliAlan=driver.findElement(By.id("hot-spot"));

        Actions actions=new Actions(driver);
        actions.contextClick(ciziliAlan).perform();
        String expectedAlertYazisi="You selected a context menu";
        String actualalertYazisi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualalertYazisi);
        driver.switchTo().alert().accept();

        String ilkWHD= driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();

        //New Window acılıdıgı için ikinciWHD java ile bulmalıyız
        String ikinciWHD="";
        Set<String> windowHDegerleri=driver.getWindowHandles();

        for (String eachWhd:windowHDegerleri) {
            if (!eachWhd.equals(ilkWHD)){
                ikinciWHD=eachWhd;
            }
        }
            driver.switchTo().window(ikinciWHD);
        String expectedYazi="Elemental Selenium";
        String actualYazi=driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(expectedYazi,actualYazi);


    }








}
