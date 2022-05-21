package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WebElementMetodlari {

    /*
    1- amazon.ca'a gidip "arama kutusu" locate edin
    2- arama kutusunun tagName inin "input" oldugunu test edin
    3- arama kutusunun name attribute'nun degerinin "field-keywords" oldugunu test edin

     */

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //  1- amazon.ca'a gidip arama kutusu locate edin

        driver.get("http://www.amazon.ca");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        // 2- arama kutusunun tagName inin "input" oldugunu test edin
        String expectedTagName = "input";
        String actualTagName = aramaKutusu.getTagName();
        if (expectedTagName.equals(actualTagName)){
            System.out.println("TagName is PASSED");
        }else {
            System.out.println("TagName is FAILED");
        }

        String expectedValueName = "field-keywords";
        String actualValueName = aramaKutusu.getAttribute("name");
        if (expectedValueName.equals(actualValueName)){
            System.out.println("name attribute is PASSED");
        }else {
            System.out.println("name attribute is FAILED");
        }

        driver.close();


/*
<input type="text" id="twotabsearchtextbox" value=""
name="field-keywords" autocomplete="off" placeholder=""
class="nav-input nav-progressive-attribute" dir="auto" tabindex="0"
aria-label="Search">
 */



    }
}
