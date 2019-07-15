package TestSeleniumYogi;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PogodaTest {
	private WebDriver wd;
	private String url;
	private String city;
	private int Temp;
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver",
				"D:/JAVA/eclipse/chromedriver.exe");	
		wd = new ChromeDriver();
		url = "https://pogoda.interia.pl/";
		city = "Gdynia";
	}
	@Test
	public void Temperature() {
		wd.get(url);
		WebElement SearchName = wd.findElement(By.id("weather-currently-input-text-1"));
		SearchName.clear();
		SearchName.sendKeys(city);
		SearchName.sendKeys(Keys.ENTER);
		
		WebElement Temperatures = wd.findElement(By.xpath("//div[contains(@class, 'weather-currently-temp-strict')]"));
		System.out.println(Temp);
	}
	@After
	public void tearDown() {
		wd.quit();
	}
}
