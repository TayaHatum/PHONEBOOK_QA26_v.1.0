package com.telran.tests;

import com.telran.model.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLogined()) {
            app.getUser().login();
        }
    }

    @Test
    public void addContactTest() throws InterruptedException {
        app.getContact().clickContactButton();

        app.getContact().pause(1000);
        int contactSize = app.getContact().getContactSize();
        if(contactSize >= 2){
            app.getContact().clearContacts();
            //app.getContact().clearContactsWeb();
        }



        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String name = "Lola" + i;
        String lastName = "Doe" + i;
        String email = "lola" + i + "@maul.com";
        String phone = "9778111" + i;
        String address = "Tel Aviv"+i;
        String desc = "My new contact";


        app.getContact().clickAddButton();
        app.getContact().pause(2000);
        app.getContact().fillContactForm(new Contact().withName(name).withLastName(lastName)
         .withEmail(email).withPhone(phone).withAddress(address).withDescription(desc));



        app.getContact().clickSaveBatton();
        app.getContact().pause(2000);
        Assert.assertTrue(app.getContact().isNameExist(name));

    }
}
