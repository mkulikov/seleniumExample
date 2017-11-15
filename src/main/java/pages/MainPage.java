package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mikhail on 14.11.17.
 */
public class MainPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(css = "input[value='title']")
    WebElement titleRadioBtn;

    @FindBy(id = "q")
    WebElement searchInputField;

    @FindBy(css = "input[type='submit']")
    WebElement searchButton;


    public MainPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30, 500);

        PageFactory.initElements(webDriver, this);
    }

    public void switchSearchToTitle() {
        titleRadioBtn.click();
    }

    public void enterSearchableText(String text) {
        searchInputField.clear();
        searchInputField.sendKeys(text);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

}
