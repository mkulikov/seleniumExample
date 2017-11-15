package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mikhail on 15.11.17.
 */
public class BookInfoPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    public BookInfoPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30, 500);
    }

    public void waitForBookInfo() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1[itemprop=name]")));
    }
}
