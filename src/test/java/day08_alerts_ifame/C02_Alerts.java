package day08_alerts_ifame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {

//    Bir class olusturun: Alerts
//● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
//            ● Bir metod olusturun: acceptAlert
//○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
//“You successfully clicked an alert” oldugunu test edin.

//● Bir metod olusturun: dismissAlert

//○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
//“successfuly” icermedigini test edin.

//● Bir metod olusturun: sendKeysAlert

//○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
//    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void acceptAlert(){
        //○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //“You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        String expectedResult ="You successfully clicked an alert";
        WebElement resultTextElement = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultTest = resultTextElement.getText();
        Assert.assertEquals(expectedResult,actualResultTest);

    }


    @Test
    public void dismissAlert(){
        //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        String unwantedWord = "successfully";
        WebElement resultTextElement = driver.findElement(By.xpath("//*[text()= 'You clicked: Cancel'"));
        String actualResultText = resultTextElement.getText();
        Assert.assertFalse(actualResultText.contains(unwantedWord));
    }
    @Test
    public void sendKeysAlert(){
        //○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Emre Ceylan");
        WebElement resultTextElement = driver.findElement(By.xpath("//p[@id='result'"));
        String resultTextStr = resultTextElement.getText();
        String actualValue = "Emre Ceylan";
        Assert.assertTrue(resultTextStr.contains(actualValue));
    }
}
