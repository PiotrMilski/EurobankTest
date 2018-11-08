package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.Setup.driver;
import static core.Setup.wait;
import static dataproviders.Urls.*;

public class EurobankDemoLoginPage {

    @FindBy (id = "login_id")
    private WebElement demoLoginPageInputId;

    @FindBy (id = "login_next")
    private WebElement demoLoginPageSubmitId;

    @FindBy (id = "login_password")
    private WebElement demoLoginPageInputPassword;

    @FindBy (linkText = "wykonaj przelew")
    private WebElement demoLoginPageStartMoneyTransfer;

    public EurobankDemoLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void typeInputId(final String text) {
        wait.until(ExpectedConditions.visibilityOf(demoLoginPageInputId));
        demoLoginPageInputId.sendKeys(text);
    }

    public void submitData() {
        wait.until(ExpectedConditions.elementToBeClickable(demoLoginPageSubmitId)).click();
    }

    public void typeInputPassword(final String text) {
        wait.until(ExpectedConditions.visibilityOf(demoLoginPageInputPassword));
        demoLoginPageInputPassword.sendKeys(text);
    }

    public EurobankDemoMoneyTransferFormPage goToEurobankDemoMoneyTransferFormPage() {
        wait.until(ExpectedConditions.elementToBeClickable(demoLoginPageStartMoneyTransfer)).click();
        wait.until(driver -> driver.getCurrentUrl().equals(DEMO_MONEY_TRANSFER_FORM_PAGE_URL));
        return new EurobankDemoMoneyTransferFormPage();
    }
}
