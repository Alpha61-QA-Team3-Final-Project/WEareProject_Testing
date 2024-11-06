package weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends HomePage{

    public SearchPage() {
        super("/search?searchParam1=&searchParam2=&index=0&size=10");
    }

    // Locators
    List<WebElement> profileLinks = driver().findElements(By.
            xpath("//a[contains(@class, 'btn') and contains(@class, 'btn-primary')]"));



}
