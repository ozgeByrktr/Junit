package day14_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSExecuter extends TestBase {
    @Test
    public void test01() throws InterruptedException {

       driver.get("https://www.wisequarter.com/");

        WebElement expolererButonu= driver.findElement(By.xpath("(//a[@class='elementskit-btn whitespace--normal'])[2]"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        //Obje gorunene kadar scroll yap (asagı in)
        jse.executeScript("arguments[0].scrollIntoView();",expolererButonu);
        //JS ile click yap
        jse.executeScript("arguments[0].click();",expolererButonu);

        //JS ile Alert
        jse.executeScript("alert('Bu is bu kadar!')");

        Thread.sleep(2000);




    }
}
