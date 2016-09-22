package TestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Wait;

public class DemoTestNG {
  @Test
  public void verifyLatestNewsSection() {
      WebDriver driver = new FirefoxDriver();
      driver.get("http://www.valtech.com");
      WebElement latestNews = driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div[3]"));
      Assert.assertEquals(true, latestNews.isDisplayed());
      driver.quit();
  }
  
  @Test
  public void verifyCaseNavigationLinks() {
      WebDriver driver = new FirefoxDriver();
      driver.get("http://www.valtech.com");
      driver.findElement(By.id("navigation-toggle-button")).click();
      
      WebDriverWait wait = new WebDriverWait(driver, 15);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("CASES")));
      
      driver.findElement(By.linkText("CASES")).click();
      String title = driver.findElement(By.className("page-header")).getText();
      Assert.assertTrue(title.contains("Cases"));
      
      driver.findElement(By.id("navigation-toggle-button")).click();
      
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("CASES")));
      
      driver.findElement(By.linkText("SERVICES")).click();
      title = driver.findElement(By.className("page-header")).getText();
      Assert.assertTrue(title.contains("Services"));
      
      driver.findElement(By.id("navigation-toggle-button")).click();
      
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("CASES")));
      
      driver.findElement(By.linkText("JOBS")).click();
      title = driver.findElement(By.className("page-header")).getText();
      Assert.assertTrue(title.contains("Jobs"));
              
      driver.quit();
  }
  
  @Test
  public void findOfficesCount(){
      WebDriver driver = new FirefoxDriver();
      driver.get("http://www.valtech.com");
      driver.findElement(By.className("hamburger__front_lang")).click();
      
      WebDriverWait wait = new WebDriverWait(driver, 15);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("office__map__icon")));
      
      List<WebElement> listIcons=driver.findElements(By.className("office__map__icon"));

      System.out.println("No. of locations: "+listIcons.size());
      driver.quit();
      
  }
  
}
