package tests;

import core.Setup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.EurobankMainPage;

public class EurobankMainPageTest extends Setup {

    private EurobankMainPage eurobankMainPage;

    @Test
    private void runTest() {
        eurobankMainPage = openEurobankMainPage();
    }


}
