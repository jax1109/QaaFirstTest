package com.example.tests;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Kovalevskyi.I on 11/3/2015.
 */
public class LoginNavi {
        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @Before
        public void setUp() throws Exception {
            driver = new FirefoxDriver();
            baseUrl = "http://localhost:8000/";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @Test
        public void testLoginNavi() throws Exception {
            driver.get(baseUrl + "/dvwa-1.9/login.php");
            driver.findElement(By.name("username")).clear();
            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).sendKeys("password");
            driver.findElement(By.name("Login")).click();
            driver.findElement(By.linkText("Instructions")).click();
            driver.findElement(By.linkText("Brute Force")).click();
            driver.findElement(By.name("username")).clear();
            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).sendKeys("password");
            driver.findElement(By.name("Login")).click();
            driver.findElement(By.name("username")).clear();
            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).sendKeys("password");
            driver.findElement(By.linkText("Command Injection")).click();
            driver.findElement(By.xpath("//li[@onclick=\"window.location='../../vulnerabilities/csrf/'\"]")).click();
            driver.findElement(By.name("password_current")).clear();
            driver.findElement(By.name("password_current")).sendKeys("password");
            driver.findElement(By.linkText("File Inclusion")).click();
            driver.findElement(By.xpath("//li[@onclick=\"window.location='../../vulnerabilities/upload/'\"]")).click();
            driver.findElement(By.linkText("Insecure CAPTCHA")).click();
            driver.findElement(By.xpath("//li[@onclick=\"window.location='../../logout.php'\"]")).click();
            driver.findElement(By.name("username")).clear();
            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).sendKeys("password");
        }

        @After
        public void tearDown() throws Exception {
            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }

        private boolean isElementPresent(By by) {
            try {
                driver.findElement(by);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }

        private boolean isAlertPresent() {
            try {
                driver.switchTo().alert();
                return true;
            } catch (NoAlertPresentException e) {
                return false;
            }
        }

        private String closeAlertAndGetItsText() {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                if (acceptNextAlert) {
                    alert.accept();
                } else {
                    alert.dismiss();
                }
                return alertText;
            } finally {
                acceptNextAlert = true;
            }
        }
    }
