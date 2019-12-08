package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", null, null));
    app.getGroupHelper().submitNewGroupCreation();
    app.getNavigationHelper().goToGroupPage();
    int after = app.getGroupHelper().getGroupCount();
//    app.getNavigationHelper().returnToHomePage();
    Assert.assertEquals(after, before + 1);
//  app.logOut();
  }

}
