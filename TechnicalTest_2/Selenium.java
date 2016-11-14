package by.moyareklama.test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class Selenium {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "/path/to/geckodriver.exe ");
        WebDriver driver = new FirefoxDriver();

        /*System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver.exe ");
        WebDriver driver = new ChromeDriver();*/

        /*System.setProperty("webdriver.ie.driver", "/path/to/IEDriverServer.exe ");
        WebDriver driver = new InternetExplorerDriver();*/

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("http://www.moyareklama.by");

        driver.findElement(By.linkText("Квартиры")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ar_extend_search']")));

        js((JavascriptExecutor) driver, "$('#ar_extend_search').click();");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("room_2")));

        js((JavascriptExecutor) driver, "$('#room_2').click();");

        driver.findElement(By.cssSelector(".rf_minValue>input")).sendKeys("1500000000");

        driver.findElement(By.cssSelector(".rf_search>img")).click();

        WebElement nullList = driver.findElement(By.cssSelector(".message_text"));
        Assert.assertFalse(nullList.getText().contains("По данному запросу ничего не найдено"));

        List<WebElement> listResult = driver.findElements(By.xpath("//*[@class ='sa_container realty_container container_new']"));

        listResult.get(1).click();

    String parentWindow = driver.getWindowHandle();
        Set<String> handles =  driver.getWindowHandles();
        for(String windowHandle  : handles)
        {
            if(!windowHandle.equals(parentWindow))
            {
                driver.switchTo().window(windowHandle);
            }
        }

        WebElement adress = driver.findElement(By.cssSelector(".pv1_adress"));
        System.out.println(adress.getText());
        Assert.assertTrue(adress.getText().contains("ул.") && adress.getText().contains("д."));

        driver.quit();
    }

    private static void js(JavascriptExecutor driver, String s) {
        JavascriptExecutor js = driver;
        js.executeScript(s);
    }

}

