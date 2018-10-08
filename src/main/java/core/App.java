package core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Allitebook allitebook = new Allitebook();
        allitebook.config("https://www.gmail.com",50, TimeUnit.SECONDS);
        
        
        new WebElementOperation(allitebook.getDriver(), By.xpath("//input[@type='email' and @name='identifier']"), TypeOperation.SENDKEY, "aarnedoc@unicartagena.edu.co_").execute();
        new WebElementOperation(allitebook.getDriver(), By.xpath("//input[@type='password' and @name='password']"), TypeOperation.SENDKEY, Element.PASS.concat("_")).execute();
       // new WebElementOperation(allitebook.getDriver(), By.xpath("//a[contains(@href,'https://www.youtube.com')]"), TypeOperation.CLICK, null).execute();
    }
}
