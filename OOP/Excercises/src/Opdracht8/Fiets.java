package Opdracht8;

import static java.lang.Math.pow;

public class Fiets extends Voertuig{
    private int frameNummer;

    public Fiets(String type, double nieuwprijs, int bouwjaar, int frameNummer){
        super(type, nieuwprijs, bouwjaar);
        this.frameNummer = frameNummer;
    }

    public double huidigeWaarde(){
        return super.huidigeWaarde(0.9);
    }

    public boolean equals(Object andereObject){
        boolean gelijk = false;

        if(andereObject instanceof Fiets){
            Fiets ownedBike = (Fiets) andereObject;
            if(super.equal(andereObject) &&
                    this.frameNummer == ownedBike.frameNummer){
                gelijk = true;
            }
        }
        return gelijk;
    }

}
