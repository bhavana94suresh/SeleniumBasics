package com.obsqura.Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.List;

public class HomeWork3 {
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

    public static void main(String[] args) {
        testIntialise("Chrome");
        driver.get("http://demowebshop.tricentis.com/shipping-returns");
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        String pagrSource = driver.getPageSource();
        //  System.out.println(pagrSource);
        WebElement name = driver.findElement(By.name("NewsletterEmail"));
       // WebElement name1 = driver.findElement(By.className("inputs"));
        WebElement name2 = driver.findElement(By.id("newsletter-email"));
        WebElement name3 = driver.findElement(By.cssSelector("#newsletter-email"));
        WebElement name4 = driver.findElement(By.xpath("//*[@id=\"newsletter-email\"]"));
        WebElement name5 = driver.findElement(By.linkText("Shopping cart"));
        WebElement name6 = driver.findElement(By.partialLinkText("Shopping"));
        List<WebElement> name7 = driver.findElements(By.tagName("div"));
        System.out.println(name);
        //System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
        System.out.println(name4);
        System.out.println(name5);
        System.out.println(name6);
        System.out.println(name7.size());
        driver.close();
    }
}