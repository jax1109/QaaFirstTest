package com.example.tests;

/**
 * Created by Kovalevskyi.I on 11/3/2015.
 */
    import java.util.regex.Pattern;
    import java.util.concurrent.TimeUnit;
    import org.junit.*;
    import static org.junit.Assert.*;
    import static org.hamcrest.CoreMatchers.*;
    import org.openqa.selenium.*;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.support.ui.Select;

    public class Upload {
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
        public void testUpload() throws Exception {
            driver.get(baseUrl + "/dvwa-1.9/login.php");
            driver.findElement(By.name("username")).clear();
            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).sendKeys("password");
            driver.findElement(By.name("Login")).click();
            driver.findElement(By.xpath("//li[@onclick=\"window.location='vulnerabilities/upload/'\"]")).click();
            driver.findElement(By.name("uploaded")).clear();
            driver.findElement(By.name("uploaded")).sendKeys("C:\\Users\\kovalevskyi.i\\Desktop\\images\\test DAta\\01.jpg");
            driver.findElement(By.name("Upload")).click();
//            driver.findElement(By.linkText("*.jpg")).click();
            driver.findElement(By.linkText("Logout")).click();
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
