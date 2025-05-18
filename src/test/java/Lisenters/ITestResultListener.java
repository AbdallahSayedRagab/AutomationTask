package Lisenters;

import Utilities.LogsUtils;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class ITestResultListener implements ITestListener {
    public void onTestStart (ITestResult Result){
        LogsUtils.info("Test-Case:" + Result.getMethod().getMethodName() + " is Started");

    }
    public void onTestSuccess (ITestResult Result){
        LogsUtils.info("Test-Case:" + Result.getMethod().getMethodName() + " is Successed");

    }
    public void onTestSkipped (ITestResult Result){
        LogsUtils.info("Test-Case:" + Result.getMethod().getMethodName() + " is Skipped");

    }
}
