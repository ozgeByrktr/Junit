package Day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_ActionsClass extends TestBase {

    @Test
    public void test01(){
        /*
        1- https://www.amazon.com/ adresine gidin
    2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
    3- “Create a list” butonuna basin
    4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
         */
        driver.get("https://www.amazon.com/");

        WebElement accounList= driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));

        Actions actions=new Actions(driver);

        actions.moveToElement(accounList).perform();

        WebElement CreateList= driver.findElement(By.xpath("//*[text()='Create a List']"));
        CreateList.click();

        WebElement yourList= driver.findElement(By.xpath("//div[@role='heading']"));
        String expectedYazi="Your Lists";
        String actualYazi=yourList.getText();
        Assert.assertEquals(expectedYazi,actualYazi);






    }


}
