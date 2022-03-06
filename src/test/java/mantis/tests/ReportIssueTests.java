package mantis.tests;

import mantis.pages.MantisSite;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReportIssueTests extends BaseTest {

    private MantisSite mantisSite;

    @Test
    public void successfulReportIssueTest() throws InterruptedException {
        mantisSite = new MantisSite(driver);

        String login = "admin";
        String password = "admin20";
        String summary = "summary_test";
        String description = "description_test";

        mantisSite.login(login, password);
        mantisSite.reportIssue(summary, description);
        Thread.sleep(2000);

        SoftAssertions softAssert = new SoftAssertions();

        softAssert.assertThat(mantisSite.getViewIssuePage().getSummary().equals(summary));
        softAssert.assertThat(mantisSite.getViewIssuePage().getTableTitle().contains("Viewing Issues"));
        softAssert.assertAll();

        mantisSite.getViewIssuePage().deleteIssue();

        Assertions.assertNotEquals(summary, mantisSite.getViewIssuePage().getSummary());
    }
}
