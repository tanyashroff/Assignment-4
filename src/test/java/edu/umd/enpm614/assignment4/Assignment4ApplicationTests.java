package edu.umd.enpm614.assignment4;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Assignment4ApplicationTests {
	public static WebDriver driver;

	@LocalServerPort
	private int port;

	@BeforeAll
	public static void setUpClass() throws Exception {
//		If this does set up doesn't work:
		SeleniumTest.setUpWebDriver();
//		Try this one of these:
//		SeleniumTest.setUpWebDriver(SeleniumTest.VERSION_88)
//		SeleniumTest.setUpWebDriver(SeleniumTest.VERSION_90);
		driver = new ChromeDriver();
	}

	@BeforeEach
	public void setUp () {
		driver.get("http://localhost:" + port + "/index");
	}

	@AfterAll
	public static void tearDownClass() {
		driver.quit();
	}

	@Test
	void contextLoads() throws InterruptedException, MalformedURLException {
		Thread.sleep(5000);
		//Calculator
		driver.findElement(By.cssSelector("a.btn.btn-lg.btn-secondary.px-5")).click();
		//testing integer parameters in URL
		String url = driver.getCurrentUrl();
		String[] params = url.split("&");
		for (int i=0; i<3; i++) {
			String para1 = params[i].split("=")[1];
			if(i<2) {
				assertTrue(para1.matches("^[0-9]+$"));
			}
			else {
				assertTrue(para1.matches("plus") || para1.matches("minus"));
			}
			}
		//testing result or error shown
		assertTrue((driver.getPageSource().contains("Result")) || (driver.getPageSource().contains("Error")));

		//Form
		driver.get("http://localhost:" + port + "/form");

		driver.findElement(By.name("email")).sendKeys("abc@umd.edu");
		WebElement radio = driver.findElement(By.xpath("//input[@value='red']"));
		radio.click();
		 WebElement agree = driver.findElement(By.xpath("//label[@for='switch1']"));
		agree.click();
		//WebElement agree = driver.findElement(By.xpath("//input[@class='custom-control-input is-invalid']//label[contains(text(),'I Agree')]"));
		//agree.click();



		//hit submit
		WebElement sub = driver.findElement(By.xpath("//button[@class='btn btn-primary px-5']"));
		sub.click();
		Thread.sleep(1000);

		//check email
		String email = driver.findElement(By.name("email")).getAttribute("value");
		assertTrue(email.matches("^[A-Za-z0-9._%+-]+@umd.edu$") || (driver.getPageSource().contains("Email must end with '@umd.edu'.")));
		//check color selected
		assertTrue( driver.findElement(By.name("color")).isSelected() || (driver.getPageSource().contains("You must pick a color.")));
		//agree button selected
		assertTrue( driver.findElement(By.xpath("//label[@for='switch1']")).isEnabled() || (driver.getPageSource().contains("You must agree to submit form.")));


	}

	}


