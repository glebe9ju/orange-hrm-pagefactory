package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.AdminPage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.pages.ViewSystemUsersPage;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UsersTest extends TestBase {
    LoginPage loginPage;
    AdminPage adminPage;
    ViewSystemUsersPage viewSystemUsersPage;


    @BeforeMethod
    public void inIt() {
        loginPage = new LoginPage();
        adminPage = new AdminPage();
        viewSystemUsersPage = new ViewSystemUsersPage();

    }

    @Test
    public void adminShouldAddUserSuccessFully() {
        loginPage.enterUser("Admin");
        loginPage.enterPass("admin123");
//Login to Application
        loginPage.clickOnLogIn();
//click On "Admin" Tab
        loginPage.clickOnAdmin();
//Verify "System Users" Text
        String expected = "System Users";
        String actual = loginPage.verifysystemUser();
        Assert.assertEquals(actual, expected, "not displayed");
//click On "Add" button
        loginPage.clickOnAdd();
//Verify "Add User" Text
        String expectedResult = "Add User";
        String actualResult = loginPage.verifyAddUser();
        Assert.assertEquals(actualResult, expectedResult, "not displayed");
//Select User Role "Admin"
        loginPage.selectUserRole("Admin");
//enter Employee Name "Ananya Dash"
        loginPage.enterEmployeeName("Ananya Dash");
//enter Username
        loginPage.enterUserName("Ananya Dash");
//Select status "Disable"
        loginPage.selectStatus("Disabled");
//enter psaaword
        loginPage.enterPassWord("AnaNya123");
//enter Confirm Password
        loginPage.enterConfirmPass("AnaNya123");
//click On "Save" Button
        loginPage.clickOnSave();
//verify message "Successfully Saved"

    }
    @Test
    public void searchTheUserCreatedAndVerifyIt(){
        loginPage.enterUser("Admin");
        loginPage.enterPass("admin123");
//Login to Application
        loginPage.clickOnLogIn();
//click On "Admin" Tab
        loginPage.clickOnAdmin();
//Verify "System Users" Text
        String expected = "System Users";
        String actual = loginPage.verifysystemUser();
        Assert.assertEquals(actual, expected, "not displayed");
        //Enter Username
        adminPage.enterSysterUserName("Ananayee Dash");
        //Select User Role
        adminPage.selectSystemUserRole("Admin");
        //Select Satatus
        adminPage.selectSystemStatus("Disabled");
        //Click on "Search" Button
        adminPage.clickOnSearch();
        //Verify the User should be in Result list.
    }
    @Test
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() {
        loginPage.enterUser("Admin");
        loginPage.enterPass("admin123");
        //Login to Application
        loginPage.clickOnLogIn();
        //click On "Admin" Tab
        loginPage.clickOnAdmin();
        //Verify "System Users" Text
        String expected = "System Users";
        String actual = loginPage.verifysystemUser();
        Assert.assertEquals(actual, expected, "not displayed");
        //Enter Username
        adminPage.enterSysterUserName("Ananayee Dash");
        //Select User Role
        adminPage.selectSystemUserRole("Admin");
        //Select Satatus
        adminPage.selectSystemStatus("Disabled");
        //Click on "Search" Button
        adminPage.clickOnSearch();
                //Click on Check box
        adminPage.clickOnCheckBox();
        //Click on Delete Button
        adminPage.clickOnDelete();
        //Popup will display
        //Click on Ok Button on Popup
        adminPage.ClickOnpopupOk();
       //verify message "Successfully Deleted"


    }
 @Test(priority = 1,groups = {"smoke","regression"})
        public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound(){
     loginPage.enterUser("Admin");
     loginPage.enterPass("admin123");
     //Login to Application
     loginPage.clickOnLogIn();
     //click On "Admin" Tab
     loginPage.clickOnAdmin();
     //Verify "System Users" Text
     String expected = "System Users";
     String actual = loginPage.verifysystemUser();
     Assert.assertEquals(actual, expected, "not displayed");
     //Enter Username
     adminPage.enterSysterUserName("Ananayee Dash");
     //Select User Role
     adminPage.selectSystemUserRole("Admin");
     //Select Satatus
     adminPage.selectSystemStatus("Disabled");
     //Click on "Search" Button
     adminPage.clickOnSearch();
     //verify message "No Records Found
     String expectedRes = "No Records Found";
     String actualRes = viewSystemUsersPage.verifyNoRecordFound();
     Assert.assertEquals(actualRes,expectedRes,"message not displayed");
 }

}
