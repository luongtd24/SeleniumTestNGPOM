package com.luongtd.Bai11_Assertions;

import com.luongtd.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.basic.BasicButtonUI;

public class DemoHardAssert extends BaseTest {
    @Test
    public void testLoginCrm(){
        driver.get("https://crm.anhtester.com/admin/authentication");

        //Assert cai Header voi cai texxt cua no
        String header = driver.findElement(By.xpath("//h1[normalize-space()='Login']")).getText();
        System.out.println(header);
        Assert.assertEquals(header, "Login","Header sai ");  //So sanh bàng

        boolean checkButtonLogin = driver.findElement(By.xpath("//button[normalize-space()='Login']")).isEnabled();
        Assert.assertTrue(checkButtonLogin,"Nut  login khong duoc bat");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        sleep(1);

        String menuName = driver.findElement(By.xpath("//span[normalize-space()='Customers']")).getText();
        Assert.assertTrue(menuName.contains("Customer"));   // so sanh chua thong qua java
        //Assert.
    }
}
