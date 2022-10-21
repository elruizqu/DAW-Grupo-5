/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BPproject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 *
 * @author elena
 */
public class BPproject {

    /**
     * @param args the command line arguments
     */
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\elena\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.out.println("Test initiated");
        driver = new ChromeDriver();
        driver.get("https://www.bancopopular.fi.cr/");
        System.out.println("Page title is "+ driver.getTitle());
        //driver.quit();
    }
    
}
