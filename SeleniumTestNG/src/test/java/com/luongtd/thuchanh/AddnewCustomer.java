package com.luongtd.thuchanh;

import com.luongtd.common.BaseTest;
import com.luongtd.keywords.ActionKeywords;
import com.luongtd.locators.LocatorCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.temporal.ChronoUnit;

public class AddnewCustomer extends BaseTest {
    String CompanyName = "Selenium LG";

    public void loginCRM(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLoginPage)).isDisplayed(), "Header khong ton tai, Khong phai trang Login");
//        driver.findElement(By.xpath(LocatorCRM.inputEmail)).sendKeys("admin@example.com");
//        driver.findElement(By.xpath(LocatorCRM.inputPassword)).sendKeys("123456");
//        driver.findElement(By.xpath(LocatorCRM.buttonLogin)).click();

        setText(LocatorCRM.inputEmail, "admin@example.com");
        setText(LocatorCRM.inputPassword, "123456");
        clickElement(LocatorCRM.buttonLogin);
        sleep(1);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(), "Khong den duoc trang Dashboard");
    }


    @Test
    public void testAddNewCustomer() {
        // Khoi tao doi tuong class cho ActionsKeywords de nhan gia tri driver
        loginCRM();
        new ActionKeywords(driver);

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

    @Test
    public void addNewContactForCustomer(){
     loginCRM();
     driver.findElement(By.xpath(LocatorCRM.menuCustomers)).click();
     Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).isDisplayed(), "Khong den duoc trang Customer");
     Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).getText(), "Customers Summary", "Khong den duoc trang Customer");
     sleep(2);

    //Search lai Customer vua Add New
    driver.findElement(By.xpath(LocatorCRM.menuCustomers)).click();
    driver.findElement(By.xpath(LocatorCRM.inputSearchCustomers)).sendKeys(CompanyName);
    sleep(1);
    Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.firstItemCustomersOnTable)).isDisplayed(),"Khoong tim thay Customers");
    driver.findElement(By.xpath(LocatorCRM.firstItemCustomersOnTable)).click();

    driver.findElement(By.xpath(LocatorCRM.menuContact)).click();
    sleep(1);
    Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerContactPage)).isDisplayed(), "Không tìm thấy trang Contact.");
    driver.findElement(By.xpath(LocatorCRM.buttonAddNewContact)).click();
    sleep(2);
    Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerAddNewContactDialog)).isDisplayed(), "Không tìm thấy dialog Add New Contact.");
    sleep(1);
    //Upload file for Profile image
    driver.findElement(By.xpath(LocatorCRM.inputProfileImage)).sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\datatest\\photo_2023-06-22_22-17-58.jpg");
    sleep(2);


    }
}