package by.moyareklama.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(FirefoxDriver driver) {
        this.driver = driver;
    }

    public ApartmentsPage selection() {
        driver.findElement(By.linkText("Квартиры")).click();

        return new ApartmentsPage (driver);
    }
}
