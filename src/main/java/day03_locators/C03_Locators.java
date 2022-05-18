package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_Locators {
    public static void main(String[] args) {

        /*
         * How many locators are there in selenium?
         * 8
         * What are they?
         * id, name, className, tagName, linkText, partialLinkText, xpath, css
         * What is findElement() method?
         * To locate the elements. Return type is WebElement
         * Which locator do you prefer?
         * I prefer id, cause id is unique, easy to locate, and a little faster that xpath or css
         * If there is no id, then i use other unique elements such as name, class,...
         * If no appropriate locator is there, then I write dynamic xpath
         *
         * */

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://a.testaddressbook.com/sign_in");
        WebElement signInLink = driver.findElement(By.linkText("Sign in"));
        WebElement emailTextBox = driver.findElement(By.id("session_email"));
        WebElement passwordTextBox = driver.findElement(By.name("session[password]"));
        WebElement signInButton = driver.findElement(By.name("commit"));
        emailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTextBox.sendKeys("Test1234!");
        signInButton.click();

        WebElement actualKullaniciAdiElementi = driver.findElement(By.className("navbar-text"));
        System.out.println(actualKullaniciAdiElementi.getText());
        String expectedUserMail = "testtechproed@gmail.com";

        if (expectedUserMail.equals(actualKullaniciAdiElementi.getText())){
            System.out.println("Expected kullanici adi PASSED");
        }else {
            System.out.println("Expected kullanici adi PASSED");
        }


        WebElement adressesElementi = driver.findElement(By.linkText("Addresses"));
        WebElement signOutElementi = driver.findElement(By.linkText("Sign out"));
        if (adressesElementi.isDisplayed()){
            System.out.println("addresses is displayed");
        }else {
            System.out.println("addresses is not displayed");
        }

        // Kac tane link var sayfa da?
        List<WebElement> linklerinListesi = driver.findElements(By.tagName("a"));
        System.out.println(linklerinListesi);
        for (WebElement each :linklerinListesi) {
            System.out.println(each.getText());

        }
        System.out.println(("Sayfadaki linklerin sayisi: " + linklerinListesi.size()));

        driver.close();

    }
}
