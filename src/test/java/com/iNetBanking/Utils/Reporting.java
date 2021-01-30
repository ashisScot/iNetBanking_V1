package com.iNetBanking.Utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporting extends TestListenerAdapter{
	ExtentReports extent; // specifi
	ExtentSparkReporter spark;
	ExtentTest test;
	
	
	public void onStart(ITestContext testContext)  {
		// TODO Auto-generated method stub
		String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));
		String reportName= "NetBanking_Report_"+timeStamp+".html";
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("./test-output/"+reportName);
		try {
			spark.loadXMLConfig("./extent-config.xml");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent.attachReporter(spark);
		extent.setSystemInfo("Host name", "localHost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Ashis");
		
		
		
		
	}
	
	public void onTestSuccess(ITestResult tr) {
		// TODO Auto-generated method stub
		test= extent.createTest(tr.getName());//create new entry in the report
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));//send the passed info to the report with green color highlighted
	}
	
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
		test= extent.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String screenShotPath = "./Screenshot/"+tr.getName()+".png";
		File file = new File(screenShotPath);
		if(file.exists()) {
			test.fail("Screenshot below "+test.addScreenCaptureFromPath(screenShotPath));
		}
			
	}
	
	public void onTestSkipped(ITestResult tr) {
		// TODO Auto-generated method stub
		test = extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
		extent.flush();
	}
}
