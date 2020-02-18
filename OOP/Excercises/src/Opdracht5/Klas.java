package Opdracht5;

import java.util.ArrayList;

public class Klas {
    private String klasCode;
    private ArrayList<Leerling> leerlingen = new ArrayList<Leerling>();

    public Klas(String klascode){
        this.klasCode = klascode;
    }

    public void voegLeerlingToe(Leerling leerling){
    }

    public void wijzigCijfer(String naam, double nieuweCijfer){

    }

    public ArrayList<Leerling> getLeerlingen(){

        return leerlingen;
    }

    public int aantalLeerlingen(){
        return 3;
    }

    public String toString(){
        for (Leerling leerling: leerlingen) {
            System.out.println(leerling);
        }
        return klasCode;
    }



}
