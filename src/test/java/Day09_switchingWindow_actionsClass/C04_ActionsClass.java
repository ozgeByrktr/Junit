package Day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_ActionsClass extends TestBase {
    @Test
    public void test01(){
       // 1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        Actions actions=new Actions(driver);
        // 2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        WebElement dragMeButton= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHereButton=driver.findElement(By.xpath("//div[@id='droppable'][1]"));
        actions.dragAndDrop(dragMeButton,dropHereButton).perform();

        // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement dropYaziElementi=driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String expectedYazi="Dropped!";
        String actualYazi=dropYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);




    }
}
