package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class C05_KeyboardActions extends TestBase {


    @Test
    public void test() throws InterruptedException {
    driver.get("https://www.amazon.com");
    WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

    // once arama kutusuna "click" yap
    // sonra harf harf Nutella yazisini yazdir
    // son olarak ENTER tusuna bas

        Actions actions = new Actions(driver);
        actions.click(searchBox)
                .keyDown(Keys.SHIFT)
                .sendKeys("n")
                .keyUp(Keys.SHIFT)
                .sendKeys("u")
                .sendKeys("t")
                .sendKeys("e")
                .sendKeys("l")
                .sendKeys("l")
                .sendKeys("a")
                .sendKeys(Keys.ENTER).perform();


        Thread.sleep(5000);

    }
}
