import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.example.FrameworkConfig;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;

public class RunnerWIthOwner {
    static WebDriver driver;

    public static void main(String[] args) {
        FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);
        if(config.browser().name().equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else{
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }


        driver.get("https://ecommerce-playground.lambdatest.io/");
        String url = driver.getCurrentUrl();
        System.out.println(driver.getTitle());
        if(config.takeScreenshot()){
            System.out.println("screenshot taken");
            TakesScreenshot shot = (TakesScreenshot)driver;
            File src = new File(String.valueOf(shot.getScreenshotAs(OutputType.FILE)));

        }
        driver.quit();
    }

}
