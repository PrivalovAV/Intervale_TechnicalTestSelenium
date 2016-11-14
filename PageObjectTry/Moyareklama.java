package by.moyareklama.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class Moyareklama {
    private FirefoxDriver driver;
    private WebDriverWait wait;

    @Before
    public void SetUp(){
        System.setProperty("webdriver.gecko.driver", "e:\\!!!Почистить\\Selenium\\geckodriver.exe ");
        WebDriver driver = new FirefoxDriver();

        /*System.setProperty("webdriver.chrome.driver", "e:\\!!!Почистить\\Selenium\\chromedriver.exe ");
        WebDriver driver = new ChromeDriver();*/

        /*System.setProperty("webdriver.ie.driver", "e:\\!!!Почистить\\Selenium\\IEDriverServer.exe ");
        WebDriver driver = new InternetExplorerDriver();*/

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("http://www.moyareklama.by");
    }


    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void serchAd(){
        HomePage home = new HomePage(driver);
        ApartmentsPage apart = home.selection();
        ApartmentsPage apartExt = apart.ext(wait);
        ResultPage result = apart.selectParametrs(2, 1500000000);
        assertFalse(result.equals(null));
        AdPage ad = result.selectSecondResult();
        switchToSecondWindow();
        assertTrue(ad.getAdress().contains("ул.") && ad.getAdress().contains("д."));

    }

    private void switchToSecondWindow() {
    }
    public static void js(JavascriptExecutor driver, String s) {
        JavascriptExecutor js = driver;
        js.executeScript(s);
    }
}
