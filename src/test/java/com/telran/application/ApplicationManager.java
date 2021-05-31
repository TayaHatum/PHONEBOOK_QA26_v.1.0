package com.telran.application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    UserHelper user;
    ContactHelper contact;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public UserHelper getUser() {
        return user;
    }

    public void start() {
        if(browser.equals(BrowserType.CHROME)){
        wd=new ChromeDriver();
        }else if (browser.equals(BrowserType.FIREFOX)){
            wd =new FirefoxDriver();
        }

        wd.get("https://contacts-app.tobbymarshall815.vercel.app/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        user= new UserHelper(wd);
        contact =new ContactHelper(wd);
    }

    public  void stop() {
        wd.quit();
    }
}
