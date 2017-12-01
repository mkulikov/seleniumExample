package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

/**
 * Created by mikhail on 15.11.17.
 */
public class SearchResultsPage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(className = "top")
    WebElement top;

    @FindBy(css = "td[class=top] tr>td:first-child>a")
    List<WebElement> bookLinks;

    public SearchResultsPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30, 500);
        PageFactory.initElements(webDriver, this);
    }

    public void waitForSearchResults() {
        wait.until(ExpectedConditions.visibilityOf(top));
    }

    public void openBookFromResultsBy(String bookTitle) {
        for (WebElement bookLink: bookLinks) {
            if (bookLink.getAttribute("title").contains(bookTitle)) {
                bookLink.click();
                break;
            }
        }
    }

    public String getBookTitle() {
        Random random = new Random();
        int index = random.nextInt(bookLinks.size());
        String bookTitle = bookLinks.get(index).getAttribute("title");
        return bookTitle;
    }

    public void checkBooksSearch() {
        Assert.assertTrue(bookLinks.size()==10);
    }

}
