package Practicum2;

public class Zwembad {
    private double breedte;
    private double lengte;
    private double diepte;

    public Zwembad(){}
    public Zwembad(double breedte, double lengte, double diepte){
        this.breedte = breedte;
        this.lengte = lengte;
        this.diepte = diepte;
    }

    public double getBreedte(){ return breedte;}
    public double getDiepte(){ return diepte;}
    public double getLengte(){ return lengte;}

    public void setBreedte(double breedte){ this.breedte = breedte;}
    public void setLengte(double lengte){ this.lengte = lengte;}
    public void setDiepte(double diepte){ this.diepte = diepte;}

    public double inhoud(){
        double inhoud = breedte * lengte * diepte;
        return inhoud;
    }

    public String toString(){
        String s = "Dit zwembad is " + breedte + " meter breed, " + lengte +  " meter lang, en " + diepte + " meter diep";
        return s;
    }
}
