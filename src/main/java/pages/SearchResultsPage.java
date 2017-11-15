package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

/**
 * Created by mikhail on 15.11.17.
 */
public class SearchResultsPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    public SearchResultsPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30, 500);
    }

    public void waitForSearchResults() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("top")));
    }

    public void openBookFromResultsBy(String bookTitle) {
        List<WebElement> books = webDriver.findElement(By.className("top")).findElements(By.tagName("tr"));
        for (WebElement book: books) {
            WebElement bookLink = book.findElement(By.tagName("a"));
            if (bookLink.getAttribute("title").contains(bookTitle)) {
                bookLink.click();
                break;
            }

        }

    }

    public String getBookTitle() {
        List<WebElement> books = webDriver.findElement(By.className("top")).findElements(By.tagName("tr"));
        Random random = new Random();
        int index = random.nextInt(books.size());
        String bookTitle = books.get(index).findElement(By.tagName("a")).getAttribute("title");
        return bookTitle;

    }

}
