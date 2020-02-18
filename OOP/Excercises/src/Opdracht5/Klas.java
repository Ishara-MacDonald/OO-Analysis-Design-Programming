package Opdracht5;

import java.util.ArrayList;

public class Klas {
    private String klasCode;
    private ArrayList<Leerling> leerlingen;

    public Klas(String klascode){
        this.klasCode = klascode;
        this.leerlingen = new ArrayList<>();
    }

    public void voegLeerlingToe(Leerling leerling){
        leerlingen.add(leerling);
    }

    public void wijzigCijfer(String naam, double nieuweCijfer){
        for(Leerling leerling : leerlingen){
            if(naam.equals(leerling.getNaam())){
                leerling.setCijfer(nieuweCijfer);
            }
        }
    }

    public ArrayList<Leerling> getLeerlingen(){
        return leerlingen;
    }

    public int aantalLeerlingen(){
        return leerlingen.size();
    }

    public String toString(){
        String klasEnAantal = String.format("In klas %s zutten de volgende leerlingen\n", klasCode);
        String klasGenoten = "";
        for(Leerling leerling : leerlingen){
            klasGenoten = klasGenoten + leerling + "\n";
        }
        return klasEnAantal + klasGenoten;
    }
}
