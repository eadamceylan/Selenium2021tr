package day10_windowshandle;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilies.TestBase;

public class C01_WindowsHandle extends TestBase {

    @Test
    public void test01() {

    //1- amazon ana sayfaya gidin. Go to "amazon" webpage

    driver.get("https://www.amazon.com");
    //System.out.println(driver.getWindowHandle()); // CDwindow-D703E995ABD18D5B08C865FCD5500744 --> hash code
    String handleValueOfTheFirstPage = driver.getWindowHandle();
    //2- Nutella icin arama yaptirin. Make a search for "Nutella"
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
    //3- ilk urunun resmini tiklayarak farkili bir tab' da acin. In the result page, click the first image ,but opent it inside of new Tab
    driver.switchTo().newWindow(WindowType.TAB);
    driver.get("https://www.amazon.com");
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
    driver.findElement(By.xpath("(//*[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
    //4- yeni tab da acilan urunun basligini yazdirin.
    WebElement elementOfFirstProductTitle = driver.findElement(By.xpath("(//*[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
    System.out.println(elementOfFirstProductTitle.getText());
    //5- Go to first page and print the URL of the first page
    driver.switchTo().window(handleValueOfTheFirstPage);
    System.out.println(driver.getCurrentUrl());


//1- amazon ana sayfaya gidin. Go to "amazon" webpage
        //2- Nutella icin arama yaptirin. Make a search for "Nutella"
        //3- ilk urunun resmini tiklayarak farkili bir tab' da acin. In the result page, click the first image ,but opent it inside of new Tab
        //4- yeni tab da acilan urunun basligini yazdirin.
        //5- Go to first page and print the URL of the first page







    }
}
