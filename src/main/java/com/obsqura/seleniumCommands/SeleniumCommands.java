package com.obsqura.seleniumCommands;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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
        //driver.close();
    }

    @Test(priority=1)

    public void verifyLogin(){
        driver.get("http://demowebshop.tricentis.com/register");

        WebElement login= driver.findElement(By.xpath("//a[@class='ico-login']"));
        login.click();
        WebElement userName=driver.findElement(By.id("Email"));
        userName.sendKeys("diyasreeee145671@gmail.com");
       // userName.clear();
        WebElement password=driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("diyasreeee123456");
        WebElement loginbutton=driver.findElement(By.xpath("//input[@value='Log in']"));
        String loginb= loginbutton.getAttribute("value");
        System.out.println(loginb);
        String loginTag=loginbutton.getTagName();
        System.out.println(loginTag);
        Point location =loginbutton.getLocation();
        System.out.println(location.x);
        Dimension size=loginbutton.getSize();
        System.out.println(size.width);
       boolean enableStatus= loginbutton.isEnabled();
        System.out.println(enableStatus);
        boolean displayStatus=loginbutton.isDisplayed();
        System.out.println(displayStatus);

        loginbutton.click();
    }

    @Test(priority=2)

    public void register()
    {
        driver.get("http://demowebshop.tricentis.com/register");
        WebElement registerb=driver.findElement(By.className("ico-register"));
        registerb.click();
        WebElement gender=driver.findElement(By.xpath("//input[@name='Gender']"));
        WebElement female=driver.findElement(By.xpath("//input[@id='gender-female']"));
        WebElement male=driver.findElement(By.xpath("//input[@id='gender-male']"));
        female.click();
        boolean selectionStstus=female.isSelected();
        System.out.println(selectionStstus);
        boolean selectionStatus2=male.isSelected();
        System.out.println(selectionStatus2);
        WebElement firstName=driver.findElement(By.id("FirstName"));
        firstName.sendKeys("diiiyaa");
        WebElement lastName=driver.findElement(By.id("LastName"));
        lastName.sendKeys("sreeeejithh");
        WebElement registerEmail=driver.findElement(By.id("Email"));
        registerEmail.sendKeys("diysreeee1456751@gmail.com");
        WebElement registerPassword=driver.findElement(By.xpath("//input[@id='Password']"));
        registerPassword.sendKeys("diyasreeee123456");
        WebElement reconfirmPassword=driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        reconfirmPassword.sendKeys("diyasreeee123456");
        WebElement register1=driver.findElement(By.id("register-button"));
        register1.click();
        WebElement registerMessage=driver.findElement(By.xpath("//div[@class='result']"));
        String message= registerMessage.getText();
        System.out.println(message);

    }
    @Test(priority=3)
    public void verifyFindElement()
    {
        driver.get("http://demowebshop.tricentis.com");
        WebElement registerb=driver.findElement(By.className("ico-register"));
        registerb.click();
        selectGender("Female");
    }
    public void selectGender(String gender)
    {
        List<WebElement>genderSelection =driver.findElements(By.xpath("//label[@class='forcheckbox']"));
        for(int i=0;i<genderSelection.size();i++)
        {
            String value=genderSelection.get(i).getText();
            if(value.equals(gender)){
                genderSelection.get(i).click();
                break;
            }
        }
    }
    @Test(priority=4)
    public void verifyNavigationCommands()
    {
        driver.get("http://demowebshop.tricentis.com");
        WebElement registerb=driver.findElement(By.className("ico-register"));
        registerb.click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.navigate().to("https://www.google.com/");
    }
   @Test(priority=5)
    public void verifyFindElement1()
   {
       driver.get("http://demowebshop.tricentis.com");
     findCommunalityRating("Good");
   }
   public void findCommunalityRating(String rating)
   {
    List<WebElement>communityRating= driver.findElements(By.xpath("//input[@type='radio']/following-sibling::label"));
    for(int i=0;i<communityRating.size();i++)
    {
        String value1=communityRating.get(i).getText();
        if(value1.equals(rating))
        {
            communityRating.get(i).click();
            break;
        }
    }

   }
    @Test(priority =5 )
    public void verifyDropDowns(){
        driver.get("https://demo.guru99.com/selenium/newtours/");
        WebElement registerMenu= driver.findElement(By.xpath("//a[@href='register.php']"));
        registerMenu.click();
        WebElement countryDropDown= driver.findElement(By.xpath("//select[@name='country']"));
        //select class obj ref

        Select select=new Select(countryDropDown);
        //select.selectByVisibleText("INDIA");
        //select.selectByValue("BANGLADESH");
        select.selectByIndex(2);
        List<String> expDropDownValues=new ArrayList<>();
        expDropDownValues.add("ALBANIA");
        expDropDownValues.add("ALGERIA");
        expDropDownValues.add("AMERICAN SAMOA");
        List<WebElement> dropDownObjects=select.getOptions();
        List<String> actDropDownValues=new ArrayList<>();
        for(int i=0;i<dropDownObjects.size();i++){
            actDropDownValues.add(dropDownObjects.get(i).getText());
        }
        System.out.println(actDropDownValues.size());
        System.out.println(actDropDownValues);
    }

   @Test(priority=7)
    public void verifyUploadFile()
   {
       driver.get("https://demo.guru99.com/test/upload/");
       WebElement chooseFile=driver.findElement(By.id("uploadfile_0"));
       chooseFile.sendKeys("C:\\Users\\pc\\Desktop\\desktop\\bhavana desk\\intellij\\sample.txt");
       WebElement termsAccept= driver.findElement(By.id("terms"));
       termsAccept.click();
       System.out.println(termsAccept.isSelected());
       WebElement submit=driver.findElement(By.id("submitbutton"));
       submit.click();
   }
   @Test(priority = 8)
    public void verifySimpleAlert()
   {
       driver.get("https://demoqa.com/alerts");
       WebElement click1=driver.findElement(By.xpath("//button[@id='alertButton']"));
       click1.click();
       Alert alert=driver.switchTo().alert();
       String actualAlertText=alert.getText();
       System.out.println(actualAlertText);
      alert.accept();
   }
   @Test(priority = 9)
    public void verifyConfirmationAlert()
   {
       driver.get("https://demoqa.com/alerts");
       WebElement click2=driver.findElement(By.id("confirmButton"));
       click2.click();
       Alert alert2=driver.switchTo().alert();
       String actualMessageDisplayed=alert2.getText();
       System.out.println(actualMessageDisplayed);
       //alert2.accept();
       alert2.dismiss();
       WebElement confirnText=driver.findElement(By.id("confirmResult"));
       String ctext=confirnText.getText();
       System.out.println(ctext);
   }

   @Test(priority = 10)
    public void verfityPromptAlert()
   {
       driver.get("https://demoqa.com/alerts");
       WebElement click3=driver.findElement(By.id("promtButton"));
       click3.click();
       Alert alert3=driver.switchTo().alert();
       System.out.println(alert3.getText());
       alert3.sendKeys("testing");
       alert3.accept();
       WebElement promptmessage=driver.findElement(By.id("promptResult"));
       System.out.println(promptmessage.getText());

   }
}

