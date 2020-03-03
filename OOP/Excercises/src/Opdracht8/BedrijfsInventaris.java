package Opdracht8;

import java.util.ArrayList;

public class BedrijfsInventaris {
    private String bedrijfsnaam;
    private double budget;

    private ArrayList<Goed> alleGoederen = new ArrayList<>();

    public  BedrijfsInventaris(String bedrijfsnaam, double budget){
        this.bedrijfsnaam = bedrijfsnaam;
        this.budget = budget;
    }

    public void schafAan(Goed goed){
        if(!alleGoederen.contains(goed) && budget >= goed.huidigeWaarde()){
            alleGoederen.add(goed);
        }else{
            System.out.println("Niet gelukt om goed toe te voegen.");
        }
    }

    public String toString(){
        if(alleGoederen.isEmpty()){
            return "Lijst is leeg";
        }
        String stringGoederen = "";

        for(Goed goed: alleGoederen){
            stringGoederen += goed.toString();
        }

        return stringGoederen;
    }
}
