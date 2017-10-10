package myprojects.automation.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventHandler implements WebDriverEventListener{


    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Before navigating to: '" + s + "'");
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Open url: " + s);
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        System.out.println("Navigating back to previous page");
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        System.out.println("Navigated back to previous page");
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        System.out.println("Navigating forward to next page");
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        System.out.println("Navigated forward to next page");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        System.out.println("Refreshing the page");
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        System.out.println("Page was refreshed");
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Search for element: " + by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Element found successfully");
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Click on element: " + webElement.getTagName() + " " + webElement.getAttribute("name"));
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Element successfully clicked");
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Fill input " + webElement.getAttribute("id") + " with value " + charSequences.toString());
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Value successfully changed");
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {

    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        System.out.println("Exception occured: " + throwable);
    }

}
