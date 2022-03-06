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
    private MainPage mainPage;
    private ReportIssuePage reportIssuePage;

    @FindBy(css = "#summary")
    private WebElement summaryField;

    @FindBy(css = "#description")
    private WebElement descriptionField;

    @FindBy(css = "[value='Submit Issue']")
    private WebElement submitIssueButton;

    public ReportIssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }

    public String getReportSummary() {
        return summaryField.getText();
    }

    public String getDescription() {
        return descriptionField.getText();
    }

    public void setSummary(String summary) {
        summaryField.sendKeys(summary);
    }

    public void setDescription(String description) {
        descriptionField.sendKeys(description);
    }

    public void clickSubmitIssue() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitIssueButton);
        submitIssueButton.click();
    }

    public void createReportIssue(String summary, String description) {
        setSummary(summary);
        setDescription(description);
        clickSubmitIssue();
    }

}
