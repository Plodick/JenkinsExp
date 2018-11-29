package helpers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class Helper {

    public static WebElement switchToFrame(WebDriver driver, WebElement frame) {
        driver.switchTo().frame(frame);

        return frame;
    }

    public static WebElement moveToElement(WebDriver driver, WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();

        return webElement;
    }

    public static void dragAndDropElements(WebDriver driver, WebElement draggableElement, WebElement droppableElement) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggableElement, droppableElement).build().perform();
    }

    public static void inputTextInAlert(WebDriver driver,String text){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

    public static String generateString() {
        Random random = new Random();
        String SOURCES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char[] text = new char[6];
        for (int i = 0; i < 6; i++) {
            text[i] = SOURCES.charAt(random.nextInt(SOURCES.length()));
        }

        return new String(text);
    }
}
