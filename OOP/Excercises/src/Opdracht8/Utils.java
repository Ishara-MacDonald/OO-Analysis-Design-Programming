package Opdracht8;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

public class Utils {
    private static int countAll = 0;
    private static int countNormal = 0;
    private static int countAdjusted = 0;
    private static String euro = "\u20AC";

    public static String euroBedrag(double bedrag) {
        countAll++;
        countNormal++;
        return String.format(Locale.ENGLISH,"%s %.2f", euro, bedrag);
    }

    public static String euroBedrag(double bedrag, int precisie) {
        countAll++;
        countAdjusted++;
        BigDecimal bd = new BigDecimal(bedrag).setScale(precisie, RoundingMode.HALF_UP);
        return euro + " " + bd;
    }

    public static String getCount(){
        return String.format("Standaard methode is %d keer gebruikt.\nAangepaste methode is %d keer gebruikt.\nIn totaal is de methode euroBedrag %d keer gebruikt.", countNormal, countAdjusted, countAll);
    }

}
