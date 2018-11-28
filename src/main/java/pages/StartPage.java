package pages;

import helpers.Helper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage {

    private WebDriver driver;

    private By nameField = By.name("name");

    private By phoneField = By.name("phone");

    private By emailField = By.name("email");

    private By cityField = By.name("city");

    private By usernameField = By.xpath("//form[@class='ajaxsubmit']//input[@name='username']");

    private By passwordField = By.xpath("//form[@class='ajaxsubmit']//input[@name='password']");

    private By submitButton = By.xpath("//form[@class='ajaxsubmit']//input[@type='submit']");

    private By widgetLink = By.xpath("//ul[@id='toggleNav']//a[text()='Widget']");

    private By widgetSubmenuMenu = By.xpath("//ul[@id='toggleNav']//a[text()='Menu']");

    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("goToWay2automationMenuPage")
    public Way2automationMenuPage goToWay2automationMenuPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOf(driver.findElement(submitButton)));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(widgetLink)).build().perform();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(widgetSubmenuMenu)));
        driver.findElement(widgetSubmenuMenu).click();
        return new Way2automationMenuPage(driver);
    }

    @Step("registration")
    public StartPage registration(String name, String phone, String email, String city, String userName, String password) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(usernameField).sendKeys(userName);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
        return this;
    }
}
