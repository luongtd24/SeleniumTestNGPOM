package com.luongtd.thuchanh;

import com.luongtd.common.BaseTest;
import com.luongtd.locators.LocatorCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.temporal.ChronoUnit;

public class AddnewCustomer extends BaseTest {
    @Test
    public void testAddNewCustomer() {
        String CompanyName = "Selenium LG";
        driver.get("https://crm.anhtester.com/admin/authentication");
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLoginPage)).isDisplayed(), "Khong phai trang Login");
        driver.findElement(By.xpath(LocatorCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCRM.buttonLogin)).click();
        sleep(1);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(), "Khong den duoc trang Dashboard");

        //Add new Customer va kiem tra xem giao dien hien thi dung khong
        driver.findElement(By.xpath(LocatorCRM.menuCustomers)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).isDisplayed(), "Khong den duoc trang Customer");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).getText(), "Customers Summary", "Khong den duoc trang Customer");
        sleep(2);

        driver.findElement(By.xpath(LocatorCRM.buttonAddNewCustomer)).click();
        driver.findElement(By.xpath(LocatorCRM.inputCompanyName)).sendKeys(CompanyName);
        driver.findElement(By.xpath(LocatorCRM.inputVatNumber)).sendKeys("10");
        driver.findElement(By.xpath(LocatorCRM.inputPhone)).sendKeys("0987654321");
        driver.findElement(By.xpath(LocatorCRM.inputWebsite)).sendKeys("https://anhtester.com");
        driver.findElement(By.xpath(LocatorCRM.dropdownGroups)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchGroup)).sendKeys("a");
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchGroup)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(LocatorCRM.dropdownGroups)).click();
        sleep(1);

        driver.findElement(By.xpath(LocatorCRM.dropdownCurrency)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchCurrency)).sendKeys("USD", Keys.ENTER);
        sleep(2);
        driver.findElement(By.xpath(LocatorCRM.dropdownCurrency)).click();

        driver.findElement(By.xpath(LocatorCRM.dropdownLanguage)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.optionVietnamese)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputAddress)).sendKeys("Ha Noi");
        driver.findElement(By.xpath(LocatorCRM.inputCity)).sendKeys("Ha Noi");
        driver.findElement(By.xpath(LocatorCRM.inputState)).sendKeys("Ha Noi");
        driver.findElement(By.xpath(LocatorCRM.inputZipCode)).sendKeys("111");
        driver.findElement(By.xpath(LocatorCRM.buttonCountry)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchCountry)).sendKeys("Vietnam");
        driver.findElement(By.xpath(LocatorCRM.inputSearchCountry)).sendKeys(Keys.ENTER);
        sleep(2);
        driver.findElement(By.xpath(LocatorCRM.buttonSave)).click();    //NewformADDnew

        //Search lai Customer vua Add New
        driver.findElement(By.xpath(LocatorCRM.menuCustomers)).click();
        driver.findElement(By.xpath(LocatorCRM.inputSearchCustomers)).sendKeys(CompanyName);
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchCustomers)).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.firstItemCustomersOnTable)).isDisplayed(),"Khoong tim thay Customers");
        sleep(3);

        //Kiem tra gia tri sau khi add new
        SoftAssert softAssert = new SoftAssert();
        driver.findElement(By.xpath(LocatorCRM.firstItemCustomersOnTable)).click();
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputCompanyName)).getAttribute("value"),CompanyName , "Gia tri Customer khong dung");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputVatNumber)).getAttribute("value"), "10", "Gia tri VAT khong dung");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputPhone)).getAttribute("value"),"0987654321","Gia tri Phone khong dung");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputWebsite)).getAttribute("value"),"https://anhtester.com","Gia tri Website khong dung");

        softAssert.assertAll();
    }
}