package com.telran.tests;

import com.telran.model.Contact;
import com.telran.model.LomBokStyle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase {

    @BeforeMethod (alwaysRun = true)
    public void ensurePrecondition() {
        if (!app.getUser().isLogined()) {
            app.getUser().login();
        }
    }




    @Test (groups = {"rest"})
    public void addContactTestRest() {
        app.getContact().clickContactButton();
        int contactSize = app.getContact().getContactSize();
        if(contactSize >= 2){
            app.getContact().clearContacts();

        }



        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String name = "Lola" + i;
        String lastName = "Doe" + i;
        String email = "lola" + i + "@mail.com";
        String phone = "9778111" + i;
        String address = "Tel Aviv"+i;
        String desc = "My new contact";


        app.getContact().clickAddButton();
        app.getContact().fillContactForm(new Contact().withName(name).withLastName(lastName)
         .withEmail(email).withPhone(phone).withAddress(address).withDescription(desc));
        app.getContact().clickSaveBatton();
        Assert.assertTrue(app.getContact().isNameExist(name));

    }

    @Test (groups = {"web","rest"},priority = 1)
    public void addContactTestWeb() throws InterruptedException {
        app.getContact().clickContactButton();
        int contactSize = app.getContact().getContactSize();
        if(contactSize >= 2){

           app.getContact().clearContactsWeb();
        }



        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String name = "Lola" + i;
        String lastName = "Doe" + i;
        String email = "lola" + i + "@mail.com";
        String phone = "9778111" + i;
        String address = "Tel Aviv"+i;
        String desc = "My new contact";


        app.getContact().clickAddButton();
        app.getContact().fillContactForm(new Contact().withName(name).withLastName(lastName)
                .withEmail(email).withPhone(phone).withAddress(address).withDescription(desc));
        app.getContact().clickSaveBatton();

        Assert.assertTrue(app.getContact().isNameExist(name));

    }

    public void useLomBokStyle(){

        //LomBokStyle style =LomBokStyle.builder().name("Lom").lname("Bok").build();
    }
}