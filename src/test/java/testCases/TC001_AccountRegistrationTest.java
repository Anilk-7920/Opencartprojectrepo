package testCases;

import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistration;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass{


    @Test(groups = {"Regression", "Master"})
    public void verify_account_registration()
    {
        try {
            HomePage hp = new HomePage(driver);
            logger.info("***starting test case TC001***");
            hp.clickMyAccount();
            logger.info("clicked on my account link...");
            hp.clickRegister();
            logger.info("clicked on register link.. ");

            AccountRegistration regpage = new AccountRegistration(driver);
            //regpage.setFirstname("anil");

            logger.info("providing customer details...");
            regpage.setFirstname(randomString().toUpperCase()); //random generation of fname
            regpage.setLastName(randomString().toUpperCase());  //random generation of lname
            regpage.setEmail(randomString() + "@gmail.com");  //randomly generated the email
            regpage.setInputTelephone(randomNumber());  //random generation of telephone no

            String password = randomAlphaNumeric();

            regpage.setInputPassword(password); //random generation of password through variable
            regpage.setConfirmPassword(password); //random generation of confirm password through variable
            regpage.setPrivacyPolicy();
            regpage.clickContinue();

            logger.info("validating expected message..");
            String confmsg = regpage.getConfirmationMessage();
            if (confmsg.equals("Your Account Has Been Created!"))  //intentionally failing to see logs
            {
                Assert.assertTrue(true);
            }
            else
            {
                logger.error("test failed..");
                logger.debug("debug logs..");
                Assert.fail();
            }
        }
        catch(Exception e)
        {
            Assert.fail();
        }
        logger.info("*** finished test case TC001***");

    }
}
