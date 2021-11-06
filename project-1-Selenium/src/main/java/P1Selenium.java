import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class P1Selenium {
    public WebDriver driver;
    P1Selenium () {
        System.setProperty("webdriver.gecko.driver", "c:\\tools\\Selenium\\geckodriver.exe");
        driver = new FirefoxDriver();
    }
    public static void main(String[] args) throws InterruptedException {
        P1Selenium p1s = new P1Selenium();
        // sends a request to retrieve this webpage

        String[] opArray = {"add", "subtract", "multiply", "divide"};
        double numArray[][] = {{2.3,4.4},{5.5,7}};

        for (int i=0; i<opArray.length; i++) {
            for (int j=0; j<numArray.length; j++) {
                p1s.postForm(opArray[i], numArray[j][0], numArray[j][1]);
                Thread.sleep(2500);
            }
        }
        Thread.sleep(5000);
        p1s.driver.quit();
    }

    void postForm(String operation, double number1, double number2) {
        this.driver.get("http://localhost:9000");
        WebElement inputElem = driver.findElement(By.id(operation+"_num_1")); // we got it by id "word-input"
        inputElem.sendKeys(String.valueOf(number1));
        WebElement inputElem2 = driver.findElement(By.id(operation+"_num_2")); // we got it by id "word-input"
        inputElem2.sendKeys(String.valueOf(number2));
        WebElement btn = driver.findElement(By.id(operation+"_btn"));
        btn.click();

        //switched to the iframe to get tags from the iframe
        driver.switchTo().frame(operation+"_result");
        System.out.println(number1 + " " + operation+" "+number2 + " = " + driver.findElement(By.tagName("pre")).getText());
        driver.switchTo().defaultContent();
    }
}
