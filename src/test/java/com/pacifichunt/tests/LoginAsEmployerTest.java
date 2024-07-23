package com.pacifichunt.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pacifichunt.base.BaseClass;
import com.pacifichunt.pages.LoginPage;
import com.pacifichunt.testutil.Utilities;
import com.pacifichunt.userstories.UserStories;

public class LoginAsEmployerTest extends BaseClass {

	@Test(priority = Utilities.VERY_HIGH_PRIORITY, enabled = false, description = UserStories.REQUIREMENT_TYPE
			+ UserStories.VALID_LOGIN_SCENARIO + UserStories.VALID_LOGIN_STATEMENT)
	public void verifyValidLoginAsEmployer() {

		Reporter.log(Utilities.VERY_HIGH_PRIORITY_STATEMENT, true);

		LoginPage login = new LoginPage(driver);
		login.goToHeaderLoginBtn();
		login.goToLoginAsEmployer();
		login.setValidCredentials();
		login.clickLoginButton();
		Assert.assertEquals(LoginPage.getDashboardText(), LoginPage.getExpectedDashboardText());
		Reporter.log(Utilities.TEST_PASSED, true);
	}

	// using data provider for multiple login scenario

	@Test(priority = Utilities.MEDIUM_PRIORITY, enabled = true, description = UserStories.REQUIREMENT_TYPE
			+ UserStories.EMPTY_LOGIN_SCENERIO
			+ UserStories.EMPTY_LOGIN_STATEMENT, dataProvider = "CheckLoginMultipleScenarios")
	public void verifyMultipleLoginScenario(String email, String password) {

		Reporter.log(Utilities.MEDIUM_PRIORITY_STATEMENT, true);

		LoginPage login = new LoginPage(driver);
		login.goToHeaderLoginBtn();
		login.goToLoginAsEmployer();
		login.checkLoginScenariosWithParameters(email, password);
		login.clickLoginButton();

	}

	@Test(priority = Utilities.MEDIUM_PRIORITY, enabled = true, description = UserStories.REQUIREMENT_TYPE
			+ UserStories.EMPTY_LOGIN_SCENERIO + UserStories.EMPTY_LOGIN_STATEMENT)
	public void verifyEmptyUsernameAndEmptyPassword() {

		Reporter.log(Utilities.MEDIUM_PRIORITY_STATEMENT, true);

		LoginPage login = new LoginPage(driver);
		login.goToHeaderLoginBtn();
		login.goToLoginAsEmployer();
		login.setEmptyUserNameAndEmptyPasswordCredentials();
		login.clickLoginButton();
		Assert.assertEquals(login.getEmptyEmailText(), login.getExpectedEmptyEmailText());
		Reporter.log(Utilities.TEST_PASSED, true);
	}

	@DataProvider(name = "CheckLoginMultipleScenarios")
	public Object[][] testDataForLogin() {

		Object[][] data = {

				{ "InvalidEmail@gmail.com", "invalidPassword" }, { "nocifew594@ikangou.com", "Test@123" },
				{ "nocifew594@ikangou.com", "test123" },

		};

		return data;
	}

}
