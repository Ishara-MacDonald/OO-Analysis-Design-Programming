package Opdracht8;

public class Auto extends Voertuig{
    private String kenteken;

    public Auto(String type, double nieuwprijs, int bouwjaar, String kenteken){
        super(type, nieuwprijs, bouwjaar);
        this.kenteken = kenteken;
    }

    public double huidigeWaarde(){
        return 0.0;
    }

    public boolean equals(Object obj){
        boolean gelijk = false;

        return gelijk;
    }

}
