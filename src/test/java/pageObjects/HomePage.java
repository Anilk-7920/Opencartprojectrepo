package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage  extends  BasePage{

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy (xpath = "//a[@title='My Account']") WebElement my_account;
    @FindBy (xpath = "//a[normalize-space()='Register']") WebElement reg_btn;
    @FindBy (linkText = "Login") WebElement lgn_btn;

    public void clickMyAccount()
    {
        my_account.click();
    }

    public void clickRegister()
    {
        reg_btn.click();
    }

    public void clickLogin()
    {
        lgn_btn.click();
    }





}
