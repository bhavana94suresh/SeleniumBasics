package com.obsqura.seleniumCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumCommands {
     WebDriver driver;

    public void testIntialise(String browser) {
        if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\bhavana\\seleniumDriver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("Edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\bhavana\\seleniumDriver\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\bhavana\\seleniumDriver\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equals("ie")) {
            System.setProperty("webdriver.ie.driver", "C:\\bhavana\\seleniumDriver\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else {
            try {
                throw new Exception("Invalid browser");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    @BeforeMethod
    public void setUp(){
        testIntialise("Chrome") ;
    }
    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }
    @Test(priority=1)
    public void verifyLogin(){
        driver.get("http://demowebshop.tricentis.com/register");

        WebElement login= driver.findElement(By.className("ico-login"));
        WebElement userName=driver.findElement(By.id("Email"));
        WebElement password=driver.findElement(By.xpath("//input[@id='Password']"));

    }
}
