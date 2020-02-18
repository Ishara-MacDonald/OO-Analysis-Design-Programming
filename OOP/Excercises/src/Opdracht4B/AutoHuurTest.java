package Opdracht4B;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

/*  Leesbaarheid boven zo min mogelijk regels code.
    Efficientie is belangrijk, maar zo is leesbaarheid!
    In dit geval: Programmeurs verwachten een 'assert', maar kunnen die niet vinden. Ze komen er pas aan het eind
    van het testdocument achter.
    Bij elke test hoort eigenljk een 'assert' en deze verwachten anderen ook als ze jouw code lezen.
    Voldoe ook aan deze verwachtingen!
*/

class AutoHuurTest {
    private Auto a1;
    private Klant k;
    private AutoHuur ah1;
    private String typeTest;

    @BeforeEach
    public void setTestAutoHuur(){
        ah1 = new AutoHuur();
        k = new Klant("Mijnheer de Vries");
        a1 = new Auto("Peugeot 207", 50);
        typeTest = "";
    }

    //Test 1
    @Test
    public void testNoData(){
        typeTest = "Test 1, no data\n";
    }

    //Test 3
    @Test
    public void testCarOnly(){
        typeTest = "Test 3, car only\n";
        ah1.setGehuurdeAuto(a1);
    }

    //Test 5
    @Test
    public void testDaysOnly(){
        typeTest = "Test 5, days only\n";
        ah1.setAantalDagen(4);
    }

    //Test 7
    @Test
    public void testCarDays(){
        typeTest = "Test 7, car and days\n";
        ah1.setAantalDagen(4);
        ah1.setGehuurdeAuto(a1);
    }

    //Test 9
    @Test
    public void testRenterOnly(){
        typeTest = "Test 9, renter only\n";
        ah1.setHuurder(k);
    }

    //Test 10
    @Test
    public void testRenterDiscount(){
        typeTest = "Test 10, renter and discount\n";
        ah1.setHuurder(k);
        k.setKorting(10.0);
    }

    //Test 11
    @Test
    public void testRenterCar(){
        typeTest = "Test 11, renter and car\n";
        ah1.setHuurder(k);
        ah1.setGehuurdeAuto(a1);
    }

    //Test 12
    @Test
    public void testNoDays(){
        typeTest = "Test 12, renter, car and discount\n";
        ah1.setHuurder(k);
        ah1.setGehuurdeAuto(a1);
        k.setKorting(10.0);
    }

    //Test 13
    @Test
    public void testRenterDays(){
        typeTest = "Test 13, renter and days\n";
        ah1.setHuurder(k);
        ah1.setAantalDagen(4);
    }

    //Test 14
    @Test
    public void testNoCar(){
        typeTest = "Test 14, renter, days and discount\n";
        ah1.setHuurder(k);
        ah1.setAantalDagen(4);
        k.setKorting(10.0);
    }

    //Test 15
    @Test
    public void testNoDiscount(){
        typeTest = "Test 15, days, renter and car\n";
        ah1.setHuurder(k);
        ah1.setAantalDagen(4);
        ah1.setGehuurdeAuto(a1);
    }

    //Test 16
    @Test
    public void testAll(){
        typeTest = "Test 16, days, renter, car and discount\n";
        ah1.setHuurder(k);
        ah1.setAantalDagen(4);
        ah1.setGehuurdeAuto(a1);
        k.setKorting(10.0);
    }

    @AfterEach
    public void showData(){
        System.out.println(ah1);
        System.out.println("\n");
        expected();
    }

    public void expected(){
        if(typeTest.contains("car") && typeTest.contains("renter") && typeTest.contains("days") && typeTest.contains("discount")) {expectedValuePrice();}
        else if(typeTest.contains("car") && typeTest.contains("renter") && typeTest.contains("days")) {expectedValueDiscountedPrice();}
        else {expectedZeroPrice();}
    }

    public void expectedZeroPrice(){
            String getPrice = ah1.toString().substring(ah1.toString().lastIndexOf(' ') + 1);
        assertEquals("0,0", getPrice);
    }

    public void expectedValuePrice(){
        String getPrice = ah1.toString().substring(ah1.toString().lastIndexOf(' ') + 1);
        assertEquals("180,0", getPrice);
    }

    public void expectedValueDiscountedPrice(){
        String getPrice = ah1.toString().substring(ah1.toString().lastIndexOf(' ') + 1);
        assertEquals("200,0", getPrice);
    }












    /*
    public void expectedZeroDays(){
        String getAfterDays = ah1.toString().substring(ah1.toString().lastIndexOf(":") + 2);
        String getDays = getAfterDays.split(" en", 2)[0];
        assertEquals("0", getDays);
    }

    public void expectedValueDays(){
        String getAfterDays = ah1.toString().substring(ah1.toString().lastIndexOf(":") + 2);
        String getDays = getAfterDays.split(" en", 2)[0];
        assertEquals("4", getDays);
    }

    public void expectedZeroDiscount(){
        String getAfterDiscount = k.toString().substring(k.toString().lastIndexOf(":") + 2);;
        String getDiscount = getAfterDiscount.split(" ", 2)[0];
        assertEquals("0,00", getDiscount);
    }

    public void expectedValueDiscount(){
        String getAfterDiscount = k.toString().substring(k.toString().lastIndexOf(":") + 2);;
        String getDiscount = getAfterDiscount.split(" ", 2)[0];
        assertEquals("10,00", getDiscount);
    }*/

}
