package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    static void main() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\ginaleks\\Desktop\\work\\selenium-pr\\chromedriver-win64\\chromedriver.exe");
        WebDriver  driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



    }
}
