package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {
  
  @Test(dataProvider = "randomValidGroupGenerator")
  public void testNonEmptyGroupCreation(GroupData group) throws Exception {
	  app.getNavigationHelper().openMainPage();
	  app.getNavigationHelper().gotoGroupsPage();
	  
	  //save old state
	  List<GroupData> oldList = app.getGroupHelper().getGroups();
	  
	  //actions
	  app.getGroupHelper().initGroupCreation();
	  app.getGroupHelper().fillGroupForm(group);
	  app.getCommonHelper().submitData("submit");
	  app.getGroupHelper().returnToGroupsPage();
	  
	  //save new state
	  List<GroupData> newList = app.getGroupHelper().getGroups();

	  // compare states
	  //assertEquals(newList.size(), oldList.size() + 1);
	  
	  oldList.add(group);
	  Collections.sort(oldList);
	  assertEquals(newList, oldList);
  }
}
