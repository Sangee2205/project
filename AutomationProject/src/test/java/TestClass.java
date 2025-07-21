import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.project.Base;
import utils.ExcelUtils;
public class TestClass extends Base {
	    @Test(dataProvider = "SampleData")
	    public void tcl(String username, String password, String index) {
	    	browserLaunch("https://adactinhotelapp.com/");

	        LoginPage loginPage = new LoginPage(driver);

	        // Perform login
	        loginPage.enterUsername(username);
	        loginPage.enterPassword(password);
	        loginPage.clickLogin();

	        System.out.println("Login attempted for user: " + username + " (Index: " + index + ")");
       
	    }
	    @DataProvider(name = "SampleData")
	    public Object[][] dataProviding() throws IOException {
	        String excelPath = "src/test/resources/TestData/LoginData.xlsx";
	        String sheetName = "Sheet1";
	        return ExcelUtils.readExcelData(excelPath, sheetName);
	    }
	}

