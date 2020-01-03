package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactPhoneTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().returnToHomePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("John").withLastName("Johnson").withGroup("test1"));
      app.goTo().returnToHomePage();
    }
  }

  @Test
  public void testContactPhones() {
    app.goTo().returnToHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);


  }



}
