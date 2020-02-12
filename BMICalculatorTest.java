import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BMICalculatorTest {

    @Test
    public void categoryNormal() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("50");
        browser.findElement(By.name("ht")).sendKeys("160");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Normal", "Категория неверна");
        browser.quit();
    }

    @Test
    public void categoryObese() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("100");
        browser.findElement(By.name("ht")).sendKeys("160");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Obese", "Категория неверна");
        browser.quit();
    }

    @Test
    public void categoryUnderweight() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("150");
        browser.findElement(By.name("ht")).sendKeys("300");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Underweight", "Категория неверна");
        browser.quit();
    }

    @Test
    public void categoryStarvation() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("11");
        browser.findElement(By.name("ht")).sendKeys("100");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Starvation", "Категория неверна");
        browser.quit();
    }

    @Test
    public void alertHeight() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("11");
        browser.findElement(By.name("ht")).sendKeys("32");
        browser.findElement(By.name("cc")).click();
        Alert alert = browser.switchTo().alert();
        String textOnAlert = alert.getText();
        assertEquals("Height should be taller than 33cms", textOnAlert);
        browser.quit();
    }

    @Test
    public void alertWeight() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("10");
        browser.findElement(By.name("ht")).sendKeys("50");
        browser.findElement(By.name("cc")).click();
        Alert alert = browser.switchTo().alert();
        String textOnAlert = alert.getText();
        assertEquals("Weight should be greater than 10kgs", textOnAlert);
        browser.quit();
    }

    @Test
    public void checkSpecialSymbol() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("40");
        browser.findElement(By.name("ht")).sendKeys("#@$");
        browser.findElement(By.name("cc")).click();
        Assert.assertEquals("", browser.findElement(By.name("desc")).getAttribute("value"));
        browser.quit();
    }

    @Test
    public void checkAlphabeticSymbol() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("40");
        browser.findElement(By.name("ht")).sendKeys("calculator");
        browser.findElement(By.name("cc")).click();
        Assert.assertEquals("", browser.findElement(By.name("desc")).getAttribute("value"));
        browser.quit();
    }
}
