package interviewPrep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class main01 {
    public static void main(String args[]) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "G:\\java_eclipse\\cleartrip-automation\\drivers\\chromedriver.exe");

        WebDriver driver  = new ChromeDriver();

        driver.get("https://admin-demo.nopcommerce.com/login?returnUrl=%2Fadmin%2F");

        driver.get("https://www.google.com/");

        System.out.println(driver.getWindowHandle());

        Set<String> allWindows = driver.getWindowHandles();
        

//        driver.get("https://www.opencart.com/index.php?route=account/register");
//        Thread.sleep(6);
//
//        WebElement element1 = driver.findElement(By.id("input-country"));
//        Select select = new Select(element1);
//        select.selectByVisibleText("India");


//        WebElement element = driver.findElement(By.xpath("//input[@type='email']"));
//        System.out.println(element.getText());
//        System.out.println(element.getAttribute("value"));


//        driver.navigate().back();
//        driver.navigate().forward();
//        driver.navigate().refresh();

//        System.out.println(driver.getPageSource());
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());

        driver.quit();
//        driver.close();
    }
}
