package day12_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {

    /*
    1."https://www.amazon.com" adresine gidin

3.Web table tum body’sini yazdirin

5.Tum satirlari yazdirin

7. 5.sutunu yazdirin


     */
    @Test
    public void test01() throws InterruptedException {
       driver.get("https://www.amazon.com");
      //  2.Sayfanin en altina inin

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END);
        //
        WebElement tumBodyElementi= driver.findElement(By.tagName("tbody"));
        Thread.sleep(2000);
        System.out.println(tumBodyElementi.getText());
        //Tum bodyi tek element olarak locate etmek body
        //içinde gecen bir metnin varligini test etmek gibi görevler için kullanılabilir
        List<WebElement>satirElementlerilist=driver.findElements(By.xpath("//tbody/tr"));
       //Web table’daki satir sayisinin 10 oldugunu test edin
        int expectedsize=10;
        int actualsize= satirElementlerilist.size();
        Assert.assertEquals(expectedsize,actualsize);

        for (WebElement eachsatir:satirElementlerilist
             ) {
            System.out.println(eachsatir.getText()+" ");
            System.out.println("=======================");
        }
        List<WebElement>birinciSatirDatalari=driver.findElements(By.xpath("//tbody/tr[1]/td"));

        //6. Web table’daki sutun sayisinin 13 olduğunu test edin

        int expectedSutunsayisi=14;
        int actualSutunsayisi=birinciSatirDatalari.size();
        Assert.assertEquals(expectedSutunsayisi,actualSutunsayisi);


        List<WebElement> besinciSutun=driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for (WebElement eachdata:besinciSutun
             ) {
            System.out.println("-"+eachdata.getText());
            System.out.println("----------------------");
        }


        System.out.println(dataGetir(5, 3));


    }
   //Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun

    private String dataGetir(int satirNo, int sutunNo) {

        String dinamikXpath = "//tbody/tr["+satirNo+"]/td["+sutunNo+"]";
        WebElement istenenDataElementi= driver.findElement(By.xpath(dinamikXpath));
        return istenenDataElementi.getText();
    }


}
