package practice01review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Day04_RadioButtonPractice {

//    1- Create a class : RadioButton
//    2- Complete the following task.
//    3- Go to https://www.facebook.com/
//    4- Click on "Create new Account" button
//    5- Locate the elements of radio buttons
//    6- Then click on the one of radio buttons for your gender if they are not selected

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
        driver.get("https://www.facebook.com/");
        driver.findElement(By.linkText("Create new account")).click();
        // Firstname
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Adam");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Gazelle");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("adamgazelle@gmail.com");
        driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("adamgazelle@gmail.com");
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Wertego1234.");

        //MONTH
//        1. Locate the dropdown element
        WebElement monthElement = driver.findElement(By.xpath("//select[@id='month']"));
//        2. Create select object
        Select selectMonth = new Select(monthElement);
//        3. Select Jan
        selectMonth.selectByVisibleText("Jan");

        // DAY
        WebElement dayElement = driver.findElement(By.xpath("//select[@id='day']"));
        Select selectDay = new Select(dayElement);
        selectDay.selectByVisibleText("10");

        // Year
        WebElement yearElement = driver.findElement(By.xpath("//select[@id='year']"));
        Select selectYear = new Select(yearElement);
        selectYear.selectByVisibleText("2022");
        // click "Male" button
        WebElement maleButton = driver.findElement(By.xpath("//input[@value='2']"));
        maleButton.click();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
