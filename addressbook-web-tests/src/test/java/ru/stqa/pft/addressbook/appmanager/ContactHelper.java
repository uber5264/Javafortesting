package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    //type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"),contactData.getLastName());
    //type(By.name("nickname"),contactData.getNickName());
    //type(By.name("title"), contactData.getTitle());
    //type(By.name("company"), contactData.getCompanyName());
    //type(By.name("address"), contactData.getAddress());
    //type(By.name("mobile"), contactData.getMobilePhone());
    //type(By.name("email"), contactData.getEmail());
    //type(By.name("homepage"), contactData.getHomePage());
    //click(By.name("bday"));
    //new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getbDay());
    //click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[4]"));
    //click(By.name("bmonth"));
    //new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getbMonth());
    //click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[36]"));
    //type(By.name("byear"), contactData.getbYear());
    //click(By.name("aday"));
    //new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contactData.getaDay());
    //click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Anniversary:'])[1]/following::option[4]"));
    //click(By.name("amonth"));
    //new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contactData.getaMonth());
    //click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Anniversary:'])[1]/following::option[36]"));
    //type(By.name("ayear"), contactData.getaYear());

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

  public void initContactModification() {click(By.xpath("//img[@alt='Edit']"));  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }
  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void goToHomePage() {
    click(By.linkText("home"));
  }

  public void fillContactForm2(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    //type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"),contactData.getLastName());
    //type(By.name("nickname"),contactData.getNickName());
    //type(By.name("title"), contactData.getTitle());
    //type(By.name("company"), contactData.getCompanyName());
    //type(By.name("address"), contactData.getAddress());
    //type(By.name("mobile"), contactData.getMobilePhone());
    //type(By.name("email"), contactData.getEmail());
    //type(By.name("homepage"), contactData.getHomePage());
    //click(By.name("bday"));
    //new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getbDay());
    //click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[4]"));
    //click(By.name("bmonth"));
    //new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getbMonth());
    //click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[36]"));
    //type(By.name("byear"), contactData.getbYear());
    //click(By.name("aday"));
    //new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contactData.getaDay());
    //click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Anniversary:'])[1]/following::option[4]"));
    //click(By.name("amonth"));
    //new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contactData.getaMonth());
    //click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Anniversary:'])[1]/following::option[36]"));
    //type(By.name("ayear"), contactData.getaYear());
    click(By.name("new_group"));
    new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Group:'])[1]/following::option[1]"));
  }

  public void createContact(ContactData contact) {
    initContactCreation();
    fillContactForm2(contact);
    submitContactCreation();
    goToHomePage();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//form[./input[@name='entry']]"));
    for (WebElement element : elements) {
      String name = element.getText();
      ContactData contact = new ContactData(name,null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
