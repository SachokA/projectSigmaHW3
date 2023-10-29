import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UpdatingFormInfoTest extends BaseTest {

    final String myInfoLocator = "//span[text()='My Info']";

    final String contactDetailsLocator = "//a[text()='Contact Details']";
    final String street1Locator = "//label[.='Street 1']/../following-sibling::div/input";
    final String street2Locator = "//label[.='Street 2']/../following-sibling::div/input";
    final String cityLocator = "//label[.='City']/../following-sibling::div/input";
    final String stateLocator = "//label[.='State/Province']/../following-sibling::div/input";
    final String countryLocator = "//label[.='Country']/../following-sibling::div/div";

    final String homeTelephoneLocator = "//label[.='Home']/../following-sibling::div/input";
    final String buttonSaveLocator = "//button[@type='submit' and normalize-space(text()='Save')]";

    final String street1 = "street1";
    final String street2 = "street2";
    final String city = "city";
    final String state = "state";

    final String homeNumberTelephone = "123456789";
    Actions actions = new Actions(driver);

    public void cleanField(WebElement element) {
        actions.click(element).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();
    }

    public void sendText(WebElement element, String value) {
        actions.sendKeys(element, value).build().perform();
    }


    @Test
    public void updatingTestWithValidDate() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LoginTest.userNameInputLocator))).sendKeys(LoginTest.userName);

        driver.findElement(By.xpath(LoginTest.userPasswordInputLocator)).sendKeys(LoginTest.userPassword);
        driver.findElement(By.xpath(LoginTest.buttonSubmitLocator)).click();

        setWaitAndClick(myInfoLocator);
        setWaitAndClick(contactDetailsLocator);

        Thread.sleep(3000);

        WebElement street1Element = driver.findElement(By.xpath(street1Locator));

        cleanField(street1Element);
        sendText(street1Element, street1);

        WebElement street2Element = driver.findElement(By.xpath(street2Locator));

        cleanField(street2Element);
        sendText(street2Element, street2);

        WebElement stateElement = driver.findElement(By.xpath(stateLocator));

        cleanField(stateElement);
        sendText(stateElement, state);

        WebElement cityElement = driver.findElement(By.xpath(cityLocator));

        cleanField(cityElement);
        sendText(cityElement, city);

        WebElement countryDropDown = driver.findElement(By.xpath(countryLocator));

        actions.click(countryDropDown).build().perform();
        actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();

        WebElement numberElement = driver.findElement(By.xpath(homeTelephoneLocator));

        cleanField(numberElement);
        sendText(numberElement, homeNumberTelephone);

        driver.findElement(By.xpath(buttonSaveLocator)).click();

        driver.navigate().refresh();

        Thread.sleep(3000);

        Assertions.assertEquals(street1, driver.findElement(By.xpath(street1Locator)).getText());
        Assertions.assertEquals(street2, driver.findElement(By.xpath(street2Locator)).getText());
        Assertions.assertEquals(state, driver.findElement(By.xpath(stateLocator)).getText());
        Assertions.assertEquals(city, driver.findElement(By.xpath(cityLocator)).getText());
        Assertions.assertEquals("city", driver.findElement(By.xpath(countryLocator)).getText());
        Assertions.assertEquals(homeNumberTelephone, driver.findElement(By.xpath(homeTelephoneLocator)).getText());
    }
}
