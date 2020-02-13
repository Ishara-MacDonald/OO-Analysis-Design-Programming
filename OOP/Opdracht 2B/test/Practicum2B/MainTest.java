package Practicum2B;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    VoetbalClub feij;
    @BeforeEach
    public void setTestVoetbalClub(){
        feij = new VoetbalClub("Feijnoord");
    }

    @Test
    public void TestVoorNull(){
        VoetbalClub ajx = new VoetbalClub(" ");
        String krijgNaam = ajx.toString().split(" ")[0];
        assertEquals("FC", krijgNaam);
    }

    @Test
    public void TestVoorFoutieveInvoer(){
        feij.verwerkResultaat('a');
        assertEquals(0, feij.aantalPunten());
    }

    @Test
    public void TestString(){
        String s1 = feij.toString().split(" ", 2)[1];
        assertEquals("0 0 0 0 0", s1);
    }

    @Test
    public void TestHerhaal(){
        int count = 0;
        int punt = 0;
        for (int i = 0; i<=10; i++){
            feij.verwerkResultaat('w');
            feij.verwerkResultaat('v');
            feij.verwerkResultaat('w');
            feij.verwerkResultaat('g');
            count += 1;
        }
        assertEquals(count, feij.aantalGespeeld());
        assertEquals(punt, feij.aantalPunten());
    }

}