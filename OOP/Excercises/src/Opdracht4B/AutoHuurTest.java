package Opdracht4B;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

class AutoHuurTest {
    Auto a1;
    Klant k;
    AutoHuur ah1;
    @BeforeEach
    public void setTestVoetbalClub(){
        ah1 = new AutoHuur();
        k = new Klant("Mijnheer de Vries");
        a1 = new Auto("Peugeot 207", 50);
    }

    //Test 1
    @Test
    public void testNoData(){
        System.out.println("Test 1, no data\n");
        ah1 = new AutoHuur();
    }

    //Test 2
    @Test
    public void testDiscountOnly(){
        System.out.println("Test 2, discount only\n");
        k.setKorting(10.0);
    }

    //Test 3
    @Test
    public void testCarOnly(){
        System.out.println("Test 3, car only\n");
        ah1.setGehuurdeAuto(a1);
    }

    //Test 4
    @Test
    public void testDiscountCar(){
        System.out.println("Test 4, discount and car\n");
        ah1.setGehuurdeAuto(a1);
        k.setKorting(10.0);
    }

    //Test 5
    @Test
    public void testDaysOnly(){
        System.out.println("Test 5, days only\n");
        ah1.setAantalDagen(4);
    }

    //Test 6
    @Test
    public void testDiscountDays(){
        System.out.println("Test 6, discount and days\n");
        ah1.setAantalDagen(4);
        k.setKorting(10.0);
    }

    //Test 7
    @Test
    public void testCarDays(){
        System.out.println("Test 7, car and days\n");
        ah1.setAantalDagen(4);
        ah1.setGehuurdeAuto(a1);
    }

    //Test 8
    @Test
    public void testNoRenter(){
        System.out.println("Test 8, all but renter\n");
        ah1.setAantalDagen(4);
        ah1.setGehuurdeAuto(a1);
        k.setKorting(10.0);
    }

    //Test 9
    @Test
    public void testRenterOnly(){
        System.out.println("Test 9, renter only\n");
        ah1.setHuurder(k);
    }

    //Test 10
    @Test
    public void testRenterDiscount(){
        System.out.println("Test 10, renter and discount\n");
        ah1.setHuurder(k);
        k.setKorting(10.0);
    }

    //Test 11
    @Test
    public void testRenterCar(){
        System.out.println("Test 11, renter and car\n");
        ah1.setHuurder(k);
        ah1.setGehuurdeAuto(a1);
    }

    //Test 12
    @Test
    public void testNoDays(){
        System.out.println("Test 12, all but days\n");
        ah1.setHuurder(k);
        ah1.setGehuurdeAuto(a1);
        k.setKorting(10.0);
    }

    //Test 13
    @Test
    public void testRenterDays(){
        System.out.println("Test 13, renter and days\n");
        ah1.setHuurder(k);
        ah1.setAantalDagen(4);
        expectedPrice();
    }

    //Test 14
    @Test
    public void testNoCar(){
        System.out.println("Test 14, all but car\n");
        ah1.setHuurder(k);
        ah1.setAantalDagen(4);
        k.setKorting(10.0);
        expectedPrice();
    }

    //Test 15
    @Test
    public void testNoDiscount(){
        System.out.println("Test 15, all but discount\n");
        ah1.setHuurder(k);
        ah1.setAantalDagen(4);
        ah1.setGehuurdeAuto(a1);
    }

    //Test 16
    @Test
    public void testAll(){
        System.out.println("Test 16, all\n");
        ah1.setHuurder(k);
        ah1.setAantalDagen(4);
        ah1.setGehuurdeAuto(a1);
        k.setKorting(10.0);
        expectedPrice();
    }

    @AfterEach
    public void showData(){
        System.out.println(ah1);
        System.out.println("\n");
    }

    public void expectedPrice(){
        String getPrice = ah1.toString().substring(ah1.toString().lastIndexOf(' ') + 1);
        double getResult = Double.parseDouble(getPrice);
        assertEquals(0.0, getResult);
    }

}