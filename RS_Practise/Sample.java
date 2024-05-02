import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver","C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https:/rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(1000);
		WebElement UN= driver.findElement(By.id("inputUsername"));
		UN.click();
		UN.sendKeys("Sohiniiiiiiiiiii");
		WebElement pwd= driver.findElement(By.cssSelector("input[placeholder='Password']"));
		pwd.click();
		pwd.sendKeys("123456");
		/*
		 * WebElement cb1 = driver.findElement(By.id("chkboxOne")); cb1.click();
		 * WebElement cb2 = driver.findElement(By.id("chkboxTwo")); cb2.click();
		 */
		WebElement Sign_btn = driver.findElement(By.cssSelector("button[class='submit signInBtn']"));
		Sign_btn.click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		WebElement fp = driver.findElement(By.linkText("Forgot your password?"));
		fp.click();
		Thread.sleep(1000);
		
		//Name
		WebElement Name = driver.findElement(By.cssSelector("input[placeholder='Name']"));
		Name.click();
		Name.sendKeys("Sohini");
		
		//Email
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("abcd45@hotmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("abcd45@gmail.com");
		//WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
		//email.click();
		//email.sendKeys("sbxyz@gmail.com");
		
		//PhoneNumber
		WebElement phn = driver.findElement(By.xpath("//form/input[3]"));
		phn.click();
		phn.sendKeys("9876543210");
		//driver.close();
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		
		//Login with correct inputs
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Sohiniiiiiiiiiii");
		driver.findElement(By.cssSelector("input#inputUsername")).clear();
		driver.findElement(By.cssSelector("input[id*=\"input\"]")).sendKeys("Sohini");
		
		
		driver.findElement(By.xpath("//input[contains(@name,'input')]")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.xpath("//form/div/span/input[@id='chkboxOne']")).click();
		
		driver.findElement(By.cssSelector("form div span input[id='chkboxTwo']")).click();
		
		driver.findElement(By.cssSelector("button[class='submit signInBtn']")).click();
		
		Thread.sleep(1000);
		
		}

}
