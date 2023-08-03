package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseClass;
import pageObjects.RegistrationPage;

public class TC_001_AccountRegistrationTest extends BaseClass{
	@Test(groups= {"Regression","Master"})
	public void test_account_Registration() 
	{
		logger.info("*********starting TC_001_AccountRegistrationTest*******");
		try {
			
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account Link");
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		RegistrationPage regpage=new RegistrationPage(driver);
		
		logger.info("Clicking Customer Info");
		regpage.setFirstName(randomString().toUpperCase());
		
		regpage.setLastName(randomString().toUpperCase());
		
		regpage.setEmail(randomString()+"@gmail.com");// randomly generated the email
		
		
		
		String password=randomAplhaNumeric();
		regpage.setPassword(password);
		
		
		regpage.setPrivacyPolicy();
		//regpage.setSubscribe();
		regpage.setContinueBtn();
		logger.info("Clicked on continue");
		String confmsg=regpage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!","Not getting expected Message");
		}
		catch (Exception e) {
			logger.info("Test Failed");
			Assert.fail();
		}
		logger.info("Finished Executing");
		
	}
	
	
}
