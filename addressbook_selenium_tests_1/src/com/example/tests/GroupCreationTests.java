package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	  app.getNavigationHelper().openMainPage();
	  app.getNavigationHelper().gotoGroupsPage();
	  app.getGroupHelper().initGroupCreation();
	  GroupData group = new GroupData();
	  group.name = "group_1";
	  group.header = "header_1";
	  group.footer = "footer_1";
	  app.getGroupHelper().fillGroupForm(group);
	  app.getCommonHelper().submitData();
	  app.getGroupHelper().returnToGroupsPage();
  }
  
  /*@Test
  public void testEmptyGroupCreation() throws Exception {
	  openMainPage();
	  gotoGroupsPage();
	  initGroupCreation();
	  fillGroupForm(new GroupData("", "", ""));
	  submitGroupCreation();
	  returnToGroupsPage();
  }*/
}
