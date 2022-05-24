package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class C04_Actions extends TestBase {

        @Test
        public void dragAndDrop() throws InterruptedException {
            //        Yeni bir class olusturalim: MouseActions2
            //        1- https://demoqa.com/droppable adresine gidelim
            driver.get("https://demoqa.com/droppable");
            //        2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
            Actions actions = new Actions(driver);
            WebElement dragAndDropMeElement = driver.findElement(By.xpath("//div[@id='draggable']"));
            WebElement baseElement = driver.findElement(By.xpath("//div[@id='droppable'][1]"));
            actions.dragAndDrop(dragAndDropMeElement,baseElement).perform();
            Thread.sleep(10000);
            //        3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
            String expectedText = "Dropped!";
            WebElement actualTextElement = driver.findElement(By.xpath("//*[text()='Dropped!']"));
            String actualText= actualTextElement.getText();
            Assert.assertEquals(expectedText,actualText);
            Thread.sleep(3000);


        }
    }


