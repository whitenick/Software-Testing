package pset6;
import static org.junit.Assert.*;

import java.nio.file.Paths;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class MinWebTest {
	@Test public void t0() {
		// execute the test <x = 0, y = 0, z = 0, submitButton = click> and check the output message is correct
		WebDriver wd;
		System.setProperty("webdriver.gecko.driver", "/Users/JocelynYu/Documents/workspace/software1/src/pset6/geckodriver");
		wd = new FirefoxDriver(); // launch the browser
		// edit the next line to enter the location of "min.html" on your file system
		wd.get("file:///"+System.getProperty("user.dir")+"/src/pset6/min.html");
		WebElement we = wd.findElement(By.id("x"));
		we.sendKeys("0"); // enter 0 for x
		we = wd.findElement(By.id("y"));
		we.sendKeys("0"); // enter 0 for y
		we = wd.findElement(By.id("z"));
		we.sendKeys("0"); // enter 0 for z
		we = wd.findElement(By.id("computeButton"));
		we.click();
		WebElement result = wd.findElement(By.id("result"));
		String output = result.getText(); // read the output text
		assertEquals("min(0, 0, 0) = 0", output);
		wd.quit(); // close the browser window
	}
}