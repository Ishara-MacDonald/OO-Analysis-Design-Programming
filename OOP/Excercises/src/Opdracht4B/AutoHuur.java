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

    private double totaalPrijs(){
        double totaal =  aantalDagen * gehuurdeAuto.getPrijsPerDag();
        double discount = totaal / huurder.getKorting();
        return  totaal - discount;
    }

    public String toString(){
        String auto = "er is geen auto bekend\n";
        String klant = "er is geen huurder bekend\n";
        String resultaat = "aantal dagen: 0 en dat kost 0.0";
        if((huurder != null) && (gehuurdeAuto != null)){
            auto = String.format("autotype: %s met prijs per dag %.1f\n", gehuurdeAuto, gehuurdeAuto.getPrijsPerDag());
            klant = String.format("autotype: %s met prijs per dag %.1f\n", huurder, huurder.getKorting());
            resultaat = String.format("aantal dagen: %d en dat kost %.1f", aantalDagen, totaalPrijs());
        }
        else if(gehuurdeAuto != null){
            auto = String.format("autotype: %s met prijs per dag %.1f\n", gehuurdeAuto, gehuurdeAuto.getPrijsPerDag());
        }else if(huurder != null){
            klant = String.format("autotype: %s met prijs per dag %.1f\n", huurder, huurder.getKorting());
        }
        return auto + klant + resultaat;
    }
}