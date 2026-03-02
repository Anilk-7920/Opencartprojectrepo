package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage{


    public AccountRegistration(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-firstname']") WebElement inputFirstname;
    @FindBy(xpath = "//input[@id='input-lastname']") WebElement inputLastname;
    @FindBy(xpath = "//input[@id='input-email']") WebElement inputEmail;
    @FindBy(xpath = "//input[@id='input-telephone']") WebElement inputTelephone;
    @FindBy(xpath = "//input[@id='input-password']") WebElement inputPassword;
    @FindBy(xpath = "//input[@id='input-confirm']") WebElement inputConfirmPassword;
    @FindBy(xpath = "//input[@name='agree']") WebElement chkdPolicy;
    @FindBy(xpath = "//input[@value='Continue']") WebElement btnContinue;
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;


    public void setFirstname(String fname)
    {
        inputFirstname.sendKeys(fname);
    }
    public void setLastName(String lname)
    {
        inputLastname.sendKeys(lname);
    }
    public void setEmail(String email)
    {
        inputEmail.sendKeys(email);
    }
    public void setInputTelephone(String telephone)
    {
        inputTelephone.sendKeys(telephone);
    }
    public void setInputPassword(String password)
    {
        inputPassword.sendKeys(password);
    }
    public void setConfirmPassword(String confirmPassword)
    {
        inputConfirmPassword.sendKeys(confirmPassword);
    }
   public void setPrivacyPolicy()
    {
        chkdPolicy.click();
    }
   public void clickContinue()
    {
        btnContinue.click();
    }

    public String getConfirmationMessage()
    {
        try {
            return (msgConfirmation.getText());
        }
        catch(Exception e) {
            return (e.getMessage());
        }
    }


}


