package practice01review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03Review {
            // ...Exercise3...
            // go to url : https://www.techlistic.com/p/selenium-practice-form.html
            //fill the firstname
            //fill the lastname
            //check the gender
            //check the experience
            //fill the date
            //choose your profession -> Automation Tester
            //choose your tool -> Selenium Webdriver
            //choose your continent -> Antartica
            //choose your command  -> Browser Commands
            //click submit button

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void test(){
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Oguzhan");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Bas");
        driver.findElement(By.xpath("//input[@id='sex-0']")).click();
        driver.findElement(By.xpath("//input[@id='exp-5']")).click();
        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("5/15/2022");
        driver.findElement(By.xpath("//input[@id='profession-1']")).click();
        driver.findElement(By.xpath("//input[@id='tool-2']")).click();
        driver.findElement(By.xpath("//select[@class='input-xlarge'][1]")).sendKeys("Antartica");
        driver.findElement(By.xpath("//select[@id=\"selenium_commands\"]/option[1]")).click();

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
