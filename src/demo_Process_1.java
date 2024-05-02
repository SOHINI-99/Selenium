import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class demo_Process_1 {
	static ChromeDriver driver = new ChromeDriver();
	static JavascriptExecutor js = (JavascriptExecutor) driver;

	@Test
	public static void login() throws InterruptedException {
		// open chrome
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		// Login to DemoWebShop
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();

		WebElement Email = driver.findElement(By.id("Email"));
		WebElement Password = driver.findElement(By.id("Password"));
		WebElement RememberMe = driver.findElement(By.id("RememberMe"));

		WebElement LoginButton = driver.findElement(
				By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));

		Email.sendKeys("rosie3597@gmail.com");
		Thread.sleep(2000);
		Password.sendKeys("123456");
		RememberMe.click();

		LoginButton.click();
	}

	public static void Book_Order() throws InterruptedException {
		WebElement Book = driver.findElement(By.xpath("//a[@href='/books']"));
		Book.click();
		
		//Use filters for ordering item
		driver.findElement(By.id("products-orderby")).click();
		WebElement Position = driver.findElement(By.xpath("//*[@id=\"products-orderby\"]/option[4]"));
		Position.click();
		
		driver.findElement(By.id("products-pagesize")).click();
		WebElement Display = driver.findElement(By.xpath("//*[@id=\"products-pagesize\"]/option[3]"));
		Display.click();
		
		driver.findElement(By.id("products-viewmode")).click();
		WebElement View_as = driver.findElement(By.xpath("//*[@id=\"products-viewmode\"]/option[1]"));
		View_as.click();
		
		WebElement filter_by_price = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[2]/div/div[2]/ul/li[1]/a/span"));
		filter_by_price.click();
		
		// select a book
		WebElement bk = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[5]/div/div[2]/h2/a"));
		js.executeScript("arguments[0].scrollIntoView();", bk);
		bk.click();
		
		WebElement qty = driver.findElement(By.xpath("//*[@id=\"addtocart_45_EnteredQuantity\"]"));
		qty.click();
		qty.clear(); 
		qty.sendKeys("2");
		 
		
		WebElement Cart_btn = driver.findElement(By.className("add-to-cart-button"));
		Cart_btn.click();
		System.out.println("Item added to the cart . . .");

	}

	public static void shopping_cart() { 
		//WebElement cart = driver.findElement(By.className("cart-label")); 
		WebElement cart = driver.findElement(By.xpath("//a[@href='/cart']"));//[@id="topcartlink"]/a/span[1] 
		cart.click(); 
		
		WebElement price = driver.findElement(By.className("product-unit-price")); 
		String Pr = price.getText();
		double Price = Double.parseDouble(Pr);
		System.out.println("Price: "+Price);
		
		WebElement qty = driver.findElement(By.className("qty-input"));
		qty.click();
		String Qty = qty.getAttribute("value");
		int quantity = Integer.parseInt(Qty);
		System.out.println("Quantity: "+quantity);
		//qty.clear();
		//qty.sendKeys("2");
		
		double t = Price * quantity;
		System.out.println("Total Amt. is: "+t);
		
		WebElement SubTotal = driver.findElement(By.className("product-subtotal"));
		String Total = SubTotal.getText();
		double total = Double.parseDouble(Total);
		System.out.println("SubTotal: "+total);
		
		//Verify the Total Amount
		if( t == total)
			System.out.println("\t\n Success !!! Total amount is correct: " +total);
		else
			System.out.println("Not Success...");
		
		driver.findElement(By.xpath("//*[@id=\"CountryId\"]")).click();
		WebElement country = driver.findElement(By.xpath("//*[@id=\"CountryId\"]/option[99]"));
		country.click();
		WebElement State = driver.findElement(By.id("StateProvinceId"));
		//js.executeScript("arguments[0].scrollIntoView();", State);
		State.click();
		WebElement zip = driver.findElement(By.id("ZipPostalCode"));
		zip.sendKeys("700109");
		WebElement btn = driver.findElement(By.className("estimate-shipping-button"));
		btn.click();
		
		WebElement CheckBox = driver.findElement(By.xpath("//*[@id=\"termsofservice\"]"));
		CheckBox.click();
		
		WebElement CheckOut = driver.findElement(By.xpath("//*[@id=\"checkout\"]"));
		CheckOut.click();
		// Check if the pop-up is displayed
		try 
		{
			WebElement popupElement = driver.findElement(By.cssSelector(".ui-dialog"));
		    // Get the message from the popup
		    String popupMessage = popupElement.findElement(By.tagName("p")).getText();
		    System.out.println("Popup Message: " + popupMessage);

		    // Close the pop-up
		    WebElement closePopup = driver.findElement(By.className("ui-icon-closethick"));
		    closePopup.click();

		    // Print a message indicating checkout not successful
		    System.out.println("Checkout not successful. Pop-up detected.");
		    WebElement CheckBox1 = driver.findElement(By.xpath("//*[@id=\"termsofservice\"]"));
			CheckBox1.click();
			WebElement CheckOutButton = driver.findElement(By.xpath("//*[@id=\"checkout\"]"));
			CheckOutButton.click();
		    
		}catch (Exception e) {
            // Handle the case when the pop-up is not present
            System.out.println("Pop-up not found. Continuing with the checkout process.");
		}
		
	
		/*WebElement t_c = driver.findElement(By.id("termsofservice"));
		if(!t_c.isSelected())
			t_c.click();
			System.out.println("Agree To The Terms & Condition ...");
		WebElement Checkout = driver.findElement(By.id("checkout"));
		Checkout.click();*/
	}
	public static void checkout() throws InterruptedException {
		System.out.println("\n\t\t\t Checkout Process");
		
		//Billing_Address
		WebElement OldAdd = driver.findElement(By.xpath("//*[@id=\"billing-address-select\"]"));
		OldAdd.click();
		WebElement NewAdd = driver.findElement(By.xpath("//*[@id=\"billing-address-select\"]/option[2]"));
		NewAdd.click();
		WebElement Country = driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]"));
		Country.click();
		WebElement CountrySelect = driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]/option[99]"));
		CountrySelect.click();
		//WebElement Province = driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_StateProvinceId\"]"));
		//Province.click();
		//WebElement ProvinceDropdown = driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_StateProvinceId\"]/option"));
		//ProvinceDropdown.click();
		WebElement City = driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_City\"]"));
		City.clear();
		City.sendKeys("xyz");
		WebElement Address1 = driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_Address1\"]"));
		Address1.clear();
		Address1.sendKeys("abcdefg");
		WebElement Zip = driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_ZipPostalCode\"]"));
		Zip.sendKeys("123000");
		WebElement Phone = driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_PhoneNumber\"]"));
		Phone.sendKeys("987654321");
		WebElement BillAdd_ContinueBtn = driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/input"));
		BillAdd_ContinueBtn.click();
		Thread.sleep(2000);
		
		System.out.print("\t\t\t Billing Address Successfully Updated!\n");

		
		//Shipping_Address
		WebElement ShippingAddCnfrm = driver.findElement(By.xpath("//*[@id=\"shipping-address-select\"]"));
		ShippingAddCnfrm.click();
		WebElement NewAdd1 = driver.findElement(By.xpath("//*[@id=\"shipping-address-select\"]/option[2]"));
		NewAdd1.click();
		WebElement Country1 = driver.findElement(By.xpath("//*[@id=\"ShippingNewAddress_CountryId\"]"));
		Country1.click();
		WebElement Country1_Select = driver.findElement(By.xpath("//*[@id=\"ShippingNewAddress_CountryId\"]/option[85]"));
		Country1_Select.click();
		WebElement City1 = driver.findElement(By.xpath("//*[@id=\"ShippingNewAddress_City\"]"));
		City1.clear();
		City1.sendKeys("xyz");
		WebElement Address_shipping = driver.findElement(By.xpath("//*[@id=\"ShippingNewAddress_Address1\"]"));
		Address_shipping.clear();
		Address_shipping.sendKeys("abcdefg");
		WebElement Zip1 = driver.findElement(By.xpath("//*[@id=\"ShippingNewAddress_ZipPostalCode\"]"));
		Zip1.sendKeys("123000");
		WebElement Phone1 = driver.findElement(By.xpath("//*[@id=\"ShippingNewAddress_PhoneNumber\"]"));
		Phone1.sendKeys("987654321");
		WebElement InStorePickUp = driver.findElement(By.xpath("//*[@id=\"PickUpInStore\"]"));
		InStorePickUp.click();
		WebElement BacktoPrevious1 = driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/p/a"));
		BacktoPrevious1.click();
		Thread.sleep(3000);
		WebElement BillAdd_Continue1 = driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/input"));
		BillAdd_Continue1.click();
		Thread.sleep(3000);
		WebElement Shipping_Continue = driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input"));
		Shipping_Continue.click();	
		Thread.sleep(2000);
		
		System.out.println("\t\t\t Shipping Address Successfully Updated!");
		
		
		//Shipping Method
		WebElement Ground = driver.findElement(By.id("shippingoption_0"));
		Ground.click();
		WebElement BacktoPrevious2 = driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/p/a"));
		BacktoPrevious2.click();
		Thread.sleep(3000);
		WebElement Shipping_Continue1 = driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input"));
		Shipping_Continue1.click();
		Thread.sleep(3000);
		WebElement ShipMethod_Continue = driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input"));
		ShipMethod_Continue.click();
		Thread.sleep(2000);
		
		System.out.println("\t\t\t Shipping Method Successfully Updated!");
		
		//Payment_Method
		WebElement COD = driver.findElement(By.xpath("//*[@id=\"paymentmethod_0\"]"));
		COD.click();
		
		WebElement BacktoPrevious3 = driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/p/a"));
		BacktoPrevious3.click();
		Thread.sleep(3000);
		WebElement ShipMethod_Cont = driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input"));
		ShipMethod_Cont.click();
		Thread.sleep(3000);
		WebElement Payment_Continue = driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input"));
		Payment_Continue.click();
		Thread.sleep(2000);
		
		System.out.println("\t\t\t Payment Method Successfully Updated!");
		
		//Payment Information
		WebElement BacktoPrevious4 = driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/p/a"));
		BacktoPrevious4.click();
		Thread.sleep(3000);
		WebElement PaymentContR = driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input"));
		PaymentContR.click();
		Thread.sleep(3000);
		WebElement PaymentInfo = driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input"));
		PaymentInfo.click();
		Thread.sleep(2000);
		
		System.out.println("\t\t\t Payment Information Successfully Updated!");
		
		//ConfirmOrder
		WebElement BacktoPrevious5 = driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/p/a"));
		BacktoPrevious5.click();
		Thread.sleep(3000);
		WebElement PaymentInfoR = driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input"));
		PaymentInfoR.click();
		Thread.sleep(3000);
		WebElement Confirm_Order = driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input"));
		Confirm_Order.click();
		
		System.out.println("\t\t\t Order Confirmed!");
	}
		
	public static void order_detail(){
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
        WebElement successMessage = driver.findElement(By.xpath("//*[contains(text(),'Your order has been successfully processed!')]"));
        // Verify if the success message is displayed
        if (successMessage.isDisplayed()) {
            System.out.println("Success message found: Your order has been successfully processed!");
        } else {
            System.out.println("Success message not found!");
        }
		
		WebElement orderNumberElement = driver.findElement(By.xpath("//li[contains(text(),'Order number:')]"));
        // Get the text content of the element
        String orderNumber_Text = orderNumberElement.getText();
        // Output the order number
        System.out.println(orderNumber_Text);
        //Click to view & Verify the Order Details
		WebElement co = driver.findElement(By.linkText("Click here for order details."));
		co.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement orderNumberElement1 = driver.findElement(By.xpath("//*[contains(text(),'Order #')]"));
		// Get the text content of the element
		String orderNumber_Text1 = orderNumberElement1.getText();
		// Output the order number
		System.out.println(orderNumber_Text1);
		
		
		// Extract the order number using regular expression
        String orderNumber = orderNumber_Text.replaceAll("\\D+", ""); // Remove non-digit characters
        String orderNumber1 = orderNumber_Text1.replaceAll("\\D+", ""); // Remove non-digit characters

        if (orderNumber.equals(orderNumber1)) {
		    System.out.println("Order Id Matched. Expected: " + orderNumber1 + ", Actual: " + orderNumber);
		} else {
		    System.out.println("Order Id Mismatched. Expected: " + orderNumber1 + ", Actual: " + orderNumber);
		}
        
        driver.navigate().back();
        WebElement Continue_btn = driver.findElement(By.className("order-completed-continue-button"));
        Continue_btn.click();
	}
	public static void Profile() {
		WebElement user_profile = driver.findElement(By.className("account"));
		user_profile.click();
	}
	public static void reOrder_Process() throws InterruptedException {
		WebElement ReOrder = driver.findElement(By.className("re-order-button"));
		ReOrder.click();
		
		//calling the functions
		shopping_cart();
		checkout();
		order_detail();
		}

	public static void main(String args[]) throws InterruptedException {
		login();
		Book_Order();
		//shopping_cart();
		//checkout();
		//order_detail();
		//Profile();
		//reOrder_Process();
		
	}

}
