package com.luongtd.Bai12_ActionsClass;

import com.luongtd.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Bai12_DemoActionsClass extends BaseTest {
    @Test
    public void TestPressEnterKey()  {

        //driver kế thừa từ class SetupBrowser
        driver.get("https://www.google.com/");

        // Element search box
        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));

        // Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        // Dùng action để gọi hàm sendkeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(element, "Anh Tester").pause(2).sendKeys(Keys.ENTER).build().perform();
//        sleep(2);
//        action.sendKeys(Keys.ENTER).perform();

        sleep(2);

        // Get element title of page
        WebElement elementTitlePage = driver.findElement(By.xpath("(//h3[contains(text(),'Anh Tester Automation Testing')])[2]"));

        // Gọi hàm click để click element trên
        action.click(elementTitlePage).perform();
        sleep(3);
    }
    @Test
    public void doubleClick() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://anhtester.com/");
        sleep(2);
        WebElement element = driver.findElement(By.xpath("(//h2[@class='section__title'])[1]"));

        Actions action = new Actions(driver);

        action.doubleClick(element).perform();
        sleep(2);
    }

    @Test
    public void contextClick (){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://anhtester.com/");
        sleep(3);

        WebElement element = driver.findElement(By.xpath(""))

    }


}
