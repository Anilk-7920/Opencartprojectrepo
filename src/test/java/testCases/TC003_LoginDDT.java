package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void verify_Login(String email, String pwd, String exp) throws InterruptedException {
        logger.info("***Starting TC003 login Test***");
        try {
            //Home page
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            //Login page
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(email);
            lp.setPassword(pwd);
            lp.clickLogin();

            //My Account page
            MyAccountPage map = new MyAccountPage(driver);
            Boolean targetpage = map.isMyAccountPageExists();

        /*
        Scenarios:
        1. Data is valid ---- login success ---test pass --- log out
                               login failed---  test failed
         2. Data is invalid---login success --- test fail --- logout
                                login failed --- test pass

         */

            if (exp.equalsIgnoreCase("valid"))
            {
                if (targetpage == true)
                {
                    map.clickLogout();   //click action is included before assert statement because after assert statement, the next statement wont execute
                    Assert.assertTrue(true);
                }
                else
                {
                Assert.assertTrue(false);
                }
            }
            if (exp.equalsIgnoreCase("invalid"))
            {
                if (targetpage == true)
                {
                    map.clickLogout();
                    Assert.assertTrue(false);
                }
                else
                {
                    Assert.assertTrue(true);
                }
            }
        }
        catch(Exception e)
        {
            Assert.fail();
        }
        //Thread.sleep(3000);
        logger.info("***Finished TC003 login Test***");
    }

}

/*
dataProviderClass = DataProvider.class - for getting data provider from different class.
it is not required if the data provider is mentioned within this class.

doubts:
where the 'exp' value is fetching from?
 */