package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.Setup.driver;
import static core.Setup.wait;
import static dataproviders.Urls.DEMO_LOGIN_PAGE_URL;
import static dataproviders.Urls.DEMO_MONEY_TRANSFER_CONFIRM_PAGE_URL;
import static dataproviders.Urls.LOGIN_PAGE_URL;

public class EurobankDemoMoneyTransferFormPage {

    @FindBy (id = "form_receiver")
    private WebElement receiverName;

    @FindBy (id = "form_account_to")
    private WebElement receiverAccountNumber;

    @FindBy (id = "form_amount")
    private WebElement moneyAmount;

    @FindBy (id = "form_title")
    private WebElement transferTitle;

    @FindBy (xpath = "//*[@class='btn red arrow']")
    private WebElement continueMoneyTransfer;

    public EurobankDemoMoneyTransferFormPage () {
        PageFactory.initElements(driver, this);
    }

    public void typeReceiverName(final String text) {
        wait.until(ExpectedConditions.visibilityOf(receiverName));
        receiverName.sendKeys(text);
    }

    public void typeReceiverAccountNumber(final String number) {
        wait.until(ExpectedConditions.visibilityOf(receiverAccountNumber));
        receiverAccountNumber.sendKeys(number);
    }

    public void typeMoneyAmount(final double money) {
        wait.until(ExpectedConditions.visibilityOf(moneyAmount));
        moneyAmount.sendKeys(String.valueOf(money));
    }

    public void typeTransferTitle(final String text) {
        wait.until(ExpectedConditions.visibilityOf(transferTitle)).clear();
        transferTitle.sendKeys(text);
    }

    public EurobankDemoMoneyTransferConfirmPage goToEurobankMoneyTransferConfirmPage() {
        wait.until(ExpectedConditions.elementToBeClickable(continueMoneyTransfer)).click();
        wait.until(driver -> driver.getCurrentUrl().equals(DEMO_MONEY_TRANSFER_CONFIRM_PAGE_URL));
        return new EurobankDemoMoneyTransferConfirmPage();
    }

}
