package Opdracht8;

import static java.lang.Math.pow;

public class Auto extends Voertuig{
    private String kenteken;

    public Auto(String type, double nieuwprijs, int bouwjaar, String kenteken){
        super(type, nieuwprijs, bouwjaar);
        this.kenteken = kenteken;
    }

    public double huidigeWaarde(){
        return super.huidigeWaarde(0.7);
    }

    public boolean equals(Object andereObject){
        boolean gelijk = false;

        if(andereObject instanceof Auto){
            Auto ownedCar = (Auto) andereObject;
            if(super.equal(andereObject) &&
                this.kenteken.equals(ownedCar.kenteken)){
                gelijk = true;
            }
        }
        return gelijk;
    }

}
