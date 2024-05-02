import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class demo {
			@Test
			public void Register() throws InterruptedException
			{
				//invoking browser Chrome
				ChromeDriver driver = new ChromeDriver();
				driver.get("https://demowebshop.tricentis.com/fiction");
				//Maximise the window
				driver.manage().window().maximize();
				Thread.sleep(2000);
			
				WebElement register = driver.findElement(By.className("ico-register"));
				register.click();
				WebElement gender = driver.findElement(By.id("gender-female"));
				gender.click();
				WebElement first = driver.findElement(By.id("FirstName"));
				first.sendKeys("Shalini");
				WebElement last = driver.findElement(By.id("LastName"));
				last.sendKeys("Bhatt");
				WebElement g = driver.findElement(By.id("Email"));
				g.sendKeys("xyz1234@gmail.com");
				WebElement p = driver.findElement(By.name("Password"));
				p.sendKeys("123456");
				WebElement c_p = driver.findElement(By.name("ConfirmPassword"));
				c_p.sendKeys("123456");
				WebElement register_btn = driver.findElement(By.id("register-button"));
				register_btn.click();
			
				//Verify whether registered or not
				WebElement findXpath = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[1]/div/ul/li"));
				String actualMessage = findXpath.getText();
				String expectedMessage = "The specified email already exists";
				Assert.assertEquals(actualMessage,expectedMessage);
				if(actualMessage.equals(expectedMessage))
				{
					System.out.print("Email already exists!\n");
					driver.navigate().refresh();
					WebElement f1 = driver.findElement(By.id("FirstName"));
					f1.clear();
					Thread.sleep(2000);
					f1.sendKeys("Rosy69");
					WebElement Email1 =driver.findElement(By.id("Email"));
					Email1.clear();
					Thread.sleep(2000);
					Email1.sendKeys("rosie3597@gmail.com");
					System.out.print("New Email Entered!");
					WebElement RegButton1 = driver.findElement(By.xpath("//*[@id=\"register-button\"]"));
					RegButton1.click();
				};
				driver.findElement(By.id("dialog-notifications-success")).getText();
				driver.findElement(By.className("register-continue-button")).click();
				
				Thread.sleep(10000);
				driver.quit();
			}
		}

			/*WebElement findXpath = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[1]/div/ul/li"));
			String actualMessage = findXpath.getText();
			String expectedMessage = "The specified email already exists";
			Assert.assertEquals(actualMessage,expectedMessage);
			*/