package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewIssuePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#buglist tr:first-child td.column-summary")
    private WebElement summarySell;

    @FindBy(css = "#buglist tr:first-child td.column-id")
    private WebElement issueID;

    @FindBy(css = "div[class='btn-group'] input[value=\"Delete\"]")
    private WebElement deleteButton;

    @FindBy(css = "div input[value=\"Delete Issues\"]")
    private WebElement confirmDeleteButton;

    @FindBy(xpath = "//*[@id=\"bug_action\"]//h4")
    private WebElement tableTitle;

    public ViewIssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }

    public String getSummary() {
        return summarySell.getText();
    }

    public String getTableTitle() {
        System.out.println(tableTitle.getText());
        return tableTitle.getText();
    }

    public void deleteIssue() {
        issueID.click();
        deleteButton.click();
        confirmDeleteButton.click();
    }
}
