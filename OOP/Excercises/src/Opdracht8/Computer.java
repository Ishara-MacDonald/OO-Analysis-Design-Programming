package Opdracht8;

import opdracht6a.Game;

import static java.lang.Math.pow;
import java.time.LocalDate;
import java.util.Locale;

public class Computer implements Goed {
    private String type;
    private String macAdres;
    private double aanschafPrijs;
    private int productieJaar;

    public Computer(String type, String macAdres, double aanschafPrijs, int productieJaar){
        this.type = type;
        this.macAdres = macAdres;
        this.aanschafPrijs = aanschafPrijs;
        this.productieJaar = productieJaar;
    }

    public String getType(){return type;}

    public double huidigeWaarde() {
        int verschilJaar = productieJaar - LocalDate.now().getYear();
        double huidigePrijs = aanschafPrijs;

        for(int i = 0; i <= verschilJaar; i++){
            huidigePrijs = huidigePrijs * 0.6;
        }

        return huidigePrijs;
    }

    public boolean equals(Object andereObject){
        boolean gelijk = false;

        if(andereObject instanceof Computer){
            Computer ownedPC = (Computer) andereObject;
            if(this.type.equals(ownedPC.type) &&
                    this.macAdres.equals(ownedPC.macAdres) &&
                    this.productieJaar == ownedPC.productieJaar &&
                    this.aanschafPrijs == ownedPC.aanschafPrijs){
                gelijk = true;
            }
        }
        return gelijk;
    }

    public String toString(){
        String utilsToepassen = Utils.euroBedrag(huidigeWaarde());
        return String.format("Computer: %s, gemaakt in %d heeft een waarde van: %s, met mac adres %s",type, productieJaar, utilsToepassen, macAdres);
    }
}
