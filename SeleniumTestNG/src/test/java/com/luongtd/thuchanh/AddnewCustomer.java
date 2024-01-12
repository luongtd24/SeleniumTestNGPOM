package com.luongtd.thuchanh;

import com.luongtd.common.BaseTest;
import com.luongtd.locators.LocatorCRM;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddnewCustomer extends BaseTest {
    @Test
    public void testAddNewCustomer() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLoginPage)).isDisplayed(),"Khong phai trang Login");
        driver.findElement(By.xpath(LocatorCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCRM.buttonLogin)).click();
        sleep(1);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(),"Khong den duoc trang Dashboard");

        driver.findElement(By.xpath(LocatorCRM.buttonAddNewCustomer)).click();



    }

}
