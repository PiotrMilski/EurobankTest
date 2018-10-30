package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.Setup.driver;
import static core.Setup.wait;
import static dataproviders.Urls.LOGIN_PAGE_URL;

public class EurobankMainPage {

    @FindBy (xpath = "//*[span='Zaloguj']")
    private WebElement mainPageLoginButton;

    public EurobankMainPage() {
        PageFactory.initElements(driver, this);
    }

    public EurobankLoginPage goToEurobankLoginPage() {
        wait.until(ExpectedConditions.elementToBeClickable(mainPageLoginButton)).click();
        wait.until(driver -> driver.getCurrentUrl().equals(LOGIN_PAGE_URL));
        return new EurobankLoginPage();
    }
}