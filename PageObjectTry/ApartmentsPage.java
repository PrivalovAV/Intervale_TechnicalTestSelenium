package by.moyareklama.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static by.moyareklama.test.Moyareklama.js;

public class ApartmentsPage {
    private WebDriver driver;

    public ApartmentsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ApartmentsPage() {
    }

    public ApartmentsPage ext(WebDriverWait wait) {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ar_extend_search']")));

        js((JavascriptExecutor) driver, "$('#ar_extend_search').click();");

        return new ApartmentsPage();
    }

    public ResultPage selectParametrs(int numberOfRooms, int minPrice) {

        return new ResultPage();
    }
}
