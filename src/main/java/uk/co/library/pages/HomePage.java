package uk.co.library.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.utility.Utility;

public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    @CacheLookup
    @FindBy (xpath = "//input[@id='keywords']")
    WebElement jobTitleField;

    @CacheLookup
    @FindBy (xpath = "//input[@id='location']")
    WebElement locationField;

    @CacheLookup
    //@FindBy (xpath = "//select[@id='distance_adv']")
    @FindBy(id = "distance")
    WebElement distanceDropDown;

    @CacheLookup
    @FindBy (xpath = "//button[@id='toggle-hp-search']")
    WebElement moreSearchOptionsLink;

    @CacheLookup
    @FindBy (xpath = "//input[@id='salarymin']")
    WebElement salaryMin;

    @CacheLookup
    @FindBy (xpath = "//input[@id='salarymax']")
    WebElement salaryMax;

    @CacheLookup
    @FindBy (xpath = "//select[@id='salarytype']")
    WebElement salaryTypeDropDown;

    @CacheLookup
    @FindBy (xpath = "//select[@id='tempperm']")
    WebElement jobTypeDropDown;

    @CacheLookup
    @FindBy (xpath = "//input[@id='hp-search-btn']")
    WebElement findJobsBtn;

    @CacheLookup
    @FindBy(xpath = "//button[@id='save']")
    WebElement acceptCookies;

//    @CacheLookup
//    @FindBy(xpath = "//span//div//span[normalize-space()='Accept All']")
//    WebElement acceptCookies;

    @CacheLookup
    @FindBy(id ="gdpr-consent-notice")
    WebElement iframe;


    public void setAcceptCookies(){
        switchToIframe(iframe);
        clickOnElement(acceptCookies);
        driver.switchTo().defaultContent();
    }

//    public void setAcceptCookies() {
//        driver.switchTo().frame("gdpr-consent-notice");
//        clickOnElement(acceptCookies);
//    }

    public void enterJobTitle(String jobTitle){
        sendTextToElement(jobTitleField, jobTitle);
        CustomListeners.node.log(Status.PASS, "Enter Job Title '" + jobTitle + "' to job title field.");
        Reporter.log("Enter Job Title : '" + jobTitle + "' Job title field" + "<br>");
    }

    public void enterLocation(String location){
        sendTextToElement(locationField, location);
        CustomListeners.node.log(Status.PASS, "Enter location '" + location + "' to location field." );
        Reporter.log("Enter location : '" + location + "' location field" + "<br>");
    }

    public void selectDistance(String distance) throws InterruptedException {
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(distanceDropDown, distance);
        CustomListeners.node.log(Status.PASS, "Select distance '" + distance + "' from dropdown. " );
        Reporter.log("Select distance : '" + distance + "' distance field" + "<br>");
    }

    public void clickOnMoreSearchOption(){
        clickOnElement(moreSearchOptionsLink);
        CustomListeners.node.log(Status.PASS, "Click on 'More Search Option' Link " );
        Reporter.log("Click on 'More Search Option' Link" + "<br>");

    }

    public void enterMinSalary(String minSalary){
        sendTextToElement(salaryMin, minSalary);
        CustomListeners.node.log(Status.PASS, "Enter minimum salary '" + minSalary + "' to Salary Min. field " );
        Reporter.log("Enter minimum salary : '" + salaryMin + "' Salary Min. field" + "<br>");
    }

    public void enterMaxSalary(String maxSalary){
        sendTextToElement(salaryMax, maxSalary);
        CustomListeners.node.log(Status.PASS, "Enter maximum salary '" + maxSalary + "' to Salary Max. field " );
        Reporter.log("Enter maximum salary : '" + salaryMax + "' Salary Max. field" + "<br>");
    }

    public void selectSalaryType(String salaryType){
        selectByVisibleTextFromDropDown(salaryTypeDropDown, salaryType);
        CustomListeners.node.log(Status.PASS, "Select salary type '" + salaryType + "' from dropdown " );
        Reporter.log("Select salary type : '" + salaryType + "' from dropdown" + "<br>");
    }

    public void selectJobType(String jobType){
        selectByVisibleTextFromDropDown(jobTypeDropDown, jobType);
        CustomListeners.node.log(Status.PASS, "Enter maximum salary '" + jobType + "' to Salary Max. field " );
        Reporter.log("Select distance : '" + jobType + "' distance field" + "<br>");
    }

    public void clickOnFindJobsButton(){
        clickOnElement(findJobsBtn);
        CustomListeners.node.log(Status.PASS, "Click on 'Find Job' Button");
        Reporter.log("More Search Options' link" + "<br>");
    }

}
