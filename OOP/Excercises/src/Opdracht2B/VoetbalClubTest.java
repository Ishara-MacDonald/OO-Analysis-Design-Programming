package Opdracht2B;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoetbalClubTest {
    VoetbalClub feij;
    int count;
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
    public void testString(){
        String s1 = feij.toString().split(" ", 2)[1];
        assertEquals(" 0 0 0 0 0", s1);
    }

    @Test
    public void testHerhaalGespeeld(){
        count = 0;
        for (int i = 0; i<=10; i++){
            resultaatToevoegen();
        }
        assertEquals(count, feij.aantalGespeeld());
    }

    @Test
    public void testHerhaalPunten(){
        for (int i = 0; i<=10; i++){
            resultaatToevoegen();
            krijgScoreTotaal();
        }
    }

    public void krijgScoreTotaal(){
        String krijgScore = feij.toString().substring(feij.toString().lastIndexOf(' ') + 1);
        int omgezetteResultaat = Integer.parseInt(krijgScore);
        assertEquals(omgezetteResultaat, feij.aantalPunten());
    }

    public void resultaatToevoegen(){
        feij.verwerkResultaat('w');
        feij.verwerkResultaat('g');
        feij.verwerkResultaat('v');
        count +=3;
    }
}