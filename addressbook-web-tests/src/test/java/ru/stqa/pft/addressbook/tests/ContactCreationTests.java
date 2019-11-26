package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Johnson", "Johnson", "JJojnson",
            "Mr.", "Super big company", "Russia, St Petersburgh",
            "123-45-67", "john.johnson@rambler.ru", "www.homepage.ru",
            "1985", "February", "2", "2", "February", "2015", "John"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    app.logOut();
  }

}
