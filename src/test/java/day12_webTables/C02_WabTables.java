package day12_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WabTables extends TestBase {

    @Test
    public void test01(){
        /*
          1. “https://demoqa.com/webtables” sayfasina gidin
  2. Headers da bulunan basliklari yazdirin
  3. 3.sutunun basligini yazdirin
  4. Tablodaki tum datalari yazdirin
  5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
  6. Tablodaki satir sayisini yazdirin
  7. Tablodaki sutun sayisini yazdirin
  8. Tablodaki 3.kolonu yazdirin
  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
         */
        driver.get("https://demoqa.com/webtables");

        //  (//div[@role='row'])[3]/div[2]

        driver.findElements(By.xpath("//div[@class='rt-thead -header']"));

        List<WebElement> headers = driver.findElements(By.xpath("//div[@role='columnheader']"));

        for (WebElement eachHeader:headers
             ) {
            System.out.println(eachHeader.getText());
            System.out.println("-----------------------");
        }

        System.out.println("3.SütunBasligi: "+headers.get(3).getText());

        List<WebElement> tabloDatalari=driver.findElements(By.xpath("//div[@role='gridcell']"));
       int bosOlmayanDataSayisi=0;
        for (WebElement eachData:tabloDatalari
             ) {
            if(!eachData.getText().isBlank()) {
                System.out.println(eachData.getText());
                bosOlmayanDataSayisi++;
            }

        }
        //  5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        System.out.println("Tabloda bos olmayan hucre sayisi : " + bosOlmayanDataSayisi);

        List<WebElement> satirlarList=driver.findElements(By.xpath("//div[@role='rowgroup']"));

        System.out.println("Tablodaki satir sayisi : " + satirlarList.size());
        //  7. Tablodaki sutun sayisini yazdirin
        System.out.println("tablodaki sutun sayisi : " + headers.size());
        //  8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutunElementleri = driver.findElements(By.xpath("(//div[@role='row'])/div[3]"));
        System.out.println("======3.sutun=======");
        for (WebElement eachData:ucuncuSutunElementleri
        ) {
            if (!eachData.getText().isBlank()){
                System.out.println(eachData.getText());
            }
        }


        for (int i = 0; i < satirlarList.size(); i++) {
            WebElement isim= driver.findElement(By.xpath(getdinamikXpath(i,1)));

            if (isim.getText().equalsIgnoreCase("Kierra")){
                WebElement salary= driver.findElement(By.xpath(getdinamikXpath(i,5)));
                System.out.println("Kierra'nın maasi: "+salary.getText());
            }
        }
        dataYazdir(2,3);

    }

    private void dataYazdir(int satirNo,int sutunNo) {

        String dinamikXPath="(//div[@role='row'])["+satirNo+"]/div["+sutunNo+"]";
        WebElement istenenElement= driver.findElement(By.xpath(dinamikXPath));
        System.out.println("İstenen hücredeki data"+istenenElement.getText());
    }

    public String getdinamikXpath(int satirNo,int sutunNo){

        return "(//div[@role='row'])["+satirNo+"]/div["+sutunNo+"]";
    }

}
