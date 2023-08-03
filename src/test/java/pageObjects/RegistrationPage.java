package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

public class RegistrationPage extends BasePage{
	JavascriptExecutor js=(JavascriptExecutor)driver;

	public RegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (name="firstname") WebElement  txtFirstname;
	@FindBy (name="lastname") WebElement txtLastname;
	@FindBy(name = "email")WebElement txtEmail;
	@FindBy(name = "password")WebElement txtPassword;
	//@FindBy(name="newsletter") WebElement txtSubscribe;
	@FindBy(name="agree") WebElement chkdPolicy;
	@FindBy(xpath="//button[normalize-space()='Continue']")WebElement btnContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;
	
	public void setFirstName(String fName) {
		txtFirstname.sendKeys(fName);
	}
	public void setLastName(String lName) {
		txtLastname.sendKeys(lName);
		
	}
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	/*public void setSubscribe() {
		txtSubscribe.click();
	}*/
	public void setPrivacyPolicy() {
		js.executeScript("arguments[0].click();", chkdPolicy);
		
	}
	
	public void setContinueBtn() {
		//btnContinue.click();
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", btnContinue);
	}

	public String getConfirmationMsg() {
		try {
		return msgConfirmation.getText();
		}
		catch (Exception e) {
			return e.getMessage();
		}
		
	}
}
