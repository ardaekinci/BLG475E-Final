package pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.Browser;

import java.util.List;

public class BasketPage extends AbstractPage
{
    public BasketPage(Browser browser)
    {
        super(browser);
    }

    @FindBy(css = ".modal .modal-header button.close")
    public WebElement closeModalButton;

    @FindBy(css = ".cart-product .product-main .product-main-top .row .product-main-top--amount-row .product-process .open-action")
    public WebElement productNoteOpenButton;

    @FindBy(className = "product_note")
    public WebElement productNoteTextBox;

    @FindBy(id = "in-cart-next-button")
    public WebElement confirmBasketButton;

    @FindBy(css = "#sidebar #cart-info .cart-bottom-area button.button.next-button")
    public WebElement confirmAddressButton;

    @FindBy(css = ".contactless .contactless-input input")
    public WebElement contactlessButton;

    @FindBy(css = ".checkout-payment-container .payment-methods-area .tab ul.card-list li.card-list-item .payment-method-card .in .icon.icon-garanti-pay")
    public WebElement paymentMethodButton;

    @FindBy(css = "#sidebar #cart-info .cart-bottom-area button.button.next-button")
    public WebElement confirmOrderButton;

    @FindBy(css = "#sidebar #cart-info .cart-bottom-area button.button.next-button")
    public WebElement confirmTimeButton;

}
