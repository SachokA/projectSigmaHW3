
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginTest extends BaseTest {

    final static String userNameInputLocator = "//input[@name='username']";
    final static String userPasswordInputLocator = "//input[@name='password']";
    final static String buttonSubmitLocator = "//button[@type='submit']";
    final  String forgottenPasswordLocator = "//p[contains(@class,'login-forgot')]";
    final String formForgottenPasswordLocator = "//h6[contains(@class,'forgot-password-title')]";
    final String formForgottenPasswordInputUserNameLocator = "//input[@name='username' and @placeholder='Username']";
    final String formForgottenPasswordButtonCancelLocator = "//button[@type='button']";
    final String formForgottenPasswordButtonSubmitLocator = "//button[@type='submit']";
    final static String userName = "Admin";
    final static String userPassword = "admin123";
    final String expectedTitle = "OrangeHRM";
    final String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

    final String expectedURLForgottenPassword = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode";
    final String expectedTitleFormForgottenPassword = "Reset Password";


    @Test
    public void loginTestWithValidDate() {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(userNameInputLocator))).sendKeys(userName);
        driver.findElement(By.xpath(userPasswordInputLocator)).sendKeys(userPassword);
        driver.findElement(By.xpath(buttonSubmitLocator)).click();

        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertEquals(expectedTitle, actualTitle);
        Assertions.assertEquals(expectedURL, actualUrl);

    }

    @Test
    public void validationFormResetPasswordTest() {

        setWaitAndClick(forgottenPasswordLocator);

//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(forgottenPasswordLocator))).click();

        String actualUrlForgottenPassword = driver.getCurrentUrl();

        String actualTitleForm = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath(formForgottenPasswordLocator))).getText();

        Assertions.assertEquals(expectedURLForgottenPassword, actualUrlForgottenPassword);
        Assertions.assertEquals(expectedTitleFormForgottenPassword, actualTitleForm);
        Assertions.assertTrue(driver
                .findElement(By.xpath(formForgottenPasswordInputUserNameLocator))
                .isDisplayed());
        Assertions.assertTrue(driver
                .findElement(By.xpath(formForgottenPasswordButtonCancelLocator))
                .isDisplayed());
        Assertions.assertTrue(driver
                .findElement(By.xpath(formForgottenPasswordButtonSubmitLocator))
                .isDisplayed());
    }

    @Test
    public void changedPasswordTest() {

        setWaitAndClick(forgottenPasswordLocator);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formForgottenPasswordInputUserNameLocator))).sendKeys(userName);
        driver.findElement(By.xpath(formForgottenPasswordButtonSubmitLocator)).click();

        String actualTitleForm = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath(formForgottenPasswordLocator))).getText();

        Assertions.assertEquals("Reset Password link sent successfully",actualTitleForm);

    }


}
