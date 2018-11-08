package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.Setup.driver;
import static core.Setup.wait;

public class EurobankDemoMoneyTransferStatusPage {

    @FindBy (xpath = "//*[@class='flash-msg flash-success']")
    private WebElement successStatusForm;

    public EurobankDemoMoneyTransferStatusPage() {
        PageFactory.initElements(driver, this);
    }

    public void showExpectedResult(String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(successStatusForm, text));
    }
}
