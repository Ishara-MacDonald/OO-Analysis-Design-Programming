package Opdracht2B;

public class Main {
    public static void main(String[] args) {
        VoetbalClub ajx = new VoetbalClub("Ajax      ");
        VoetbalClub feij = new VoetbalClub("Feijenoord");

        feij.verwerkResultaat('w');
        feij.verwerkResultaat('v');
        feij.verwerkResultaat('w');
        feij.verwerkResultaat('g');

        ajx.verwerkResultaat('w');
        ajx.verwerkResultaat('w');
        ajx.verwerkResultaat('g');
        ajx.verwerkResultaat('w');
        ajx.verwerkResultaat('w');

        System.out.println("Feijenoord punten: " + feij.aantalPunten());
        System.out.println("Ajax gespeeld: " + ajx.aantalGespeeld());
        System.out.println();

        System.out.println(ajx);
        System.out.println(feij);
    }
}
