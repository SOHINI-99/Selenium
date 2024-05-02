import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class demo_process {

	@Test
	public void Login() throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
		
		WebElement Email = driver.findElement(By.id("Email"));
		WebElement Password = driver.findElement(By.id("Password"));
		WebElement RememberMe = driver.findElement(By.id("RememberMe"));
		
		WebElement LoginButton = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
		
		
		Email.sendKeys("eeffb123@gmail.com");
		Thread.sleep(2000);
		Password.sendKeys("12345656");
		//RememberMe.click();
		
		LoginButton.click();
		WebElement findXpath = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[1]/div/span"));
		String actualMessage = findXpath.getText();
		String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.";
		Assert.assertEquals(actualMessage,expectedMessage);
		if (actualMessage.equals(expectedMessage))
		{
			System.out.print("The credentials provided are incorrect!\n");
			WebElement ForgotPwd = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[4]/span/a"));
			ForgotPwd.click();
			WebElement EmailPwd = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/form/div[1]/div/div/input"));
			EmailPwd.sendKeys("eeffb123@gmail.com");
			WebElement RecoverBtn = driver.findElement(By.className("password-recovery-button"));
			RecoverBtn.click();
			WebElement findXpath1 = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div"));
			String actualMessage1 = findXpath1.getText();
			String expectedMessage1 = "Email with instructions has been sent to you.";
			Assert.assertEquals(actualMessage1,expectedMessage1);
			System.out.print("Email with instructions has been sent to you.!\n");
		}
		else
		{
			WebElement Password1 = driver.findElement(By.id("Password"));
			Password1.sendKeys("123456");
			WebElement Logout = driver.findElement(By.className("ico-logout"));
			Logout.click();
		}
		
		
		Thread.sleep(4000);
		
		driver.quit();
		
		
	}

}
/*
 import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
		
		WebElement Email = driver.findElement(By.id("Email"));
		WebElement Password = driver.findElement(By.id("Password"));
		WebElement RememberMe = driver.findElement(By.id("RememberMe"));
		
		WebElement LoginButton = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
		
		
		Email.sendKeys("eeffb123@gmail.com");
		Thread.sleep(2000);
		Password.sendKeys("12345656");
		//RememberMe.click();
		
		LoginButton.click();
		WebElement findXpath = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[1]/div/span"));
		String actualMessage = findXpath.getText();
		String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.";
		Assert.assertEquals(actualMessage,expectedMessage);
		if (actualMessage.equals(expectedMessage))
		{
			System.out.print("The credentials provided are incorrect!\n");
			WebElement ForgotPwd = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[4]/span/a"));
			ForgotPwd.click();
			WebElement EmailPwd = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/form/div[1]/div/div/input"));
			EmailPwd.sendKeys("eeffb123@gmail.com");
			WebElement RecoverBtn = driver.findElement(By.className("password-recovery-button"));
			RecoverBtn.click();
			WebElement findXpath1 = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div"));
			String actualMessage1 = findXpath1.getText();
			String expectedMessage1 = "Email with instructions has been sent to you.";
			Assert.assertEquals(actualMessage1,expectedMessage1);
			System.out.print("Email with instructions has been sent to you.!\n");
		}
		else
		{
			WebElement Password1 = driver.findElement(By.id("Password"));
			Password1.sendKeys("123456");
			WebElement Logout = driver.findElement(By.className("ico-logout"));
			Logout.click();
		}
		
		
		Thread.sleep(4000);
		
		driver.quit();
		
	}

}
 */
