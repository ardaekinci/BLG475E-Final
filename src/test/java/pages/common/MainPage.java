package pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.Browser;

public class MainPage extends AbstractPage
{
    public MainPage(Browser browser)
    {
        super(browser);
    }

    @FindBy(id = "membership-login-link")
    public WebElement loginButton;

    @FindBy(linkText = "Bebek, Oyuncak")
    public WebElement babyToyMenu;

    @FindBy(css = "a[data-monitor-ga-action='Bebek Bezi']")
    public WebElement diaperCategory;

    @FindBy(xpath = "//span[@data-request-param='912']")
    public WebElement diaperCheckBox;

    @FindBy(xpath = "//span[@data-request-param='216']")
    public WebElement diaperSizeFourCheckBox;

    @FindBy(id = "brands_search")
    public WebElement brandSearchInput;

    @FindBy(className = "ui-autocomplete-input")
    public WebElement mainSearchBar;

    @FindBy(className = "ui-menu-item")
    public WebElement searchMenuResult;
}
