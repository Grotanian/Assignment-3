package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.GeneralActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateCategoryTest extends BaseScript {
    public static void main(String[] args) throws InterruptedException {
        String email = "webinar.test@gmail.com";
        String passwd = "Xcg7299bnSmMuRLp9ITw";
        String categoryName = "Children";


        WebDriver driver = getConfiguredDriver();
        GeneralActions general_actions = new GeneralActions(driver);

        // login
        general_actions.login(email,passwd);
        general_actions.waitForContentLoad();
        general_actions.NavigateToCategoryTabWithJS();

        // create category
        general_actions.createCategory(categoryName);

        // check that new category appears in Categories table
        general_actions.NavigateToCategoryTabWithJS();
        general_actions.verifyCategoryWithJS(categoryName);

        // finish script
        BaseScript.quitDriver(driver);
        //driver.quit();
    }
}
