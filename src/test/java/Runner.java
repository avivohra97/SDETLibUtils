import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Runner {
    public static void main(String[] args) throws IOException {
        WebDriver driver;
        Properties properties = new Properties();
        properties.load(new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/FrameworkConfig.properties"));;

        if(properties.getProperty("browser").equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else{
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }


        driver.get("https://ecommerce-playground.lambdatest.io/");
        String url = driver.getCurrentUrl();
        System.out.println(driver.getTitle());
        if(properties.getProperty("takesscreenshot").equalsIgnoreCase("true")){

        }
        driver.quit();
    }


}
