package opdracht6a;

import java.time.LocalDate;

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
        return false;
    }

    public String toString(){
        return "heyt";
    }

}
