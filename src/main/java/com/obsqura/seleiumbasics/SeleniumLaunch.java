package com.obsqura.seleiumbasics;

import org.openqa.selenium.WebDriver;
//import port org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


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
        } else {
            System.setProperty("webdriver.ie.driver", "C:\\bhavana\\seleniumDriver\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
    }
    public static void main(String args[]) {
        testIntialise("Chrome");
        testIntialise("Edge");
        testIntialise("Firefox");
        testIntialise("ie");
    }
}
