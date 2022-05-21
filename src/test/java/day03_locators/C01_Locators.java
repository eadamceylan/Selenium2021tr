package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Locators {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Amazon' da Nutella ara...
        driver.get("http://www.amazon.ca");

        // findElement(By....locator)--> istedigimiz web elementini bize dondurur.
        // bizde bir
        // WebElement aramaKutusu = driver.findElement(By.className("nav-search-field"));
        // Eger bir locator ise yaramzsa digerlari kullanilir.
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
          aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

          // By.id is most popular one. Because id is unique inside of the syntax



    }
}
