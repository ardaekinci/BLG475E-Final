package tests.purchase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.common.BasketPage;
import pages.common.CategoryPage;
import pages.common.LoginPage;
import pages.common.MainPage;
import tests.AbstractTest;
import utils.Browser;

import java.util.List;

public class OrderTest extends AbstractTest
{
    private WebElement findBrandByName(String name, List<WebElement> brands){
        for (WebElement brand: brands) {
            if (brand.getText().toLowerCase().contains(name.toLowerCase()))
                return brand;
        }
        return null;
    }

    private void loginWithNumber(Browser browser, String number){
        MainPage mainPage = new MainPage(browser);
        mainPage.loginButton.click();

        LoginPage loginPage = new LoginPage(browser);
        if (number != null)
            browser.waitAndSendKeys(loginPage.phoneNumberInputBar, number);
        loginPage.loginButton.click();
    }

    private void clickButton(Browser browser, WebElement button, int times){
        for (int i = 0; i < times; i++){
            browser.waitAndClick(button);
        }
    }

    @Test
    @DisplayName("Test Order Product")
    public void testOrderProduct() {
        // Load Main Page
        MainPage mainPage = new MainPage(browser);

        // Select Category
        browser.waitAndClick(mainPage.fruitAndVegetablesMenu);
        browser.waitAndClick(mainPage.fruitCategory);

        // Load Category Page
        CategoryPage categoryPage = new CategoryPage(browser);

        // Close If cookie pop-up displayed
        if(categoryPage.cookieDismissButton.isDisplayed())
            browser.waitAndClick(categoryPage.cookieDismissButton);

        // Select SubCategory
        browser.waitAndClick(categoryPage.nutsSubCategory);

        // Search Brand
        browser.waitAndSendKeys(mainPage.brandSearchInput, "Reyondan");

        // Select Brand
        WebElement selectedBrand = findBrandByName("Reyondan", categoryPage.brandList);
        if (selectedBrand == null)
            Assert.fail("Wanted brand not found in the brand list");
        browser.waitAndClick(selectedBrand);

        // Login
        loginWithNumber(browser, context.getInternalProps().getPhoneNumber());

        // Close Announcement
        try {
            if (categoryPage.announcementCloseButton.isDisplayed()){
                browser.waitAndClick(categoryPage.announcementCloseButton);
            }
            if (categoryPage.feedbackCloseButton.isDisplayed()){
                browser.waitAndClick(categoryPage.feedbackCloseButton);
            }
        }catch(Throwable ignored){}

        // Sort Items
        browser.waitAndClick(categoryPage.showSortItemsLink);
        browser.waitAndClick(categoryPage.sortItemsLink);

        // Search Items
        browser.waitAndSendKeys(categoryPage.productSearchBar, "Yer Fıstığı");

        // Add Second Items To Basket
        browser.waitAndClick(categoryPage.addSecondItemToBasket);

        // Add First Items To Basket
        browser.waitAndClick(categoryPage.addFirstItemToBasket);

        // Change Amount of Added Items
        WebElement itemOne = categoryPage.changeAmountButton.get(0);
        WebElement itemTwo = categoryPage.changeAmountButton.get(1);
        clickButton(browser, itemOne, 7);
        clickButton(browser, itemTwo, 4);

        // Remove Second Item
        browser.waitAndClick(categoryPage.cartButton);
        browser.waitAndClick(categoryPage.deleteProductButton);

        // Go To Basket
        browser.waitAndClick(categoryPage.goToBasketButton);

        // Close unnecessary pop-ups
        BasketPage basketPage = new BasketPage(browser);
        try {
            if (basketPage.closeModalButton.isDisplayed()){
                browser.waitAndClick(basketPage.closeModalButton);
            }
        }catch(Throwable ignored){}

        // Select Alternative Option
        Select options = new Select(browser.findElement(By.id("alternativeProductChoice")));
        options.selectByIndex(1);

        // Add Product Note
        browser.waitAndClick(basketPage.productNoteOpenButton);
        browser.waitAndSendKeys(basketPage.productNoteTextBox, "Example Note");

        // Confirm Basket
        browser.waitAndClick(basketPage.confirmBasketButton);

        // Select and Confirm Address
        browser.waitAndClick(basketPage.confirmAddressButton);

        // Select Delivery Time and Delivery Type
        browser.waitAndClick(basketPage.contactlessButton);
        browser.findElements(By.className("iCheck-helper")).get(2).click();
        browser.waitAndClick(basketPage.confirmTimeButton);

        // Select Payment Type
        browser.waitAndClick(basketPage.paymentMethodButton);

        // Check Confirm Order Button Available Or Not
        Assert.assertTrue(basketPage.confirmOrderButton.isDisplayed());

    }
}
