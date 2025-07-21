package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage{
	WebDriver driver;
public LoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
}
// Username field - using contains in XPath
@FindBy(xpath = "//input[contains(@id,'user')]")
private WebElement usernameField;

// Password field - using contains in XPath
@FindBy(xpath = "//input[contains(@id,'pass')]")
private WebElement passwordField;

// Login button - using contains in XPath
@FindBy(xpath = "//input[contains(@id,'login')]")
private WebElement loginButton;

// Actions
public void enterUsername(String username) {
    usernameField.sendKeys(username);
}

public void enterPassword(String password) {
    passwordField.sendKeys(password);
}

public void clickLogin() {
	loginButton.click();
	
}
}
