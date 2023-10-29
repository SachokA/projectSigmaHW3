import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    static ChromeOptions options = new ChromeOptions();
    static WebDriver driver = new ChromeDriver(options);

    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    final static String BASEURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    //    @BeforeEach
    @BeforeAll
    public static void setUpBrowser() {
        options.setImplicitWaitTimeout(Duration.ofMillis(10000));
        options.addArguments("--disable-notifications");
        driver.get(BASEURL);
        driver.manage().window().maximize();
    }

    //    @AfterEach
    @AfterAll
    public static void quit() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    public void setWaitAndClick(String str) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(str))).click();
    }
}

