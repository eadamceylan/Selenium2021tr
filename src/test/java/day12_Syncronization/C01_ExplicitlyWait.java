package day12_Syncronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilies.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {
//    1. Bir class olusturun : WaitTest
//    2. Iki tane metod olusturun : implicitWait() , explicitWait()
//       Iki metod icin de asagidaki adimlari test edin.

    @Test
    public void implicitlyWaitTest() {
//    3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//    4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
//    5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneTextElement  = driver.findElement(By.xpath("//*[@id='message']"));
        Assert.assertTrue(itsGoneTextElement.isDisplayed());
//    6. Add buttonuna basin
        driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button")).click();
//    7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackTextElement = driver.findElement(By.xpath("//*[@id=\"message\"]"));
        Assert.assertTrue(itsBackTextElement.isDisplayed());
}

    @Test
    public void explicitlyWaitTest() {
//      3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//      4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
//      5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement itsGoneTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(itsGoneTextElement.isDisplayed());
//      6. Add buttonuna basin
        driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button")).click();
//      7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"message\"]")));
        Assert.assertTrue(itsBackTextElement.isDisplayed());



    }
}
