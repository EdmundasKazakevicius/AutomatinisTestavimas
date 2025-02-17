package JUnit_uzduotis;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
        WebDriver driver = new ChromeDriver();
        driver.get("http://192.168.91.71");

        WebElement signInButton = driver.findElement(By.linkText("Sign in"));
        signInButton.click();

        driver.get("http://192.168.91.71/registration");

        driver.findElement(By.id("field-id_gender-1")).click();

        WebElement eMail = driver.findElement(By.id("field-email"));
        eMail.sendKeys("edmundas.kazakevicius@stud.techin.lt");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("edka_51_C");

        WebElement firstName = driver.findElement(By.id("field-firstname"));
        firstName.sendKeys("Edmundas");

        WebElement lastName = driver.findElement(By.id("field-lastname"));
        lastName.sendKeys("Kazakevicius");

        driver.findElement(By.id("field-birthday")).sendKeys("08/26/1960");

        driver.findElement(By.name("optin")).click();
        driver.findElement(By.name("psgdpr")).click();
        driver.findElement(By.name("newsletter")).click();
        driver.findElement(By.name("customer_privacy")).click();


        //WebElement saveButton = driver.findElement(By.linkText("Save"));
        //saveButton.click();
        //WebElement logoutButton = driver.findElement(By.xpath("//button[contains(text(), 'Logout')]"));
        driver.quit();

    }

    @Test
    void secondTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("http://192.168.91.71");

        WebElement signInButton = driver.findElement(By.linkText("Sign in"));
        signInButton.click();


        WebElement subscriptionField = driver.findElement(By.name("email"));
        subscriptionField.sendKeys("edmundas.kazakevicius@stud.techin.lt");
        WebElement subscriptionButton = driver.findElement(By.name("submitNewsletter"));
        subscriptionButton.click();
        driver.quit();

    }

    @Test
    void thirdTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("http://192.168.91.71");

        WebElement signInButton = driver.findElement(By.linkText("Sign in"));
        signInButton.click();


        WebElement eMail = driver.findElement(By.id("field-email"));
        eMail.sendKeys("edmundas.kazakevicius@stud.techin.lt");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("edka_51_C");

        WebElement signUpButton = driver.findElement(By.id("submit-login"));
        signUpButton.click();


        //   WebElement signOutButton = driver.findElement(By.linkText("Sign out"));

        try {
            WebElement signOutButton = driver.findElement(By.linkText("Sign out"));
            System.out.println("User is logged in.");
        } catch (NoSuchElementException e) {
            System.out.println("User is not logged in.");
        }

        WebElement signOutButton = driver.findElement(By.linkText("Sign out"));
        signOutButton.click();
//        driver.quit();
    }

}

