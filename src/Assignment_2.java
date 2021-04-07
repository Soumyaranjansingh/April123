
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;




public class Assignment_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Software Testing\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.cleartrip.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#OneWay")).click();
		driver.findElement(By.cssSelector("#FromTag")).sendKeys("New Delhi");
		Thread.sleep(2000);
		List<WebElement> options= driver.findElements(By.xpath("//ul[@class='autoComplete'] //a"));
		for(WebElement option : options)
		{
			if(option.getText().contains("Delhi"))
			{
				option.click();
				break;
			}
		}
		driver.findElement(By.cssSelector("#DepartDate")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active ")).click();
		Thread.sleep(2000);
		WebElement Staticdropdown1=driver.findElement(By.cssSelector("#Adults"));
		Select dropdown1=new Select(Staticdropdown1);
		System.out.println(dropdown1.getFirstSelectedOption().getText());
		dropdown1.selectByValue("4");
		System.out.println(dropdown1.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		WebElement Staticdropdown2=driver.findElement(By.cssSelector("#Childrens"));
		Select dropdown2=new Select(Staticdropdown2);
		System.out.println(dropdown2.getFirstSelectedOption().getText());
		dropdown2.selectByIndex(3);
		System.out.println(dropdown2.getFirstSelectedOption().getText());
		driver.findElement(By.cssSelector("#MoreOptionsLink")).click();
		driver.findElement(By.cssSelector("#AirlineAutocomplete")).sendKeys("indigo");
		Thread.sleep(2000);
		List<WebElement> options1= driver.findElements(By.cssSelector("ul[class='autoComplete']"));
		for(WebElement option1 : options1)
		{
			if(option1.getText().contains("IndiGo"))
			{
				option1.click();
				break;
			}
		}
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("#SearchBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("#homeErrorMessage")).getText());
	}

}
