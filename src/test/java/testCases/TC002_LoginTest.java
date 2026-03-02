package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass {

    //Test case for valid credentials
    @Test(groups = {"Sanity", "Master"})
    public void verify_Login()
    {
        logger.info("***Starting TC002 login Test***");

        try
        {
            //Home page
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            //Login page
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(p.getProperty("email"));
            lp.setPassword(p.getProperty("password"));
            lp.clickLogin();

            //My Account page
            MyAccountPage map = new MyAccountPage(driver);
            Boolean targetpage = map.isMyAccountPageExists();

            Assert.assertEquals(targetpage, true, "Login failed"); //if condition is false, it prints "Login failed"
            //Assert.assertTrue(true);  //this is alternate to above statement
        }
        catch(Exception e)
        {
            Assert.fail();
        }
        logger.info("***Finished TC002 login Test***");





    }


}
