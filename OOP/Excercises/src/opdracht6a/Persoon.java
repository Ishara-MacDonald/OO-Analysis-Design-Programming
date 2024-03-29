package opdracht6a;

import java.util.ArrayList;
import java.util.Locale;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> games = new ArrayList<>();

    public Persoon(String naam, double budget){
        this.naam = naam;
        this.budget = budget;
    }

    public double getBudget() {
        return this.budget;
    }

    public boolean koop(Game newGame){
        if(!games.contains(newGame) && budget >= newGame.huidigeWaarde()){
            games.add(newGame);
            budget = budget- newGame.huidigeWaarde();
            return true;
        }

        return false;
    }

    public boolean verkoop(Game sellingGame, Persoon koper){
        //heeft de verkoper dit spel wel?
        boolean validSale = false;
        if(!games.isEmpty()){
            for(Game game : games){
                if(game.equals(sellingGame)){validSale = true;}} //true --> verkoper heeft het spel!
            if(!validSale){return false;}
        }else{return false;}

        // heeft de koper dit spel al?
        if(!koper.games.isEmpty()) {
            for (Game ownedGame : koper.games) {
                if (ownedGame.equals(sellingGame)) {return false;}
            }
        }

        //heeft de koper genoeg geld voor dit spel?
        double huidigeWaarde = sellingGame.huidigeWaarde();

        if(koper.budget < huidigeWaarde){return false;} //false --> niet gelukt!
        koper.budget = koper.budget - huidigeWaarde;
        koper.games.add(sellingGame);

        budget = budget + huidigeWaarde;
        games.remove(sellingGame);

        return true;
    }

    public String toString(){
        String euro = "\u20ac";
        String persoon = String.format(Locale.ENGLISH,"%s heeft een budget van %s%.2f en bezit de volgende games:\n", naam, euro, budget);
        String game = "";
        for(Game ownedGame : games){
            game = game + ownedGame.toString();
        }

        if(games.isEmpty()){
            game = String.format(Locale.ENGLISH,"%s bezit nog geen games.\n", naam);
        }

        return persoon + game;
    }



}


