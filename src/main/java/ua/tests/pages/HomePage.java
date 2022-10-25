package ua.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.tests.driver.DriverManager;
import static ua.tests.utils.ConfigProvider.CUCUMBER_URL;

public class HomePage extends BasePage{

    private static final String MENU_SECTION = "//a[contains(@class, 'nav-link')]";
    private static final String TEXT_PATTERN = "%s[contains(text(), '%s')]";
    private static final String CHILD_MENU_ITEM = "//*[contains(@class, 'dropdown')]//*[contains(@class, 'item')]";

    public void openCucumberWebsite() {
        DriverManager.getDriver().get(CUCUMBER_URL);
    }

    public WebElement menuSection(String linkText){
        return findElement(By.xpath(String.format(TEXT_PATTERN,MENU_SECTION,linkText)));
    }

    public WebElement menuChildItem(String linkText) {
        return findElement(By.xpath(String.format(TEXT_PATTERN, CHILD_MENU_ITEM, linkText)));
    }
}
