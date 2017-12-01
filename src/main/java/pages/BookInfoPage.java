package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by mikhail on 15.11.17.
 */
public class BookInfoPage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(css = "h1[itemprop=name]")
    WebElement bookTitle;

    public BookInfoPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30, 500);
        PageFactory.initElements(webDriver, this);
    }

    public void waitForBookInfo() {
        wait.until(ExpectedConditions.visibilityOf(bookTitle));
    }

    public void checkBookTitle(String title) {
        Assert.assertTrue(bookTitle.getText().equals(title));
    }
}
