package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.Setup.driver;
import static core.Setup.wait;
import static dataproviders.Urls.LOGIN_PAGE_URL;

public class EurobankLoginPage {

    @FindBy (id = "login_id")
    private WebElement loginPageInputId;

    @FindBy (id = "login_next")
    private WebElement loginPageSubmitButton;

    @FindBy (id = "login_password")
    private WebElement loginPageInputPassword;

    @FindBy (id = "login_token")
    private WebElement loginPageInputToken;

    @FindBy (id = "logowanie_alarm_komunikat")
    private WebElement loginPageIncorrectLoginDataMessage;

    @FindBy (id = "zaloguj_ponownie")
    private WebElement loginPageLoginAgainButton;

    public EurobankLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void typeInputId(final String text) {
        wait.until(ExpectedConditions.visibilityOf(loginPageInputId));
        loginPageInputId.sendKeys(text);
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPageSubmitButton)).click();
    }

    public void typeInputPassword(final String text) {
        wait.until(ExpectedConditions.visibilityOf(loginPageInputPassword));
        loginPageInputPassword.sendKeys(text);
    }

    public void typeInputToken(final String text) {
        wait.until(ExpectedConditions.visibilityOf(loginPageInputToken));
        loginPageInputToken.sendKeys(text);
    }

    public void showExpectedResult(String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(loginPageIncorrectLoginDataMessage, text));
        wait.until(ExpectedConditions.visibilityOf(loginPageLoginAgainButton));
    }

}
