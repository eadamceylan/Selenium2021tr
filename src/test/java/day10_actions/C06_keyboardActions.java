package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class C06_keyboardActions extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        //Facebook ana sayfaya git
        driver.get("https://www.facebook.com");
        //yeni "Yeni hesap olustur" butonuna bas
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //isim kutusunu "locate" et
        WebElement firstNameBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        //geriye kalan alanlari TAB ile dolarak formu doldur
        Actions actions = new Actions(driver);
        actions.sendKeys("Adam").sendKeys(Keys.TAB).
                sendKeys("Gazelle").sendKeys(Keys.TAB).
                sendKeys("adamgazelle@gmail.com").sendKeys(Keys.TAB).
                sendKeys("adamgazelle@gmail.com").sendKeys(Keys.TAB).
                sendKeys("Abc1234.").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("23").sendKeys(Keys.TAB).
                sendKeys("May").sendKeys(Keys.TAB).
                sendKeys("2002").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

        Thread.sleep(5000);

    }
}
