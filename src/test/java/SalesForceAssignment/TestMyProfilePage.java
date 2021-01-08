package SalesForceAssignment;

import SalesForceAssignmentPages.MyProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TestMyProfilePage extends BaseTest{
          MyProfilePage profileobj;
    @Test(priority = 1)
    public void verifyMyProfile() throws InterruptedException {
     profileobj=home.myProfile();
     System.out.println(profileobj.getTitle());
    }
    @Test(priority = 2)
    public void verifyclickOnedditLink() throws InterruptedException {
        profileobj.clickOnedditLink();
    }
}

