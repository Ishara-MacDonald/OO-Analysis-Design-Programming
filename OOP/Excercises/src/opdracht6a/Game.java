package opdracht6a;

import java.time.LocalDate;
import java.util.Locale;

public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwPrijs;
    int huidigJaar = LocalDate.now().getYear();

    public Game(String naam, int releaseJaar, double nieuwPrijs){
        this.naam = naam;
        this.releaseJaar = releaseJaar;
        this.nieuwPrijs = nieuwPrijs;
    }

    public String getNaam(){
        return this.naam;
    }

    public double huidigeWaarde(){
        int verschilJaar = huidigJaar - releaseJaar;
        double huidigePrijs = nieuwPrijs;

        for(int i = 0; i < verschilJaar; i++) {
            huidigePrijs = huidigePrijs * 0.7;
        }
        return huidigePrijs;
    }

    public boolean equals(Object andereObject){
        boolean heeftSpelAl = true;

        if(andereObject instanceof Game){
            Game ownedGame = (Game) andereObject;
            if(this.naam.equals(ownedGame.naam) &&
                    (this.releaseJaar == ownedGame.releaseJaar)){
                heeftSpelAl = false;
            }
        }
        return !heeftSpelAl;
    }

    public String toString(){
        String euro = "\u20ac";

        return String.format(Locale.ENGLISH,"%s, uitgegeven in %s; nieuwprijs: %s%.2f nu voor: %s%.2f\n", naam, releaseJaar, euro, nieuwPrijs, euro, huidigeWaarde());
    }

}
