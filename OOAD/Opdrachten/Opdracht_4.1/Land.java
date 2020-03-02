public class Land {
    private Luchthaven bestaande = new Luchthaven();
    public Land(){}

    public Luchthaven geefLuchthaven(String naam){
        while(true){
            bestaande.geefNaam();
        }
    }
}
