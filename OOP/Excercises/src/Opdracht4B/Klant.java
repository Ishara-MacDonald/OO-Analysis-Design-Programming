package Opdracht4B;

public class Klant {
    private String naam;
    private double kortingsPercentage;

    public Klant(String naam){
        this.naam = naam;
    }

    public void setKorting(double kortingsPercentage) {this.kortingsPercentage = kortingsPercentage;}
    public double getKorting() {return kortingsPercentage;}

    public String toString() {
        return String.format("%s (korting: %.2f procent)", naam, kortingsPercentage);
    }
}
