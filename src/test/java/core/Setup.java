package core;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.EurobankMainPage;

import static dataproviders.Urls.MAIN_PAGE_URL;

public class Setup {

    public static WebDriver driver;
    public static WebDriverWait wait;
    private final int TIME_IN_SECONDS = 10;

    @BeforeSuite
    public void Setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, TIME_IN_SECONDS);
    }

    public EurobankMainPage openEurobankMainPage() {
        driver.get(MAIN_PAGE_URL);
        Assertions.assertThat(driver.getCurrentUrl()).isEqualTo(MAIN_PAGE_URL);
        return new EurobankMainPage();
    }

    @AfterSuite
    public void quit() {
        wait(TIME_IN_SECONDS);
        driver.quit();
    }

    public void wait(int seconds) {
        try {
            seconds = seconds * 1000;
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
