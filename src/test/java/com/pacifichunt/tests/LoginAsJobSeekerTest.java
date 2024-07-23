package com.pacifichunt.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.pacifichunt.base.BaseClass;
import com.pacifichunt.pages.LoginPageForJobSeeker;
import com.pacifichunt.testutil.Utilities;
import com.pacifichunt.userstories.UserStories;

public class LoginAsJobSeekerTest extends BaseClass {

	@Test(priority = Utilities.VERY_HIGH_PRIORITY, enabled = true, description = UserStories.REQUIREMENT_TYPE
			+ UserStories.VALID_LOGIN_SCENARIO + UserStories.VALID_LOGIN_STATEMENT)
	public void verifyValidLoginAsEmployer() {

		Reporter.log(Utilities.VERY_HIGH_PRIORITY_STATEMENT, true);

		LoginPageForJobSeeker login = new LoginPageForJobSeeker(driver);
		login.goToHeaderLoginBtn();
		login.setValidCredentials();
		login.clickLoginButton();
		Assert.assertEquals(LoginPageForJobSeeker.getDashboardText(), LoginPageForJobSeeker.getExpectedDashboardText());
		Reporter.log(Utilities.TEST_PASSED, true);
	}

	@Test(priority = Utilities.MEDIUM_PRIORITY, enabled = true, description = UserStories.REQUIREMENT_TYPE
			+ UserStories.EMPTY_LOGIN_SCENERIO + UserStories.EMPTY_LOGIN_STATEMENT)
	public void verifyEmptyUsernameAndEmptyPassword() {

		Reporter.log(Utilities.MEDIUM_PRIORITY_STATEMENT, true);

		LoginPageForJobSeeker login = new LoginPageForJobSeeker(driver);
		login.goToHeaderLoginBtn();
		login.setEmptyUserNameAndEmptyPasswordCredentials();
		login.clickLoginButton();
		Assert.assertEquals(login.getEmptyEmailText(), login.getExpectedEmptyEmailText());
		Reporter.log(Utilities.TEST_PASSED, true);
	}

}
