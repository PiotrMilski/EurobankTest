package pages;

import org.openqa.selenium.support.PageFactory;

import static core.Setup.driver;

public class EurobankMainPage {

    public EurobankMainPage() {
        PageFactory.initElements(driver, this);
    }
}
