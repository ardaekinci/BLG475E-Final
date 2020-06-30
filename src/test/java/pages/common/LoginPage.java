package pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.Browser;

public class LoginPage extends AbstractPage
{
    public LoginPage(Browser browser)
    {
        super(browser);
    }

    @FindBy(className = "title")
    public WebElement loginTitle;

    @FindBy(id = "phoneNumber-error")
    public WebElement phoneNumberError;

    @FindBy(id = "membership-modal-login-button")
    public WebElement loginButton;

    @FindBy(className = "membership-container__phone-login")
    public WebElement phoneNumberInputBar;

    @FindBy(css = ".modal-otp-container .modal-title")
    public WebElement otpModalTitle;

    @FindBy(id = "phoneNumberToVerify")
    public WebElement otpCodeInputBar;

    @FindBy(id = "verifyOtpButton")
    public WebElement verifyOTPButton;

    @FindBy(id = "phoneNumberToVerify-error")
    public WebElement otpCodeError;

    @FindBy(id = "otp-error-message")
    public WebElement otpErrorMessage;

    @FindBy(id = "login-tab")
    public WebElement loginModal;
}
