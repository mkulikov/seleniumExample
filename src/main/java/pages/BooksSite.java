package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by mikhail on 15.11.17.
 */
public class BooksSite {
    WebDriver webDriver;

    public BooksSite(WebDriver driver) {
        webDriver = driver;
    }

    public MainPage mainpage() {return new MainPage(webDriver); }

    public SearchResultsPage searchResultsPage() {return new SearchResultsPage(webDriver); }

    public BookInfoPage bookInfoPage() {return new BookInfoPage(webDriver); }

}
