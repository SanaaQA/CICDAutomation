package ProjectLibrary;

import org.openqa.selenium.devtools.v85.browser.Browser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.P2GotoStudio;
import PageObjects.P3CreateComponents;
import PageObjects.P5CreateDatalistt;
import PageObjects.P6ConnectWrkflow;
import PageObjects.P7GoToDashboard;
import TestComponents.Basetest;
import AbstractComponents.AbstrtactClass;

public class Studio extends Basetest 

{
	
	

@Test
public void CreateDBComponents() throws InterruptedException
{l1.signin();
P2GotoStudio l2 = new P2GotoStudio(driver);
l2.AppCreation();
Thread.sleep(1000);
l2.OpenInStudio();
P3CreateComponents l3 = new P3CreateComponents(driver);
l3.CreateSS();
l3.CreateForm();

}

@Test(dependsOnMethods={"CreateDBComponents"})
public void CreateWorkflow() throws InterruptedException
{
	P5CreateDatalistt l4=new P5CreateDatalistt(driver);
	l4.CreateDataList();
	P6ConnectWrkflow l5 = new P6ConnectWrkflow(driver);
	l5.CreateWorkflw();
	l5.EditWorkflow();
}

@Test(dependsOnMethods={"CreateWorkflow"})
public void FileUpload() throws InterruptedException
{
	P7GoToDashboard l6 =new  P7GoToDashboard(driver);
	l6.Dashboard();
	l6.FileUpload();
}


}