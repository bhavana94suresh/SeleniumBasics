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

        WebElement login= driver.findElement(By.xpath("//a[@class='ico-login']"));
        login.click();
        WebElement userName=driver.findElement(By.id("Email"));
        userName.sendKeys("bhavana123456@gamil.com");
        WebElement password=driver.findElement(By.xpath("//input[@id='Password']"));
        WebElement loginbutton=driver.findElement(By.xpath("//input[@value='Log in']"));
        String loginb= loginbutton.getAttribute("value");
        System.out.println(loginb);
    }
    @Test(priority=2)
    public void register()
    {
        driver.get("http://demowebshop.tricentis.com/register");
        WebElement registerb=driver.findElement(By.className("ico-register"));
        registerb.click();
        WebElement gender=driver.findElement(By.xpath("//input[@name='Gender']"));
        WebElement female=driver.findElement(By.xpath("//input[@id='gender-female']"));
        female.click();
        WebElement firstName=driver.findElement(By.id("FirstName"));
        firstName.sendKeys("diyaa");
        WebElement lastName=driver.findElement(By.id("LastName"));
        lastName.sendKeys("sreejithh");
        WebElement registerEmail=driver.findElement(By.id("Email"));
        registerEmail.sendKeys("diyasree1456@gmail.com");
        WebElement registerPassword=driver.findElement(By.xpath("//input[@id='Password']"));
        registerPassword.sendKeys("diyasree1234");
        WebElement reconfirmPassword=driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        reconfirmPassword.sendKeys("diyasree1234");
        WebElement register1=driver.findElement(By.id("register-button"));
        register1.click();
        WebElement registerMessage=driver.findElement(By.xpath("//div[@class='result']"));
        String message= registerMessage.getText();
        System.out.println(message);

    }
}
