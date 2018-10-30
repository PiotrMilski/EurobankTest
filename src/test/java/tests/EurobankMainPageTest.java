package tests;

import core.Setup;
import org.testng.annotations.BeforeClass;
import pages.EurobankMainPage;

public class EurobankMainPageTest extends Setup {

    private EurobankMainPage eurobankMainPage;

    @BeforeClass
    private void runTest() {
        eurobankMainPage = openEurobankMainPage();
    }


}
