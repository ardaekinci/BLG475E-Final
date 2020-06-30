package pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.AbstractPage;
import utils.Browser;

import java.util.List;

public class CategoryPage extends AbstractPage
{
    public CategoryPage(Browser browser)
    {
        super(browser);
    }

    @FindBy(className = "cookie-popup-dismiss")
    public WebElement cookieDismissButton;

    @FindBy(css = "a[data-monitor-ga-action='Kabuklu Kuruyemiş']")
    public WebElement nutsSubCategory;

    @FindBy(css = ".sub-category-product-list .list:nth-of-type(1) .product-card-button")
    public WebElement addFirstItemToBasket;

    @FindBy(css = ".sub-category-product-list .list:nth-of-type(2) .product-card-button")
    public WebElement addSecondItemToBasket;

    @FindBy(linkText = "Çok Satanlar")
    public WebElement showSortItemsLink;

    @FindBy(linkText = "Önce En Yüksek Fiyat")
    public WebElement sortItemsLink;

    @FindAll({@FindBy(css = ".product-card-basket-process .product-card-bottom .product-card-bottom--arid .add-product .action .part.product-plus")})
    public List<WebElement> changeAmountButton;

    @FindBy(className = "header-cart")
    public WebElement cartButton;

    @FindBy(className = "delete-product")
    public WebElement deleteProductButton;

    @FindBy(className = "go-to-basket-button")
    public WebElement goToBasketButton;

    @FindBy(id = "product-search")
    public WebElement productSearchBar;

    @FindAll({@FindBy(className = "brands-list-anchor")})
    public List<WebElement> brandList;

    @FindBy(css = "#deliveryFromStoreAnnouncement button")
    public WebElement announcementCloseButton;

    @FindBy(id = "wis-cancel")
    public WebElement feedbackCloseButton;

}
