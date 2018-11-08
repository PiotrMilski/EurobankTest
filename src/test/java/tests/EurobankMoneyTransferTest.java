package tests;

import core.Setup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class EurobankMoneyTransferTest extends Setup {

    private EurobankMainPage eurobankMainPage;
    private EurobankLoginPage eurobankLoginPage;
    private EurobankDemoLoginPage eurobankDemoLoginPage;
    private EurobankDemoMoneyTransferFormPage eurobankDemoMoneyTransferFormPage;
    private EurobankDemoMoneyTransferConfirmPage eurobankDemoMoneyTransferConfirmPage;
    private EurobankDemoMoneyTransferStatusPage eurobankDemoMoneyTransferStatusPage;

    private String name = "Anna Kowalska";
    private String accountNumber = "24249000054766627131430703";
    private String title = "Testowy Tytuł Przelewu";
    private double amount = 123.98;

    @BeforeClass
    private void runTest() {
        eurobankMainPage = openEurobankMainPage();
        eurobankLoginPage = eurobankMainPage.goToEurobankLoginPage();
        eurobankDemoLoginPage = eurobankLoginPage.goToEurobankDemoLoginPage();
    }

    @Test
    private void executeTestScenario() {
        shouldTypeId();
        shouldSubmitData();
        shouldTypePassword();
        shouldSubmitData();
        shouldStartMoneyTransfer();
        shouldCompleteMoneyTransferForm();
        shouldConfirmMoneyTransfer();
        shouldCheckResult();
    }

    private void shouldTypeId() {
        eurobankDemoLoginPage.typeInputId("TestedId");
    }

    private void shouldSubmitData() {
        eurobankDemoLoginPage.submitData();
    }

    private void shouldTypePassword() {
        eurobankDemoLoginPage.typeInputPassword("Password");
    }

    private void shouldStartMoneyTransfer() {
        eurobankDemoMoneyTransferFormPage = eurobankDemoLoginPage.goToEurobankDemoMoneyTransferFormPage();
    }

    private void shouldCompleteMoneyTransferForm() {
        eurobankDemoMoneyTransferFormPage.typeReceiverName(name);
        eurobankDemoMoneyTransferFormPage.typeReceiverAccountNumber(accountNumber);
        eurobankDemoMoneyTransferFormPage.typeMoneyAmount(amount);
        eurobankDemoMoneyTransferFormPage.typeTransferTitle(title);
        eurobankDemoMoneyTransferConfirmPage = eurobankDemoMoneyTransferFormPage.goToEurobankMoneyTransferConfirmPage();
    }

    private void shouldConfirmMoneyTransfer() {
        eurobankDemoMoneyTransferStatusPage = eurobankDemoMoneyTransferConfirmPage.goToEurobankDemoMoneyTransferStatusPage();
    }

    private void shouldCheckResult() {
        eurobankDemoMoneyTransferStatusPage.showExpectedResult("Przelew został przyjęty do realizacji.");
    }





}
