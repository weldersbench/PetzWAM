package pages;

import general.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class List extends Base {

    @FindBy(css = "h1.h2Categoria.nomeCategoria")
    private WebElement lblResultBy;


    public List(WebDriver driver){
        super(driver);
    }

    public String readTitleTab(){
        return driver.getTitle();
    }

    public String readResultBy(){
        return lblResultBy.getText();
    }

    public void clickAtDesiredProduct(String product){
        driver.findElement(By.xpath("//h3[contains(text(),'" + product + "')]")).click();
    }
}
