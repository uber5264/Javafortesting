package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.goTo().returnToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("John", "Johnson", "test1")); }

    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper(). selectContact(before.size() - 1);
    app.getContactHelper().initContactModification();
    ContactData contact  = new ContactData(
            before.get(before.size() - 1).getId(), "Robert", "Stivenson","test1");
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.goTo().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));

  }
}
