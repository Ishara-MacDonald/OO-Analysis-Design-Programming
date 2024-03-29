package Opdracht8;

import java.time.LocalDate;
import java.util.Locale;

public abstract class Voertuig implements Goed{
    private String type;

    protected double nieuwprijs;
    protected int bouwjaar;

    public Voertuig(String type, double nieuwprijs, int bouwjaar){
        this.type = type;
        this.nieuwprijs = nieuwprijs;
        this.bouwjaar = bouwjaar;
    }

    public String getType(){ return type;}

    public double huidigeWaarde(double percentage){
        int verschilJaar = bouwjaar - LocalDate.now().getYear();;
        double huidigePrijs = nieuwprijs;

        for(int i = 0; i <= verschilJaar; i++){
            huidigePrijs = huidigePrijs * percentage;
        }

        return huidigePrijs;
    }

    public boolean equal(Object andereObject){
        boolean gelijk = false;

        if(andereObject instanceof Voertuig){
            Voertuig ownedVoertuig = (Voertuig) andereObject;
            if(this.type.equals(ownedVoertuig.type) &&
                    this.bouwjaar == ownedVoertuig.bouwjaar &&
                    this.nieuwprijs == ownedVoertuig.nieuwprijs){
                gelijk = true;
            }
        }
        return gelijk;
    }

    public String toString(){
        String utilsToepassen = Utils.euroBedrag(this.huidigeWaarde(), 4);
        return String.format("Voertuig: %s met bouwjaar %d heeft een waarde van: %s.",type, bouwjaar, utilsToepassen);
    }

}
