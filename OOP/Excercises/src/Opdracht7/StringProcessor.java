package Opdracht7;

import java.util.ArrayList;

//Maakt bewerkingen op een stuk tekst/ String.
public class StringProcessor {
    private ArrayList<OpmaakProces> processen = new ArrayList<OpmaakProces>();

    public StringProcessor(){}

    public String verwerk(String input){
        for(OpmaakProces proces: processen){
            input = proces.maakOp(input);
        }
        return input;
    }

    public void voegProcesToe(OpmaakProces proces){
        processen.add(proces);
    }
}
