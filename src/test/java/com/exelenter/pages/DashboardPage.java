package com.exelenter.pages;

import com.exelenter.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BaseClass {
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    public WebElement dashboardHeaderText;       // <== public WebElement welcome = driver.findElement(By.id("welcome"));

    @FindBy(css = "div#branding a img:nth-child(1)")
    public WebElement dashboardLogo;

    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }
}
