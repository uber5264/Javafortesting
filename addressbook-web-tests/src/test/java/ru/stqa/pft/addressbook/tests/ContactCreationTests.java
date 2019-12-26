package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    int before = app.getContactHelper().getContactCount();

    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("John", "Johnson", "Jojnson",
            "JJonson", "Mr.", "super Big company",
            "Russia, St Petersburgh", "123-56-67", "john.johnson@rambler.ru",
            "www.homepage.ru", "1985", "February", "2", "2", "February",
            "2015", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.goTo().returnToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before +1);

  }

}
