package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    @Test
    public void name() throws InterruptedException {
        //    1. Iki tane metod oluşturun : isExist( ) ve downloadTest( )
        //    2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //    3. dummy.txt dosyasını indirelim
        WebElement linkOfDummy = driver.findElement(By.xpath("//a[text()='dummy.txt']"));
        linkOfDummy.click();
        Thread.sleep(3000);

        //    4. dosyanın başarıyla indirilip indirilmediğini test edelim
        String uniquePath = System.getProperty("user.home");
        String commonPath = "\\Downloads\\Dummy.txt";
        String expectedFilePath = uniquePath+commonPath;

        Assert.assertTrue(Files.exists(Paths.get(expectedFilePath)));



}
}
