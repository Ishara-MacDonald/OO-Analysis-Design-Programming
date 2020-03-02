package Opgave4_1;

public class Luchthaven {
    private String naam;
    private int code;
    private boolean werkplaats;
    private Land land;

    public Luchthaven(){}

    public Luchthaven(String naam, int code, boolean werkplaats, Land land){
        this.naam = naam;
        this.code = code;
        this.werkplaats = werkplaats;
        this.land = land;
    }

    public void setLand(Land selectedLand){
        land = selectedLand;
    }

    public void setNaam(String naam){
        if (land.getLuchthaven(naam)){this.naam = naam; }
    }

    public String getNaam(){
        return naam;
    }

    public int setCode(){
        return code;
    }

    public void setWerkplaats(){

    }

    public void bewaar(){
        land.voegLuchthavenToe(this);
    }



}
