package mantis.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportIssuePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#summary")
    private WebElement summaryFild;

    @FindBy(css = "#description")
    private WebElement descriptionFild;

    @FindBy(css = "[value=\"Submit Issue\"]")
    private WebElement submitIssueButton;

    public ReportIssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }

    public String getReportSummary() {
        return summaryFild.getText();
    }

    public String getDescription() {
        return descriptionFild.getText();
    }

    public void summary(String summary) {
        summaryFild.sendKeys(summary);
    }

    public void description(String description) {
        descriptionFild.sendKeys(description);
    }

    public void submitIssueClick() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitIssueButton);
        submitIssueButton.click();
    }
}
