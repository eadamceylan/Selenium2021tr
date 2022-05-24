package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

import java.lang.reflect.AccessibleObject;
import java.util.Set;

public class C03_Actions extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //    1- Yeni bir class olusturalim: MouseActions1
        //    2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //    3- Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement boxElement = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        actions.contextClick(boxElement).perform();
        Thread.sleep(5000);
        //    4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedAlertText = "You selected a context menu";
        String actualAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertText,actualAlertText);
        //    5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //    6- Elemental Selenium linkine tiklayalim
        String valueOfTheFirstPage = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()= 'Elemental Selenium']")).click();
        Set<String> handleSet = driver.getWindowHandles();
        String valueOfTheSecondPage = "";
        for (String each : handleSet) {
            if (!each.equals(valueOfTheFirstPage)){
                valueOfTheSecondPage = each;
            }

        }

        //    7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        driver.switchTo().window(valueOfTheSecondPage);
        WebElement secondTextElement = driver.findElement(By.tagName("h1"));
        String SecondExpectedText = "Elemental Selenium";
        String secondActualText = secondTextElement.getText();
        Assert.assertEquals(SecondExpectedText,secondActualText);
}
}
