import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestcheckoutError {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("last-name")).sendKeys("Disic");
        driver.findElement(By.id("postal-code")).sendKeys("11070");
        driver.findElement(By.id("continue")).click();

        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.equals("https://www.saucedemo.com/checkout-step-one.html")) {
            System.out.println("PASSED");
            String expectedErrorMessage = "Error: First Name is required";

            WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
            String actualErrorMessage = errorMessage.getText();
            if(actualErrorMessage.equals(expectedErrorMessage)) {
                System.out.println("Message is equal");
            }
            else {
                System.out.println("Message is not equal");
            }
        }
        else {
            System.out.println("FAILED");

        }



    }
}