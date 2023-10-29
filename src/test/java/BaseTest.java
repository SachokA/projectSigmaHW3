//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class BaseTest {
//
//    private WebDriver driver ;
//
//    private WebDriverWait wait;
//    final static String BASEURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
//
//    @BeforeEach
////    @BeforeAll
//    public  void setUpBrowser() {
//        ChromeOptions options = new ChromeOptions();
//        options.setImplicitWaitTimeout(Duration.ofMillis(10000));
//        options.addArguments("--disable-notifications");
//        driver.manage().window().maximize();
//        driver.get(BASEURL);
//
//    }
//
//    @AfterEach
////    @AfterAll
//    public  void quit() {
//        driver.manage().deleteAllCookies();
//        driver.quit();
//    }
//
//
//}
//
