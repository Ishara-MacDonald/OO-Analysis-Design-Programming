package Opdracht7;

// Zet hele tekst om naar hoofdletters
public class HoofdletterProces implements OpmaakProces{

    public HoofdletterProces(){}

    public String maakOp(String input) {
        return input.toUpperCase();
    }
}
