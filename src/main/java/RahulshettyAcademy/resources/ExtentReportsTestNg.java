package RahulshettyAcademy.resources;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


@Test
public class ExtentReportsTestNg {
	public static ExtentReports getreport()
	{
	
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter report=new ExtentSparkReporter(path);
	
	report.config().setReportName("Web Automation Results");
	report.config().setDocumentTitle("Test Results");
	
	
ExtentReports	extent=new ExtentReports();
	extent.attachReporter(report);
	extent.setSystemInfo("Tester","Nitish");
	return extent;

	}
}
