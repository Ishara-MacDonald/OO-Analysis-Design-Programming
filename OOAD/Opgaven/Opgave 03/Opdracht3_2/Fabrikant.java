package Opdracht3_2;

import java.util.HashSet;
import java.util.TreeMap;

public class Fabrikant {

    private String naam;
    private HashSet<Fabrikant> alleFabrikanten;
    private static HashSet<Vliegtuigtype> vliegtuigTypen;

    public TreeMap<String, Vliegtuigtype> geefAlle(){}

    private HashSet<Fabrikant> geefAlleFabrikanten(){
        return alleFabrikanten;
    }
}
