package com.luongtd.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void createBrowser() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manager().window().maximize();
        driver.manager().timeout().implicitlyWait(Duration.ofSeconds(10));
        driver.manager().timeout().pageLoadTimeout(Duration.ofSeconds(10));
    }
        public void creatBrowser (String BrowserName){
            System.setProperty("webdriver.http.factory", "jdk-http-client");

            if (browserName.equals("chrome")) {
                driver = new ChromeDriver();
            }
            if (browserName.equals("edge")) {
                driver = new EdgeDriver();
            }
            if (browserName.equals("fireFox")) {
                driver = new FirefoxDriver();
            }

            driver.manager().window().maximize();
            driver.manager().timeout().implicitlyWait(Duration.ofSeconds(10));
            driver.manager().timeout().pageLoadTimeout(Duration.ofSeconds(10));
        }


        @AfterMethod
        public void closeBrowser () {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            driver.quit();
        }
        public void sleep ( double second){
            try {
                Thread.sleep((long) (1000 * second));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

}
