package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

import static core.Setup.driver;
import static core.Setup.wait;
import static dataproviders.Urls.DEMO_MONEY_TRANSFER_STATUS_PAGE_URL;
import static dataproviders.Urls.LOGIN_PAGE_URL;

public class EurobankDemoMoneyTransferConfirmPage {

    @FindBy(xpath = "//*[@class='btn red arrow']")
    private WebElement confirmMoneyTransfer;

    public EurobankDemoMoneyTransferConfirmPage() {
        PageFactory.initElements(driver, this);
    }

    public EurobankDemoMoneyTransferStatusPage goToEurobankDemoMoneyTransferStatusPage() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmMoneyTransfer)).click();
        wait.until(driver -> driver.getCurrentUrl().equals(DEMO_MONEY_TRANSFER_STATUS_PAGE_URL));
        return new EurobankDemoMoneyTransferStatusPage();
    }
}
