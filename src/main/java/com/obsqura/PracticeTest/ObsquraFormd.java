package com.obsqura.PracticeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ObsquraFormd {
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
    public void setUp() {
        testIntialise("Chrome");
    }

    @AfterMethod
    public void tearDown() {
        //driver.close();
    }

    @Test(priority = 1)
    public void inputForm() {
        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
        WebElement message1 = driver.findElement(By.id("single-input-field"));
        message1.sendKeys("bhavana here");
        WebElement message1Submit = driver.findElement(By.id("button-one"));
        message1Submit.click();
        WebElement getMessage = driver.findElement(By.id("message-one"));
        String displayedMessage = getMessage.getText();
        System.out.println(displayedMessage);
        WebElement number1 = driver.findElement(By.id("value-a"));
        number1.sendKeys("25");
        WebElement number2 = driver.findElement(By.xpath("//input[@id='value-b']"));
        number2.sendKeys("25");
        WebElement total = driver.findElement(By.id("button-two"));
        total.click();
        WebElement totalDisplayed = driver.findElement(By.id("message-two"));
        String t = totalDisplayed.getText();
        System.out.println(t);

    }

    @Test(priority = 2)
    public void checkBox() {
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        WebElement checkbox1 = driver.findElement(By.id("gridCheck"));
        checkbox1.click();
        boolean box = checkbox1.isSelected();
        System.out.println(box);
        multipleCheckbox("Check Box One", "Check Box Three");

    }

    public void multipleCheckbox(String option1, String option2) {
        List<WebElement> checkbox2 = driver.findElements(By.xpath("//input[@class='check-box-list']/following-sibling::label"));
        for (int i = 0; i < checkbox2.size(); i++) {
            String val = checkbox2.get(i).getText();
            if (val.equals(option1)) {
                checkbox2.get(i).click();
            }
            if (val.equals(option2)) {
                checkbox2.get(i).click();
            }
        }
    }

    @Test(priority = 3)
    public void selectRadioButton() {
        driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
        WebElement radioDemo1 = driver.findElement(By.id("inlineRadio1"));
        WebElement radioDemo2 = driver.findElement(By.id("inlineRadio2"));
        radioDemo2.click();
        System.out.println(radioDemo1.isSelected());
        System.out.println(radioDemo2.isSelected());
        WebElement showValue = driver.findElement(By.id("button-one"));
        showValue.click();
        WebElement radioDemoMessage = driver.findElement(By.xpath("//div[@id='message-one']"));
        String message1 = radioDemoMessage.getText();
        System.out.println(message1);
        groupRadioButton("Female");
        groupRadioButton("19 t0 44");


    }

    public void groupRadioButton(String selection) {
        List<WebElement> radio = driver.findElements(By.xpath("//input[@type='radio']/following-sibling::label"));
        for (int i = 0; i < radio.size(); i++) {
            String value = radio.get(i).getText();
            if (value.equals(selection)) {
                radio.get(i).click();

            }
        }
    }

    @Test(priority = 4)
    public void verifyDropDown() {
        driver.get("https://demo.guru99.com/selenium/newtours/register.php");
        WebElement dropDownElmnt = driver.findElement(By.xpath("//select[@name='country' and @size='1']"));
        Select dropDownSelect = new Select(dropDownElmnt);

        //expected dropdown
        List<String> expDropDwn = new ArrayList<>();
        expDropDwn.add("ALBANIA");
        expDropDwn.add("ALGERIA");
        expDropDwn.add("AMERICAN SAMOA");

        List<WebElement> dropDownSelectOptions = dropDownSelect.getOptions();
        List<String> actDropDown = new ArrayList<>();
        for (int i = 0; i < dropDownSelectOptions.size(); i++) {
            actDropDown.add(dropDownSelectOptions.get(i).getText());
        }
        for(int a=0;a<expDropDwn.size();a++){
            for (int b=0;b<actDropDown.size();b++){
                if(a==b){
                    Assert.assertEquals(actDropDown.get(a),expDropDwn.get(b),"ERROR::Invalid value");
                    System.out.println(expDropDwn);
                    System.out.println(actDropDown);
                }
            }
        }
    }
}
