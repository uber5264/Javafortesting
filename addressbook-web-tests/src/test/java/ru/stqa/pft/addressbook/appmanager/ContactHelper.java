package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"),contactData.getLastName());
    if (creation) {
      click(By.name("new_group"));
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Group:'])[1]/following::option[2]"));
      } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
      }
    }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void initContactModification(int id) {
      wd.findElement(By.xpath("//a[@href='edit.php?id=" + id + "']")).click();
    }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='"+ id+ "']")).click();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void goToHomePage() {
    click(By.linkText("home"));
  }

  public void fillContactForm2(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"),contactData.getLastName());
    click(By.name("new_group"));
    new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Group:'])[1]/following::option[1]"));
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm2(contact);
    submitContactCreation();
    contactCashe = null;
    goToHomePage();
  }

  public void modify(ContactData contact) {
    initContactModification(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCashe = null;
    goToHomePage();
  }

  public void delete(int index) {
    selectContact(index);
    deleteSelectedContact();
    contactCashe = null;
    goToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    contactCashe = null;
    goToHomePage();

  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
    goToHomePage();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
     for (WebElement element : elements) {
       List<WebElement> cells = element.findElements(By.tagName("td"));
       String lName = cells.get(1).getText();
       String fName = cells.get(2).getText();
       int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
       contacts.add(new ContactData().withId(id).withFirstName(fName).withLastName(lName));
    }
    return contacts;
  }

  public Contacts contactCashe = null;

  public Contacts all() {
    if (contactCashe !=null) {
      return new Contacts(contactCashe);
    }
    contactCashe = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String lName = cells.get(1).getText();
      String fName = cells.get(2).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCashe.add(new ContactData().withId(id).withFirstName(fName).withLastName(lName));
    }
    return new Contacts(contactCashe);
  }


}
