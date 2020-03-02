package Opgave4_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

public class Land {
    private static ArrayList<Land> alleLanden;
    private HashSet<Luchthaven> luchthavens;

    private String naam;
    private int code;

    public static TreeMap<String,Land> getAlleLanden(){
        TreeMap<String,Land> landenMap = new TreeMap<String,Land>();

        for(Land l:alleLanden){
            landenMap.put(l.getNaam(), l);
        }

        return landenMap;
    }

    public String getNaam(){ return naam;}

    public int getCode(){
        return code;
    }

    public boolean getLuchthaven(String naam){
        for(Luchthaven luchthaven: luchthavens){
            if (luchthaven.getNaam().equals(naam)){
                return false;
            }
        }
        return true;
    }

    public void voegLuchthavenToe(Luchthaven lh){
    }


}
