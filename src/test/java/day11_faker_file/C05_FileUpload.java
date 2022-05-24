package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

public class C05_FileUpload extends TestBase {

    @Test
    public void test() throws InterruptedException {
    //        1. Tests packagenin altina bir class oluşturun : C05_UploadFile
    //        2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
    //        3. chooseFile butonuna basalim
        WebElement chooseFileButton =  driver.findElement(By.id("file-upload"));

    //        4. Yuklemek istediginiz dosyayi secelim.(Masaustundeki text.txt dosyasini yukleyelim

        String uniqueFilePath = System.getProperty("user.home");
        String commonFilePath = "\\Desktop\\text.txt";
        String downloadFilesPath = uniqueFilePath+commonFilePath;

    // SendKeys ile dosya yolunu, secme butonuna yollayalim.
        chooseFileButton.sendKeys(downloadFilesPath);

        /*
        bu islemi selenium ile yapma imkanimiz yok cunku web tabanli bir uygulama degil
        bu durumda sendKeys() methodu imdaddimiza yetisir
        Eger "chooseFile" butonuna var olan bor dosyanin dosya yolunu yollariz.
        secme islemi
         */
    //        5. Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id=\"file-submit\"]")).click();
    //        6. “File Uploaded!” textinin goruntulendigini test edelim.

        WebElement textElement = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(textElement.isDisplayed());
        Thread.sleep(3000);

    }
}
