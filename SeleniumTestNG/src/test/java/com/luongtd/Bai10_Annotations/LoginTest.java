package com.luongtd.Bai10_Annotations;

import com.luongtd.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
        @Test
    public void testLogin(){
            driver.get("https://www.24h.com.vn/");
        }
}
