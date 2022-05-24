package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test() throws InterruptedException {

        // amazon sayfasina git
        // "account" menusunde "create a list" linkine tikla...

        driver.get("https://amazon.com");
        Actions actions = new Actions(driver);
        WebElement accountLink = driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        actions.moveToElement(accountLink).perform();
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
        Thread.sleep(5000);


    }
}
