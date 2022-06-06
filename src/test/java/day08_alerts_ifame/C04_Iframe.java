package day08_alerts_ifame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

public class C04_Iframe extends TestBase {


    @Test
    public void iframeTest() {
        //● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

//   “An IFrame containing....” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement titleElement =  driver.findElement(By.tagName("h3"));
        Assert.assertTrue(titleElement.isEnabled());
//   Text Box’a “Merhaba Dunya!” yazin.
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p")).clear();
        driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p")).sendKeys("Hello world!");
        driver.switchTo().defaultContent();
//
//   TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.

        WebElement elementalSeleniumText = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        String expectedText = "Elemental Selenium";
        String actualText = elementalSeleniumText.getText();
        Assert.assertEquals(expectedText,actualText);












    }
}
