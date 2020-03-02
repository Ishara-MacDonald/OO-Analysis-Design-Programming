package Opgave4_1;

import java.util.HashSet;
import java.util.TreeMap;

public class RegistreerLuchthaven {
    private Land land;
    private Luchthaven lh;
    private TreeMap<String, Land> alleLanden;

    private void start(){
        alleLanden = Land.getAlleLanden();
        lh = new Luchthaven();
    }

    public int landNaam(){
        lh.setLand(land);

        return land.getCode();
    }

    private void naam(String naam){
        lh.setNaam(naam);
    }

    private void code(){
        lh.setCode();
    }

    private void werkplaats(){
        lh.setWerkplaats();
    }

    public void ok(){
        lh.bewaar();
    }

}
