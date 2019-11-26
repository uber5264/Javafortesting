package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app2.initContactCreation();
    app2.fillContactForm(new ContactData("Johnson", "Johnson", "JJojnson",
            "Mr.", "Super big company", "Russia, St Petersburgh",
            "123-45-67", "john.johnson@rambler.ru", "www.homepage.ru",
            "1985", "February", "2", "2", "February", "2015", "John"));
    app2.submitContactCreation();
    app2.returnToHomePage();
    app2.logOut();
  }

}
