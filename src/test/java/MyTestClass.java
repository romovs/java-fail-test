import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import io.cloudbeat.junit.CbJunitExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@ExtendWith({CbJunitExtension.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MyTestClass {
    String baseUrl = "https://cloudbeat-qa.menora.co.il/#/";


    @Test@Order(1)
    public void A_testJava() {
        CbJunitExtension.startStep("Running java test 1");
            System.out.println("Open Java test 1");
        CbJunitExtension.endLastStep();
		
        CbJunitExtension.startStep("Create Chrome Driver");
s            CbJunitExtension.logInfo("Testing opening the driver");
            System.setProperty("webdriver.chrome.driver", "D:\\JavaSeleniumForCloudbeat\\chromedriver.exe");
            WebDriver chromeDriver = new ChromeDriver();
            WebDriver driver = CbJunitExtension.wrapWebDriver(chromeDriver);
        CbJunitExtension.endLastStep();
		
        CbJunitExtension.startStep("Open Url to Cloudbeat");
          CbJunitExtension.logInfo("logInfo opening the url");
            driver.get(baseUrl);
            driver.manage().window().maximize();
        CbJunitExtension.endLastStep();
		
        CbJunitExtension.startStep("Test try catch exception, out of step");
           String title =  driver.getTitle();
			System.out.println("The title for console print test 1 is: "+ title);        
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            CbJunitExtension.endLastStep();
            
            boolean error = false;      
            try{
            	int data=50/0; //should throw an exception              
            }catch(Exception e){
              error = true;
              e.printStackTrace();
            }
      
            if(error){
               CbJunitExtension.startStep("Test error");
              	System.out.println("An error occurred, exception was caught out of step");    
              CbJunitExtension.endLastStep();              
            }
      
        CbJunitExtension.startStep("Close driver");
			driver.close();
        CbJunitExtension.endLastStep(); 
       
    }




    @Test@Order(2)
    public void B_testJava() {
        CbJunitExtension.startStep("Open java test 2");
          System.out.println("Open Java test 2");
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Create Chrome Driver");
          System.setProperty("webdriver.chrome.driver", "D:\\JavaSeleniumForCloudbeat\\chromedriver.exe");
          WebDriver chromeDriver = new ChromeDriver();
          WebDriver driver = CbJunitExtension.wrapWebDriver(chromeDriver);
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Open Url to Cloudbeat");
          driver.get(baseUrl);
          driver.manage().window().maximize();
        CbJunitExtension.endLastStep();

       CbJunitExtension.startStep("Printing the title");
         try {
                Thread.sleep(3000);
         } catch (InterruptedException e) {
                e.printStackTrace();
        }
        String title =  driver.getTitle();
        System.out.println("The title for test 2 is: "+ title);         
       CbJunitExtension.endLastStep();
      
       CbJunitExtension.startStep("Test try catch exception, in cloudbeat step");
        try{
             int data=50/0; //throws an exception             
         }catch(Exception e){
          System.out.println("Exception caught in step "+ e.printStackTrace(););         
         }
      CbJunitExtension.endLastStep();
      
     CbJunitExtension.startStep("Close driver");
        driver.close();
     CbJunitExtension.endLastStep();
    }



    @Test@Order(3)
    public void C_testJava() {
        CbJunitExtension.startStep("Open java test 3");
        	System.out.println("Open Java test 3");
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Create Chrome Driver");
          System.setProperty("webdriver.chrome.driver", "D:\\JavaSeleniumForCloudbeat\\chromedriver.exe");
          WebDriver chromeDriver = new ChromeDriver();
          WebDriver driver = CbJunitExtension.wrapWebDriver(chromeDriver);
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Open Url to Cloudbeat");
          driver.get(baseUrl);
          driver.manage().window().maximize();
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Printing the title");
          String title =  driver.getTitle();
          System.out.println("The title for test 3 is: "+ title);
          try {
              Thread.sleep(5000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
        CbJunitExtension.endLastStep();
      
      	CbJunitExtension.startStep("Close driver");
        	driver.close();
        CbJunitExtension.endLastStep();
    }
}
