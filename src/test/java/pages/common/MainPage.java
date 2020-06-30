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

    @FindBy(linkText = "Meyve, Sebze")
    public WebElement fruitAndVegetablesMenu;

    @FindBy(css = "a[data-monitor-ga-action='Meyve']")
    public WebElement fruitCategory;

    @FindBy(id = "brands_search")
    public WebElement brandSearchInput;

    @FindBy(css = ".shoping-cart-icon-block .fa-shopping-cart")
    public WebElement shoppingBasketButton;

    @FindBy(className = "rubbish")
    public WebElement trashButton;
}
