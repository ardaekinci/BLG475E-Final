package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.common.MainPage;
import utils.Browser;
import utils.TestContext;

public class AbstractTest
{
    protected static TestContext context = new TestContext();
    public static Browser browser;

    @Before
    public void setUp()
    {
        browser = context.doCreateBrowser();
        browser.get("https://www.migros.com.tr");
    }

    @After
    public void tearDown()
    {
        if (null != browser)
            browser.quit();
    }

    public void clearBasket(Browser browser)
    {
        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.shoppingBasketButton);

        while (mainPage.trashButton.isDisplayed())
        {
            browser.waitAndClick(mainPage.trashButton);
        }

        browser.waitAndClick(mainPage.shoppingBasketButton);
    }
}
