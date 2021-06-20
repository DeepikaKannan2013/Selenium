package week2learning.day1;

//import org.apache.bcel.generic.Select;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// download the chromedriver
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		// Maximize the browser

		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		// Get title
		String title = driver.getTitle();
		System.out.println("Title is :" + title);

		// to check if we are in correct page
		String text = driver.findElement(By.tagName("h2")).getText();
		System.out.println("Title is:" + text);

		// to click on crmsfa
		driver.findElement(By.linkText("CRM/SFA")).click();
		System.out.println("clicked on the crmsfa ");

		// TO click on leads
		driver.findElement(By.linkText("Leads")).click();
		System.out.println("Clicked on Leads tab");

		// TO click on create leads
		driver.findElement(By.linkText("Create Lead")).click();
		System.out.println("Clicked on Create Lead tab");

		// TO create lead by providing the details
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test Leaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Deepika");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Karunanidhi");
		
		//Select value from Source dropdown
		WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select drpdown1 = new Select(source);
		drpdown1.selectByValue("LEAD_EXISTCUST");
		
		//Select value from Markcampaign dropdown
		WebElement markcampaign = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select drpdown2 = new Select(markcampaign);
		drpdown2.selectByVisibleText("Pay Per Click Advertising");
		
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Deep");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("Karuna");
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Mrs");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("19/11/1988");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Testtitle");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("1500000");
		
		//Select value from Currency dropdown
		WebElement currency = driver.findElement(By.id("createLeadForm_currencyUomId"));
		Select drpdown3 = new Select(currency);
		drpdown3.selectByIndex(6);
		
		WebElement industry = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select drpdown4 = new Select(industry);
		drpdown4.selectByIndex(3);
		
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("150");
		
		//Select value from ownership dropdown
		WebElement ownership = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select drpdown5 = new Select(ownership);
		drpdown5.selectByVisibleText("Partnership");
		
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("10110");
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("%");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("To automate the create lead functionality");
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("check for the creation successfull");
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("91");
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("044");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9080706050");
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("5670");
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("checkkk");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("test@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("www.gggg.com");
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Test2");
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Test3");
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("No 10, 1st Main road");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("4th Street");
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Troupe");
		WebElement stateprovince = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select drpdown6 = new Select(stateprovince);
		drpdown6.selectByValue("KY");
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("506070");
		
		//Select value from Country dropdown
		WebElement country = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select drpdown7 = new Select(country);
		drpdown7.selectByVisibleText("United States");
		
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("309087");
		
		//click on Create lead button
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println("Create lead submitted successfully");
		
		//TO get the title of view leads page
		String viewlead = driver.getTitle();
		if(viewlead.equals("View Lead"))
		System.out.println("In the view page");
		else {
			System.out.println("Not in view page");
		}
		
		//To get the firt name created in leads
		String companyname = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Company name provided is :" +companyname);
		
		//To get the first name created in leads
		String firstname = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println("first name provided is :" +firstname);
		
		//To get the Last name created in leads
		String lastname = driver.findElement(By.id("viewLead_lastName_sp")).getText();
		System.out.println("Last name provided is :" +lastname);
		
		//To get the status in leads
		String status = driver.findElement(By.id("viewLead_statusId_sp")).getText();
		System.out.println("Status assigned is :" +status);
		
		//To click on duplicate leads button
		driver.findElement(By.className("subMenuButton")).click();
		System.out.println("Clicked on Duplicate lead button");
		
		//To check for duplicate lead header
		String duplicateheader = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		
		if(duplicateheader.equals("Duplicate Lead"))
			System.out.println("Header Duplicate Lead is displayed");
		else
			System.out.println("Header Duplicate lead is not displayed");
		
		//To clear & rename the company
		WebElement companyname2 = driver.findElement(By.id("createLeadForm_companyName"));
		companyname2.clear();
		companyname2.sendKeys("New company");
		
		//To submit create leads again
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println("Create lead submitted successfully");
		
		//To check for the company name provided
		String editedcompany = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if(editedcompany.equals("New company"));
		System.out.println("New company name validated ");
		
		//To close the browser
		driver.close();
		System.out.println("Browser closed successfully");
	}

}
