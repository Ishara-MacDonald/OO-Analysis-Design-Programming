package Opdracht3_2;

public class Vliegtuigtype {

    private String code;
    private int capaciteit;
    private Fabrikant fabrikant;

    public Vliegtuigtype(Fabrikant fabrikant, String code, int capaciteit){
        this.code = code;
        this.capaciteit = capaciteit;
        this.fabrikant = fabrikant;
    }

    public int geefCapaciteit(){
        return capaciteit;
    }
}
