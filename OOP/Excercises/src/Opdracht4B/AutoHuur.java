package Opdracht4B;

public class AutoHuur {
    private int aantalDagen;
    private Auto gehuurdeAuto;
    private Klant huurder;

    public AutoHuur(){
        this.huurder = null;
        this.gehuurdeAuto = null;
    }

    public void setAantalDagen(int aantalDagen) {this.aantalDagen = aantalDagen;}
    public int getAantalDagen() {return aantalDagen;}

    public void setGehuurdeAuto(Auto gehuurdeAuto){
        this.gehuurdeAuto = gehuurdeAuto;
    }
    public Auto getGehuurdeAuto(){
        return gehuurdeAuto;
    }

    public void setHuurder(Klant klant){
        this.huurder = klant;
    }
    public Klant getHuurder(){
        return huurder;
    }

    public double totaalPrijs(){
        double discount;
        double percentageDiscouunt = huurder.getKorting();
        double totaal =  aantalDagen * gehuurdeAuto.getPrijsPerDag();

        if(percentageDiscouunt != 0.0){discount = totaal / percentageDiscouunt;}
        else{discount = 0.0;}

        return  totaal - discount;
    }

    public String toString(){
        String auto = "er is geen auto bekend\n";
        String klant = "er is geen huurder bekend\n";
        String resultaat = "aantal dagen: 0 en dat kost 0.0";

        if((huurder != null) && (gehuurdeAuto != null)){
            auto = gehuurdeAuto.toString();
            klant = huurder.toString();
            resultaat = String.format("aantal dagen: %d en dat kost %.1f\n", aantalDagen, totaalPrijs());
        }
        else if(gehuurdeAuto != null){
            auto = gehuurdeAuto.toString();
        }else if(huurder != null){
            klant = huurder.toString();
        }
        return auto + klant + resultaat;
    }
}