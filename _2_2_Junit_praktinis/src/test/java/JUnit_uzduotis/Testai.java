package JUnit_uzduotis;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Testai {
    WebDriver driver;
    WebElement inputUsername;

    @Test
    void firstTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.saucedemo.com/");
//        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String text = driver.findElement(By.cssSelector(".app_logo")).getText();
//        System.out.println(text);
        String expected = "Swag Labs";
        assertEquals(expected, text);

        WebElement link = driver.findElement((By.cssSelector(".shopping_cart_link")));
        assertTrue(link.isDisplayed());

        // driver.quit();
    }

    @Test
    void secondTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.saucedemo.com/");
//        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("wrong_password");
        driver.findElement(By.id("login-button")).click();

        WebElement error = driver.findElement(By.cssSelector(".error-message-container.error"));

        assertEquals("Epic sadface: Username and password do not match any user in this service", error.getText());

        // driver.quit();
    }

    @Test
    void thirdTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.saucedemo.com/");
//        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement error = driver.findElement(By.cssSelector(".error-message-container.error"));

//        assertEquals("this user has been locked out", error.getText());

        Assertions.assertTrue(error.getText().contains("this user has been locked out"));

        // driver.quit();
    }

    @BeforeEach
    void init() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        inputUsername = driver.findElement(By.id("user-name"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/logins.csv", numLinesToSkip = 1)
    void testWithCsvFileSourceFromFile(String username, String password) {
        assertNotNull(username);
        assertNotEquals(null, password);
    }

}
