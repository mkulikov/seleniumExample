import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BooksSite;


/**
 * Created by mikhail on 14.11.17.
 */

public class ItBooksTests {
    WebDriver webDriver;
    BooksSite website;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {

        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 30, 500);

        website = new BooksSite(webDriver);

        webDriver.get("http://it-ebooks.info");

        website.mainpage().switchSearchToTitle();
        website.mainpage().enterSearchableText("Automation");
        website.mainpage().clickSearchButton();

        website.searchResultsPage().waitForSearchResults();
    }

    @Test
    public void testBookUrl() {
        Assert.assertTrue(webDriver.getCurrentUrl().contains("search/?q=Automation&type=title"));
    }

    @Test
    public void testBooksSearch() {
        Assert.assertTrue(webDriver.findElement(By.className("top")).findElements(By.tagName("tr")).size()==10);
    }

    @Test
    public void testOpenBookInfoFromSearch() {
        String bookTitle = website.searchResultsPage().getBookTitle();
        website.searchResultsPage().openBookFromResultsBy(bookTitle);
        website.bookInfoPage().waitForBookInfo();
        Assert.assertTrue(webDriver.findElement(By.cssSelector("h1[itemprop=name]")).getText().equals(bookTitle));

    }

    @AfterClass
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}
