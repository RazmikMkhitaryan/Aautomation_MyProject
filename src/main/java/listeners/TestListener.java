package listeners;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import setup.DriverHelper;

import java.io.File;
import java.io.IOException;


public class TestListener implements ITestListener {
    private static final Logger LOGGER = Logger.getLogger(TestListener.class);

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("PASSED ------>" + result.getMethod().getQualifiedName());
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        TakesScreenshot ts = (TakesScreenshot) DriverHelper.get().getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
            System.out.println("Screenshot taken");
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info("SKIPPED ------>" + result.getMethod().getQualifiedName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        TakesScreenshot ts = (TakesScreenshot) DriverHelper.get().getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
            System.out.println("Screenshot taken");
        } catch (IOException e) {
            e.printStackTrace();
        }

        LOGGER.info("FAILURE ------>" + result.getMethod().getQualifiedName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("STARTED ------>" + result.getMethod().getQualifiedName());
    }

}
