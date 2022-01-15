package com.obsqura.seleiumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import port org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.List;


public class SeleniumLaunch {
    static WebDriver driver;

    public static void testIntialise(String browser) {
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

    public static void main(String args[]) {
        testIntialise("Chrome");
        driver.get("http://demowebshop.tricentis.com/login");
        //  String actualTitle = driver.getTitle();
        // System.out.println(actualTitle);
        // String currentUrl= driver.getCurrentUrl();
        // System.out.println(currentUrl);
        //  String pageSource=driver.getPageSource();
        //   System.out.println(pageSource);
       WebElement userName=driver.findElement(By.id("Email"));
        WebElement userName1=driver.findElement(By.name("Email"));
        WebElement userName2=driver.findElement(By.className("email"));
        WebElement userName3=driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        WebElement userName4=driver.findElement(By.cssSelector("#Email"));
        System.out.println(userName);
        System.out.println(userName1);
        System.out.println(userName2);
        System.out.println(userName4);
        System.out.println(userName3);
       WebElement userName5=driver.findElement(By.linkText("Log in"));
        WebElement userName6=driver.findElement(By.partialLinkText("Log"));
        System.out.println(userName5);
        System.out.println(userName6);
        List<WebElement> tag=driver.findElements(By.tagName("input"));
        System.out.println(tag.size());









        driver.close();
        //testIntialise("Edge");
        // testIntialise("Firefox");
        // testIntialise("mm");
    }
}
