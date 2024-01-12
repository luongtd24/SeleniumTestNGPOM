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

        WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-7']//h2[@class='section__title'][contains(text(),'Anh Tester')]"));
        Actions actions = new Actions(driver);

        actions.contextClick(element).perform();
        sleep(2);

    }
    @Test
    public void moveToElement(){
        driver.get("https://anhtester.com/");
        sleep(2);
        WebElement element = driver.findElement(By.xpath("//a[@id='btn-login']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        sleep(2);
    }

    @Test
    public void demoDragandDropWithActionClass(){
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        sleep(2);
        WebElement From = driver.findElement(By.xpath("(//div[contains(text(),'Stockholm')])[2]"));
        sleep(2);
        WebElement To = driver.findElement(By.xpath("(//div[normalize-space()='Norway'])[1]"));
        sleep(2);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(From, To).perform();
        sleep(2);
    }
    @Test
    public void inputTextUppercase() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//*[@name='q']"));
        element.click();

        Actions action = new Actions(driver);

        // Đè giữ phím SHIFT và nhập text -> Chữ in hoa
        action.keyDown(element, Keys.SHIFT).sendKeys("anh tester").build().perform();

        Thread.sleep(2000);
    }
    @Test
    public void copyAndPate(){
        driver.get("https://anhtester.com/");
        sleep(2);

        WebElement element1 = driver.findElement(By.xpath("(//input[@placeholder='Tìm kiếm khóa học . . .'])[1]"));
        element1.click();
        WebElement element2 = driver.findElement(By.xpath("(//input[@placeholder='Bạn muốn học gì?'])[1]"));
        sleep(3);
        Actions actions = new Actions(driver);

        actions.sendKeys("Nam 2024").perform();
        sleep(2);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        sleep(1);
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        sleep(1);

        element2.click();
        sleep(1);
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        sleep(3);



    }
}
