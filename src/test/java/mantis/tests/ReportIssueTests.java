package mantis.tests;

import mantis.pages.MainPage;
import mantis.pages.MantisSite;
import mantis.pages.ReportIssuePage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReportIssueTests extends BaseTest {

    private MantisSite mantisSite;
    private MainPage mainPage;
    private ReportIssuePage reportIssuePage;

    @Test
    public void successfulReportIssueTest() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        mainPage = new MainPage(driver);
        reportIssuePage = new ReportIssuePage(driver);

        String login = "admin";
        String password = "admin20";
        String summary = "summary_test";
        String description = "description_test";

        mantisSite.login(login, password);
        mainPage.goToReportIssuePage();
        reportIssuePage.createReportIssue(summary, description);

        Thread.sleep(2000);

        SoftAssertions softAssert = new SoftAssertions();

        softAssert.assertThat(mantisSite.getViewIssuePage().getLastCreatedSummary()).isEqualTo(summary);
        softAssert.assertThat(mantisSite.getViewIssuePage().getTableTitle()).contains("Viewing Issues");
        softAssert.assertAll();

        mantisSite.getViewIssuePage().deleteLastCreatedIssue();

        Assertions.assertNotEquals(summary, mantisSite.getViewIssuePage().getLastCreatedSummary());
    }
}
