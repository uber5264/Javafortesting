package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().returnToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("John", "Johnson", "Jojnson",
              "JJonson", "Mr.", "super Big company",
              "Russia, St Petersburgh", "123-56-67", "john.johnson@rambler.ru",
              "www.homepage.ru", "1985", "February", "2", "2", "February",
              "2015", "test1"), true);
    app.getNavigationHelper().returnToHomePage(); }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Robert", "Stivenson", "Jojnson",
            "JJonson", "Mr.", "super Big company",
            "Russia, St Petersburgh", "123-56-67", "john.johnson@rambler.ru",
            "www.homepage.ru", "1985", "February", "2", "2", "February",
            "2015", null), false);
    app.getContactHelper().submitContactModification();
  }
}
