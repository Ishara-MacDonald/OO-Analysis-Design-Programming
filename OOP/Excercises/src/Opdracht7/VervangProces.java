package Opdracht7;

// Vervangt oude String in de hele tekst door een nieuwe String.
// Basically een zoek-vervang functie. Zoekt in de hele tekst een String en vervangt
// alle gevallen waar deze String voorkomt.
public class VervangProces implements OpmaakProces{
    private String oud;
    private String nieuw;

    public VervangProces(String oud, String nieuw){
        this.oud = oud;
        this.nieuw = nieuw;
    }

    public String maakOp(String input){
        return input.replaceAll(oud,nieuw);
    }
}
