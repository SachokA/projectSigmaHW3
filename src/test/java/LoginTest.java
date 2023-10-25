
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {


    @Test
    public void loginTest() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement inputName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']")));
        inputName.sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assertions.assertEquals("OrangeHRM",
                driver.getTitle());
        Assertions.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",
                driver.getCurrentUrl());
        driver.quit();

    }
}
