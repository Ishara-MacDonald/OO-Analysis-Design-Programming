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
        String klas = String.format("In klas %s zitten de volgende leerlingen\n", klasCode);
        String leerlingenEnCijfers = "";
        for(Leerling leerling : leerlingen){
            leerlingenEnCijfers = leerlingenEnCijfers + leerling + "\n";
        }
        return klas + leerlingenEnCijfers;
    }
}
