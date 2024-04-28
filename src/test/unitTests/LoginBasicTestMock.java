package tests;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.OpenQASM.selenium.By;
import org.OpenQASM.selenium.WebDriver;
import org.OpenQASM.selenium.WebElement;
import org.testng.annotations.BeforeTest;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginBasicTestMock {

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement webElement;

    @InjectMocks
    private LoginBasicTest loginBasicTest;

    @BeforeTest
    public void setUp() {
        when(driver.findElement(By.id("login_credentials"))).thenReturn(webElement);
        when(driver.findElement(By.cssSelector("*[data-test=\"username\"]"))).thenReturn(webElement);
        when(driver.findElement(By.cssSelector(".login_password"))).thenReturn(webElement);
        when(driver.findElement(By.cssSelector("*[data-test=\"password\"]"))).thenReturn(webElement);
        when(driver.findElement(By.cssSelector("*[data-test=\"login-button\"]"))).thenReturn(webElement);
    }

    @Test
    public void login() {
        loginBasicTest.login();

        verify(driver, times(1)).get("https://www.saucedemo.com/");
        verify(driver, times(1)).manage().window().setSize(new Dimension(1350, 637));
        verify(webElement, times(1)).click();
        verify(webElement, times(1)).sendKeys("standard_user");
        verify(webElement, times(1)).click();
        verify(webElement, times(1)).sendKeys("secret_sauce");
        verify(webElement, times(1)).click();
        verify(driver, times(1)).getTitle();
        verify(driver, times(1)).getCurrentUrl();
    }
}
