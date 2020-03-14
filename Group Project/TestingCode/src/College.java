import java.util.ArrayList;

public class College {
    private int collegeCode;
    private String naam;

    private TijdBlok tijdBlok;
    private CollegeType collegeType;
    private Lokaal lokaal;

    private ArrayList<Klas> klassen = new ArrayList<>();
    private ArrayList<Docent> docenten = new ArrayList<>();

    public College(int collegeCode, String naam, CollegeType collegeType, TijdBlok tijdBlok, Lokaal lokaal){
        this.collegeCode = collegeCode;
        this.naam = naam;
        this.tijdBlok = tijdBlok;
        this.collegeType = collegeType;
        this.lokaal = lokaal;
    }

    public String getTijd(){
        return tijdBlok.toString();
    }

    public String getNaam(){
        return naam;
    }
    public CollegeType getType(){return collegeType;}

    public void voegDocentToe(Docent docent){
        if(docenten.isEmpty()){docenten.add(docent);}
        else if(docenten.contains(docent)){System.out.println("College already contains " + docent.toString());}
        else{docenten.add(docent);}
    }

    public void voegKlasToe(Klas klas){
        if(klassen.isEmpty()){klassen.add(klas);}
        else if(klassen.contains(klas)){System.out.println("College already contains " + klas.toString());}
        else{klassen.add(klas);}
    }

    public String toString(){
        String output = String.format("Tijdens het %s wordt het %s %s gegeven in lokaal %s.\n",tijdBlok, collegeType, naam, lokaal);

        if(klassen.isEmpty()){
            output += "Er is nog geen klas toegevoegd.\n";
        }else{
            output += "De volgende klas(sen) worden hier verwacht:\n";
            for(Klas klas:klassen){
                output += klas + "\n";
            }
        }

        if(docenten.isEmpty()){
            output += "Er is nog geen docent toegevoegd.\n";
        }else{
            output += "De volgende docent(en) worden hier verwacht:\n";
            for(Docent docent:docenten){
                output += docent + "\n";
            }
        }
        return output;
    }

}
