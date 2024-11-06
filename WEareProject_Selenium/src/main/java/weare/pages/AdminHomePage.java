package weare.pages;

import org.openqa.selenium.By;

public class AdminHomePage extends HomePage{

    public AdminHomePage() {
        super("");
    }

    private final By adminZoneLink = By.xpath("//a[@href='/admin']");
    private final By personalProfileLink = By.xpath("//a[contains(text(),'Personal')]");
    private final By addNewPostLink = By.xpath("//a[contains(text(),'Add New')]");
    private final By logoutLink = By.xpath("//a[normalize-space()='LOGOUT']");

    // Actions
    public void clickAdminZone(){
        driver().findElement(adminZoneLink).click();
    }

    public void clickPersonalProfile(){
        driver().findElement(personalProfileLink).click();
    }

    public void clickAddNewPost(){
        driver().findElement(addNewPostLink).click();
    }

    public void clickLogout(){
        driver().findElement(logoutLink).click();
    }


}
