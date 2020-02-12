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
        double totaal =  aantalDagen * gehuurdeAuto.getPrijsPerDag();
        double discount = totaal / huurder.getKorting();
        return  totaal - discount;
    }

    // Verbeterpunten?
    public String toString(){
        String geenAuto = "er is geen auto bekend\n";;
        String geenKlant = "er is geen huurder bekend\n";;
        String auto;
        String klant;
        String resultaat;
        if ((huurder == null) && (gehuurdeAuto == null)) {
            auto = geenAuto;
            klant = geenKlant;
        }else if(huurder == null){
            auto = String.format("autotype: %s \n", gehuurdeAuto.toString());
            klant = geenKlant;
        }else if(gehuurdeAuto == null){
            auto = geenAuto;
            klant = String.format("op naam van: %s \n", huurder.toString());
        }else{
            auto = String.format("autotype: %s \n", gehuurdeAuto.toString());
            klant = String.format("op naam van: %s \n", huurder.toString());
        }
        if((huurder == null) || (gehuurdeAuto == null)) {
            resultaat = "aantal dagen: 0 en dat kost 0.0\n";
        }else{
            resultaat = String.format("aantal dagen: %d en dat kost %.1f\n", aantalDagen, totaalPrijs());
        }
        return auto + klant + resultaat;
    }
}
/*
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
        return 0.1;
    }

    public String toString(){
        String auto = "er is geen auto bekend";;
        String klant = "er is geen huurder bekend";;
        String resultaat = "aantal dagen: 0 en dat kost 0.0\n";
        if((huurder != null) && (gehuurdeAuto != null)){
            auto = String.format("autotype: %s met prijs per dag %2f\n", gehuurdeAuto, gehuurdeAuto.getPrijsPerDag());
            klant = String.format("autotype: %s met prijs per dag %2f", huurder, huurder.getKorting());
            resultaat = "10\n";
        }
        else if(huurder == null){
            auto = String.format("autotype: %s met prijs per dag %2f\n", gehuurdeAuto, gehuurdeAuto.getPrijsPerDag());
        }else if(gehuurdeAuto == null) {
            klant = String.format("autotype: %s met prijs per dag %2f\n", huurder, huurder.getKorting());
        }

        System.out.println(auto);
        System.out.println(klant);
        System.out.println(resultaat);

        return auto + klant + resultaat;
    }
}

 */