import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNGTest {

    WebDriver driver;
    @BeforeTest
    public void setup() {

//        System.setProperty("webdriver.chrome.driver",
//                "C:\\Users\\ginaleks\\Desktop\\work\\selenium-pr\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void executeTest() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\ginaleks\\Desktop\\work\\selenium-pr\\chromedriver-win64\\chromedriver.exe");

        driver.get("https://seeburger.bg/careers/#divisions-and-teams");

        WebElement element =
                driver.findElement(By.xpath("/html/body/main/article/div/div[7]/div/div/div/div[1]/a/div/div[2]/p"));

        String expectedTitle = "Software Development";

        Assert.assertEquals(element.getText(), expectedTitle.toUpperCase());
        Assert.assertTrue(element.isDisplayed());

    }

    @Test
    public void executeTest2() {
        driver.get("https://seeburger.bg/careers/#divisions-and-teams");

        WebElement element =
                driver.findElement(By.xpath("/html/body/main/article/div/div[7]/div/div/div/div[2]/a/div/div[2]/p"));

        String expectedTitle = "Trading Partner Services";

        Assert.assertEquals(element.getText(), expectedTitle.toUpperCase());
        Assert.assertTrue(element.isDisplayed());

    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
