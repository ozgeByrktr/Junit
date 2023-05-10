package Day08_TastBaseJsAlertsIframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeClass;

public class C03_BasicAuthentication extends TestBaseBeforeClass {
    //https://username:password@the-internet.herokuapp.com/basic_auth
   /* 1- Bir class olusturun : BasicAuthentication
2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
            3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    Html komutu : https://username:password@URL
    Username    : admin
    password     : admin
4- Basarili sekilde sayfaya girildigini dogrulayin

    */

    @Test
    public void test01(){
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
        //cozum2
        //WebElement congrateYazi=driver.findElement(By.tagName("p"));
        //Assert.assertTrue(congrateYazi.isDisplayed());



    }
}
