package com.telran.tests;

import com.telran.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void loginTest() throws InterruptedException {
        app.getUser().openLogRegForm();
        app.getUser().fillRegLogForm(new User().withEmail("Mon447233@mail.com").withPassword("Mon12$447233"));
        app.getUser().clickLoginButton();
        app.getUser().pause(2000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));
    }

}
