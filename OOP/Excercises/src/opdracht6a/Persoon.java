package opdracht6a;

import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames;

    public Persoon(String naam, double budget){
        this.naam = naam;
        this.budget = budget;
        this.mijnGames = new ArrayList<>();
    }

    public double getBudget() {
        return this.budget;
    }

    public boolean koop(Game game){
        if(mijnGames.contains(game)){
            return false;
        }else{mijnGames.add(game);}
        System.out.println(mijnGames);

        double huidigeWaarde = game.huidigeWaarde();
        boolean result = budget > huidigeWaarde;
        if(result){budget = budget - huidigeWaarde;}

        return result;
    }

    public boolean verkoop(Game game, Persoon koper){
        return false;
    }

    public String toString(){
        return naam;
    }
}
