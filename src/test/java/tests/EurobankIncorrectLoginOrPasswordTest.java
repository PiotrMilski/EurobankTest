package tests;

import core.Setup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.EurobankLoginPage;
import pages.EurobankMainPage;

public class EurobankIncorrectLoginOrPasswordTest extends Setup {

    private EurobankMainPage eurobankMainPage;
    private EurobankLoginPage eurobankLoginPage;

    @BeforeClass
    private void runTest() {
        eurobankMainPage = openEurobankMainPage();
    }

    @Test
    private void shouldClickMainPageLoginButton() {
        eurobankLoginPage = eurobankMainPage.goToEurobankLoginPage();
    }

    @Test (dependsOnMethods = "shouldClickMainPageLoginButton")
    private void shouldTypeId() {
        eurobankLoginPage.typeInputId("abcdefghij");
    }

    @Test (dependsOnMethods = "shouldTypeId")
    private void shouldSubmitId() {
        eurobankLoginPage.clickSubmit();
    }

    @Test (dependsOnMethods = "shouldSubmitId")
    private void shouldTypePassword() {
        eurobankLoginPage.typeInputPassword("abcd1234");
    }

    @Test (dependsOnMethods = "shouldTypePassword")
    private void shouldTypeToken() {
        eurobankLoginPage.typeInputToken("123456");
    }

    @Test (dependsOnMethods = "shouldTypeToken")
    private void shouldSubmitLoginData() {
        eurobankLoginPage.clickSubmit();
    }

    @Test (dependsOnMethods = "shouldSubmitLoginData")
    private void shouldRefuseConnection() {
        eurobankLoginPage.showExpectedResult("Podano nieprawidłowe dane podczas logowania. Spróbuj ponownie. W razie potrzeby skontaktuj się z Centrum Obsługi Klienta pod nr telefonu 19 000 (koszt połączenia wg taryfy operatora).");
    }



}
