package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper {
  private WebDriver wd;

  public GroupHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void returnToHomePage() {
    wd.findElement(By.linkText("home")).click();
  }

  public void submitNewGroupCreation() {

    click("submit");
  }

  private void click(String locator) {
    wd.findElement(By.name(locator)).click();
  }

  public void fillGroupForm(GroupData groupData) {
    type("group_name", groupData.getName());
    type("group_header", groupData.getHeader());
    type("group_footer", groupData.getFooter());
  }

  private void type(String locator, String text) {
    click(locator);
    wd.findElement(By.name(locator)).clear();
    wd.findElement(By.name(locator)).sendKeys(text);
  }

  public void initGroupCreation() {
    click("new");
    click("group_name");
    wd.findElement(By.name("group_name")).clear();
  }

  public void deleteSelectedGroup() {
    click("delete");
  }

  public void selectGroup() {
    click("selected[]");
  }
}
