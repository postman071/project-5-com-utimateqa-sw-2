package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest
{
    String baseUrl="https://courses.ultimateqa.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully()
    {
        String expectedMessage = "Welcome Back!";
        //element to click on sign in link
        //li[@ class='header__nav-item header__nav-sign-in']
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']//a")).click();
        //element to get message
        WebElement getMessage = driver.findElement(By.xpath("//h2[@class='page__heading']"));
        String actualMessage = getMessage.getText();
        //verification of actual and expected message
        Assert.assertEquals("fail to get message",expectedMessage,actualMessage);
    }
    @Test
    public void verifyTheErrorMessage()
    {
        // Element to click on Sign in link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']//a")).click();
        //Element to enter invalid username
        driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("admin123@gmail.com");
        //Element to enter invalid password
        driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys("Admin123");
        //Element to click on Login button
        driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']")).click();
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String expectedMessage = "Invalid email or password.";
        String actualMessage = getMessage.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to click on login button", expectedMessage, actualMessage);
    }
    @After
    public void tearDown()
    {
        driver.quit();
    }
}

