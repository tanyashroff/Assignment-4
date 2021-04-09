package edu.umd.enpm614.assignment4;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

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
	void contextLoads() throws InterruptedException {
		Thread.sleep(5000);
	}

}
