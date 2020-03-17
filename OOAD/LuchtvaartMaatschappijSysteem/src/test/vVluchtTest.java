package test;

import main.domeinLaag.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.function.Try;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class vVluchtTest {

    static LuchtvaartMaatschappij lvm;
    static Fabrikant f1;
    static VliegtuigType vtt1;
    static Vliegtuig vt1, fokke;
    static Luchthaven lh1, lh2, lh3;
    static Vlucht vl1, vl2, vlucht1, vlucht2;
    DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    Calendar datum, vertrek2, aankomst2, currentTime;

    @BeforeEach
    public void initialize() {
        try {
            lvm = new LuchtvaartMaatschappij("NLM");
            f1 = new Fabrikant("Airbus", "G. Dejenelle");
            vtt1 = f1.creeervliegtuigtype("A-200", 140);
            datum = Calendar.getInstance();
            datum.set(2000, 01, 01);
            vt1 = new Vliegtuig(lvm, vtt1, "Luchtbus 100", datum);
            Land l1 = new Land("Nederland", 31);
            Land l2 = new Land("België", 32);
            lh1 = new Luchthaven("Schiphol", "ASD", true, l1);
            lh2 = new Luchthaven("Tegel", "TEG", true, l2);
            Calendar vertr = Calendar.getInstance();
            vertr.set(2020, 03, 30, 14, 15, 0);
            Calendar aank = Calendar.getInstance();
            aank.set(2020, 03, 30, 15, 15, 0);
            vl1 = new Vlucht(vt1, lh1, lh2, vertr, aank);
            vertr.set(2020, 4, 1, 8, 15, 0);
            aank.set(2020, 4, 1, 9, 15, 0);
            vl2 = new Vlucht(vt1, lh1, lh2, vertr, aank);

            Calendar vertrek1 = Calendar.getInstance();
            vertrek1.set(2025 , 07, 1, 12, 43, 0);
            Calendar aankomst1 = Calendar.getInstance();
            aankomst1.set(2025 , 07, 1, 15, 36, 0);
            currentTime = Calendar.getInstance();

            vlucht1 = new Vlucht(fokke, lh1, lh2, vertrek1, aankomst1);

            vlucht2 = new Vlucht();
            vlucht2.zetVliegtuig(fokke);
            vlucht2.zetVertrekpunt(lh3);
            vlucht2.zetBestemming(lh1);
            vertrek2 = Calendar.getInstance();
            aankomst2 = Calendar.getInstance();
        } catch (Exception e) {
            String errorMessage = "Exception: " + e.getMessage();
            System.out.println(errorMessage);
        }
    }

    /**
     * Business rule: 1
     * De bestemming moet verschillen van het vertrekpunt van de vlucht.
     */

    @Test
    public void testBestemmingMagNietGelijkZijnAanVertrek_False() {
        Vlucht vlucht = new Vlucht();
        try {
            vlucht.zetVliegtuig(vt1);
            vlucht.zetVertrekpunt(lh1);
            Luchthaven bestemming = vlucht.getBestemming();
            assertTrue(bestemming == null);
            vlucht.zetBestemming(lh1);
            // De test zou niet verder mogen komen: er moet al een exception gethrowd zijn.
            bestemming = vlucht.getBestemming();
            assertFalse(bestemming.equals(lh1));
        } catch (IllegalArgumentException e) {
            Luchthaven bestemming = vlucht.getBestemming();
            assertFalse(bestemming.equals(lh1));
        }
    }

    @Test
    public void testBestemmingMagNietGelijkZijnAanVertrek_True() {
        Vlucht vlucht = new Vlucht();
        Luchthaven bestemming;
        try {
            vlucht.zetVliegtuig(vt1);
            vlucht.zetVertrekpunt(lh2);
            bestemming = vlucht.getBestemming();
            assertTrue(bestemming == null);
            vlucht.zetBestemming(lh1);
            bestemming = vlucht.getBestemming();
            assertTrue(bestemming.equals(lh1));
        } catch (IllegalArgumentException e) {
            bestemming = vlucht.getBestemming();
            assertTrue(bestemming.equals(lh1));
        }
    }

    /**
     * Business rule: 2
     * De vertrektijd en aankomsttijd moeten geldig zijn (dus een bestaande dag/uur/minuten combinatie aangeven)
     * en in de toekomst liggen
     */
    @Test
    public void testVertrektijdEnAankomsttijdMoetenGeldigZijnEnInToekomst_GeenGeldigeVertrekTijd() {
        Vlucht vlucht1 = new Vlucht();
        try {
            vlucht1.zetVliegtuig(vt1);
            vlucht1.zetVertrekpunt(lh2);
            vlucht1.zetBestemming(lh1);
            Calendar vertr = Calendar.getInstance();
            vertr.set(2025, 9, 31, 24, 00, 00);
            vlucht1.zetVertrekTijd(vertr);

        } catch (NullPointerException | VluchtException e) {
            Calendar vertr = Calendar.getInstance();
            vertr.set(2025, 9, 31, 24, 00, 00);
            Calendar vertrektijd = vlucht1.getVertrekTijd();
            assertFalse(vertrektijd.equals(vertr));
        }
    }

    @Test
    public void testVertrektijdEnAankomsttijdMoetenGeldigZijnEnInToekomst_GeenGeldigeAankomstTijd() {
        Vlucht vlucht2 = new Vlucht();
        try {
            vlucht2.zetVliegtuig(vt1);
            vlucht2.zetVertrekpunt(lh2);
            vlucht2.zetBestemming(lh1);
            Calendar vertr = Calendar.getInstance();
            vertr.set(2025, 9, 30, 24, 00, 00);
            vlucht2.zetVertrekTijd(vertr);
            Calendar aank = Calendar.getInstance();
            aank.set(2025, 9, 30, 24, 01, 00);
            vlucht2.zetAankomstTijd(aank);

        } catch (Exception e) {
            Calendar vertr = Calendar.getInstance();
            vertr.set(2025, 9, 30, 24, 00, 00);
            Calendar aank = Calendar.getInstance();
            aank.set(2025, 9, 30, 24, 01, 00);
            Calendar vertrektijd = vlucht2.getVertrekTijd();
            Calendar aankomsttijd = vlucht2.getAankomstTijd();
            assertFalse(vertrektijd.equals(vertr));
            assertFalse(aankomsttijd.equals(aank));
        }

    }

    @Test
    // testgeval 5,8,10,20 samen
    public void testVertrektijdEnAankomsttijdMoetenGeldigZijnEnInToekomst_Test5_8_10_20True() {
        Vlucht vlucht3 = new Vlucht();
        try {
            vlucht3.zetVliegtuig(vt1);
            vlucht3.zetVertrekpunt(lh2);
            vlucht3.zetBestemming(lh1);
            Calendar vertr = Calendar.getInstance();
            vertr.set(2025, 9, 30, 12, 00, 00);
            vlucht3.zetVertrekTijd(vertr);
            Calendar aank = Calendar.getInstance();
            aank.set(2025, 9, 30, 12, 01, 00);

        } catch (Exception e) {
            Calendar vertr = Calendar.getInstance();
            vertr.set(2025, 9, 30, 12, 00, 00);
            Calendar aank = Calendar.getInstance();
            aank.set(2025, 9, 30, 12, 01, 00);
            Calendar vertrektijd = vlucht3.getVertrekTijd();
            Calendar aankomsttijd = vlucht3.getAankomstTijd();
            assertFalse(vertrektijd.equals(vertr));
            assertFalse(aankomsttijd.equals(aank));
        }
    }

    @Test
    public void testVertrektijdEnAankomsttijdMoetenGeldigZijnEnInToekomst_VertrekTijdIsNuMin1_GeenAankomstTijd() {
        Vlucht vlucht4 = new Vlucht();
        Calendar calobj = Calendar.getInstance();
        calobj.add(Calendar.MINUTE, -1);
        Date currentTime = calobj.getTime();
        try {
            vlucht4.zetVliegtuig(vt1);
            vlucht4.zetVertrekpunt(lh2);
            vlucht4.zetBestemming(lh1);

        } catch (NullPointerException e) {
            Calendar vertrektijd = vlucht4.getVertrekTijd();
            assertFalse(vertrektijd.equals(calobj));
        }

    }

    @Test
    public void testVertrektijdEnAankomsttijdMoetenGeldigZijnEnInToekomst_VertrekTijdIsNuMin2_AankomstTijdIsNuMin1() {
        Vlucht vlucht5 = new Vlucht();

        try {
            vlucht5.zetVliegtuig(vt1);
            vlucht5.zetVertrekpunt(lh2);
            vlucht5.zetBestemming(lh1);
            Calendar vertr = Calendar.getInstance();
            vertr.add(Calendar.MINUTE, -2);
            Date currentTime = vertr.getTime();

        } catch (NullPointerException e) {
            Calendar vertr = Calendar.getInstance();
            vertr.add(Calendar.MINUTE, -2);
            Calendar vertrektijd = vlucht5.getVertrekTijd();
            assertFalse(vertrektijd.equals(vertr));
        }
    }

    /**
     * Business rule:
     * De aankomsttijd moet na de vertrektijd liggen
     */

    /**
     * Business rule: 4
     * Een vliegtuig kan maar voor een vlucht tegelijk gebruikt worden
     */
    @Test
    public void testVertrektijdOverlaptMetVlucht() {
        vertrek2.set(2025 , 07, 1, 12, 43, 0);
        aankomst2.set(2025 , 07, 1, 15, 36, 0);
        try{
            vlucht2.zetVertrekTijd(vertrek2);
            vlucht2.zetAankomstTijd(aankomst2);
            assertNull(vlucht2.getVertrekTijd());
        } catch (VluchtException e) {
            assertNull(vlucht2.getVertrekTijd());
        }
    }

    @Test
    public void testAankomsttijdOverlaptMetVlucht() {
        vertrek2.set(2025 , 07, 1, 11, 36, 0);
        aankomst2.set(2025 , 07, 1, 12, 43, 0);

        try{
            vlucht2.zetVertrekTijd(vertrek2);
            vlucht2.zetAankomstTijd(aankomst2);
            assertNull(vlucht2.getAankomstTijd());
        } catch (VluchtException e) {
            assertNull(vlucht2.getAankomstTijd());
        }
    }

    @Test
    public void testBeideTijdenOverlaptMetVlucht() {
        vertrek2.set(2025 , 07, 1, 11, 36, 0);
        aankomst2.set(2025 , 07, 1, 12, 43, 0);

        try{
            vlucht2.zetVertrekTijd(vertrek2);
            vlucht2.zetAankomstTijd(aankomst2);
            assertTrue((vlucht2.getVertrekPunt()) == null && (vlucht2.getAankomstTijd()) == null);
        } catch (VluchtException e) {
            assertTrue((vlucht2.getVertrekPunt()) == null && (vlucht2.getAankomstTijd()) == null);
        }
    }

    @Test
    public void testGeenTijdOverlaptMetVlucht() {
        vertrek2.set(2025 , 07, 1, 15, 37, 0);
        aankomst2.set(2025 , 07, 1, 16, 37, 0);

        try{
            vlucht2.zetVertrekTijd(vertrek2);
            assertNotNull(vlucht2.getVertrekTijd());
            vlucht2.zetAankomstTijd(aankomst2);
            assertNotNull(vlucht2.getAankomstTijd());
        } catch (VluchtException e) {
            assertNotNull(vlucht2.getVertrekTijd());
            assertNotNull(vlucht2.getAankomstTijd());
        }
    }


    /**
     * Business rule: 5
     * Een vlucht mag alleen geaccepteerd worden als de volgende gegevens zijn vastgelegd: vliegtuig, vertekpunt, bestemming
     * vertrektijd, aankomsttijd
     */

    @Test
    public void testGeenVliegtuigIngevuld(){
        Vlucht vlucht1 = new Vlucht();

        try{
            vlucht1.zetVertrekpunt(lh1);
            vlucht1.zetBestemming(lh2);
            vlucht1.zetVertrekTijd(currentTime);
            currentTime.add(Calendar.MINUTE, 1);
            vlucht1.zetAankomstTijd(currentTime);
            assertNull(vlucht1.getVliegtuig());
        }catch (VluchtException e){
            assertNull(vlucht1.getVliegtuig());
        }
    }

    @Test
    public void testGeenVertrekpuntIngevuld(){
        Vlucht vlucht1 = new Vlucht();

        try{
            vlucht1.zetVliegtuig(vt1);
            vlucht1.zetBestemming(lh2);
            vlucht1.zetVertrekTijd(currentTime);
            currentTime.add(Calendar.MINUTE, 1);
            vlucht1.zetAankomstTijd(currentTime);
            assertNull(vlucht1.getVertrekPunt());
        }catch (VluchtException e){
            assertNull(vlucht1.getVertrekPunt());
        }
    }

    @Test
    public void testGeenBestemmingIngevuld(){
        Vlucht vlucht1 = new Vlucht();

        try{
            vlucht1.zetVliegtuig(fokke);
            vlucht1.zetVertrekpunt(lh1);
            vlucht1.zetVertrekTijd(currentTime);
            currentTime.add(Calendar.MINUTE, 1);
            vlucht1.zetAankomstTijd(currentTime);
            assertNull(vlucht1.getBestemming());
        }catch (VluchtException e){
            assertNull(vlucht1.getBestemming());
        }
    }
    @Test
    public void testGeenVertrektijdIngevuld(){
        Vlucht vlucht1 = new Vlucht();

        try{
            vlucht1.zetVliegtuig(fokke);
            vlucht1.zetVertrekpunt(lh1);
            vlucht1.zetBestemming(lh2);
            currentTime.add(Calendar.MINUTE, 1);
            vlucht1.zetAankomstTijd(currentTime);
            assertNull(vlucht1.getVertrekTijd());
        }catch (VluchtException e){
            assertNull(vlucht1.getVertrekTijd());
        }
    }

    @Test
    public void testGeenAankomstTijdIngevuld(){
        Vlucht vlucht1 = new Vlucht();
        try{
            vlucht1.zetVliegtuig(fokke);
            vlucht1.zetVertrekpunt(lh1);
            vlucht1.zetBestemming(lh2);
            vlucht1.zetVertrekTijd(currentTime);
            assertNull(vlucht1.getAankomstTijd());
        }catch (VluchtException e){
            assertNull(vlucht1.getAankomstTijd());
        }
    }

    @Test
    public void testAllesIngevuld(){
        Vlucht vlucht1 = new Vlucht();
        Calendar plusOneMinute = Calendar.getInstance();
        plusOneMinute.add(Calendar.MINUTE, 1);
        try{
            vlucht1.zetVliegtuig(fokke);
            vlucht1.zetVertrekpunt(lh1);
            vlucht1.zetBestemming(lh2);
            vlucht1.zetVertrekTijd(currentTime);


            vlucht1.zetAankomstTijd(currentTime);
            assertNotNull(vlucht1);
        }catch (VluchtException e){
            assertNotNull(vlucht1);
        }
    }
}