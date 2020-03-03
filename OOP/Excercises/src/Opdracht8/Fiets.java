package Opdracht8;

public class Fiets extends Voertuig{
    private int frameNummer;

    public Fiets(String type, double nieuwprijs, int bouwjaar, int frameNummer){
        super(type, nieuwprijs, bouwjaar);
        this.frameNummer = frameNummer;
    }

    public double huidigeWaarde(){
        return 0.0;
    }

    public boolean equals(Object object){
        boolean gelijk = false;

        return gelijk;
    }

}
