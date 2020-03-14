package Opdracht8;

import java.util.ArrayList;

public class BedrijfsInventaris {
    private String bedrijfsnaam;
    private double budget;

    private ArrayList<Goed> alleGoederen = new ArrayList<>();

    public BedrijfsInventaris(String bedrijfsnaam, double budget){
        this.bedrijfsnaam = bedrijfsnaam;
        this.budget = budget;
    }

    public void schafAan(Goed goed){
        System.out.println(String.format("Poging om %s toe te voegen...", goed.getType()));

        String euro = "\u20AC";

        if(!alleGoederen.contains(goed) && budget >= goed.huidigeWaarde()){
            alleGoederen.add(goed);
            budget = budget - goed.huidigeWaarde();
            System.out.print(String.format("Toevoegen van %s gelukt!\nHuidige budget: %s%.2f\n\nOverzicht huidige inventaris:\n",goed.getType(), euro, budget));
            System.out.println(toString());
        }else if(budget < goed.huidigeWaarde()){
            System.out.println(String.format("Niet genoeg geld om %s toe te voegen.\nBudget: %s%.2f    Prijs: %s%.2f", goed.getType(), euro, budget, euro, goed.huidigeWaarde()));
        }
        else{
            System.out.println(String.format("Niet gelukt om %s toe te voegen. Bedrijf bezit dit object al.", goed.getType()));
        }
        System.out.print("\n");
    }

    public String toString(){
        if(alleGoederen.isEmpty()){
            return "Lijst is leeg";
        }

        String stringGoederen = "";
        for(Goed goed: alleGoederen){
            stringGoederen += goed.toString() + "\n";
        }

        return stringGoederen;
    }
}
