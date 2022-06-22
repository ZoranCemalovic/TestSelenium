package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomepagePage {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement practiceButton;
    WebElement coursesButton;

    //Prvo dodamo driver i wdwait atibute, kreiramo njihove konstruktore
    //Nakon toga dodajemo za atribute svaki webelement na stranici koji nam treba
    //Nakon toga kreiramo getere za te web elemente
    //Geteri se kreiraju preko alt + insert
    //Za svaki geter nakon "return" ubacujemo lokator - primer: driver.findElement(By.id("neki ID"));
    //U pages klasama ubacujemo i metode kao akcije nad pronadjenim web elementima
    //Primera radi: Kreiramo metode za klik, unos podataka, izvlacenje teksta itd
    //Da bismo vizuelno odvojili getere i te akcione metode, stavljamo zakomentarisane crtice
    //-----------
    //Akcione metode nazivamo sto jasnije moguce jer upravo te metode ce nam biti koraci
    //Te metode ce biti kao jedan korak u test kejsu
    //Ako korak glasi "Click on Next button" onda metoda treba da se zove clickOnNextButton
    //Na taj nacin kada kreiramo test jasno znamo koje korake preduzimamo
    //Napomena: Kada kreiramo metode za unos podataka prvo moramo da odradimo akciju clear u metodi


    public HomepagePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getPracticeButton() {
        return driver.findElement(By.id("menu-item-20"));
    }

    public WebElement getCoursesButton() {
        return driver.findElement(By.id("menu-item-21"));
    }


    //-----------------------
    public void clickOnPracticeButton() {
        this.getPracticeButton().click();
    }

    public void clickOnCoursesButton() {
        this.getCoursesButton().click();
    }
}
