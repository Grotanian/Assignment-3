package myprojects.automation.assignment3;

import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;
    private By emailInput = By.id("email");
    private By passwordInput = By.id("passwd");
    private By loginBtn = By.name("submitLogin");
    private By refreshIcon = By.xpath("//*[@id='ajax_running']/i");
    private By categoryTab = By.xpath("//*[@id='subtab-AdminCategories']/a");
    private By addCategory = By.cssSelector("#page-header-desc-category-new_category");
    private By categoryNameField = By.cssSelector("#name_1");
    private By saveButton = By.xpath("//*[@id='category_form_submit_btn']");
    private By creationMessage = By.xpath("//*[@id='content']/div[3]/div");
    private By searchNameField = By.xpath("//*[@id='table-category']/thead/tr[2]/th[3]/input");
    private By searchButton = By.cssSelector("#submitFilterButtoncategory");


    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * Logs in to Admin Panel.
     * @param login
     * @param password
     */
    public void login(String login, String password) {
        // TODO implement logging in to Admin Panel
        driver.get(Properties.getBaseAdminUrl());
        driver.findElement(emailInput).sendKeys(login);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginBtn).click();

    }

    /**
     * Navigate to category tab in Admin Panel.

     */
    public void NavigateToCategoryTabWithJS() {
        // TODO implement logic for category tab navigation using JavaScript Executor
        WebElement element = driver.findElement(categoryTab);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
        waitForContentLoad();

    }

     /**
     * Adds new category in Admin Panel.
     * @param categoryName
     */
    public void createCategory(String categoryName) {
        // TODO implement logic for new category creation
        WebElement addBtn = driver.findElement(addCategory);
        addBtn.click();
        WebElement nameField = driver.findElement(categoryNameField);
        nameField.sendKeys(categoryName);
        WebElement saveBtn = driver.findElement(saveButton);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", saveBtn);
        waitForContentLoad();
        WebElement creationMsg = driver.findElement(creationMessage);
        String msg = creationMsg.getText().toString();

        if (msg.equals("Создано"))
        {
            System.out.println("Category was successfully created");
        }

    }

    /**
     * Verifies new category in the table.
     * @param categoryName
     */
    public void verifyCategory(String categoryName) {
        // TODO implement logic for new category verification

        WebElement filterField = driver.findElement(searchNameField);
        filterField.sendKeys(categoryName);
        WebElement searchBtn = driver.findElement(searchButton);
        searchBtn.click();
        WebElement verifyCategory = driver.findElement(By.xpath("//*[starts-with(@id,'tr_2_')]/td[contains(text(),'"
                +categoryName+"')]"));
        verifyCategory.click();
        waitForContentLoad();
        WebElement categoryPageTitle = driver.findElement(By.cssSelector(".page-title"));
        String pageTitle = categoryPageTitle.getText().toString();
        if (pageTitle.equals(categoryName)){
            System.out.println("Category verification passed successfully.");
        }

    }

    public void verifyCategoryWithJS (String categoryName) {
        WebElement filterField = driver.findElement(searchNameField);
        filterField.sendKeys(categoryName);
        WebElement searchBtn = driver.findElement(searchButton);
        searchBtn.click();
        WebElement element = driver.findElement(By.xpath("//*[starts-with(@id,'tr_2_')]/td[contains(text(),'"
                +categoryName+"')]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
        waitForContentLoad();
        WebElement categoryPageTitle = driver.findElement(By.cssSelector(".page-title"));
        String pageTitle = categoryPageTitle.getText().toString();
        if (pageTitle.equals(categoryName)){
            System.out.println("Category verification passed successfully.");
        }
    }

    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad() {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(refreshIcon));

    }

}
