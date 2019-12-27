package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.goTo().returnToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("John", "Johnson", "test1")); }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper(). selectContact(before - 1);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Robert", "Stivenson","test1"), false);
    app.getContactHelper().submitContactModification();
    app.goTo().returnToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);

  }
}
