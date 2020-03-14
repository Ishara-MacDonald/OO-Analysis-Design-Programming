package Opdracht2B;

public class VoetbalClub {

    private String clubNaam;

    private int aantalGewonnen;
    private int aantalGelijk;
    private int aantalVerloren;

    public VoetbalClub(String clubNaam){
        if(clubNaam == null || clubNaam.equals("") || clubNaam.equals(" ")){
            this.clubNaam = "FC";
        }else{
            this.clubNaam = clubNaam;
        }
    }

    public String getClubNaam(){return clubNaam;}
    public int getAantalGewonnen(){return aantalGewonnen;}
    public int getAantalGelijk(){return aantalGelijk;}
    public int getAantalVerloren(){return aantalVerloren;}

    public void setClubNaam( String clubNaam){this.clubNaam = clubNaam;}
    public void setAantalGewonnen(int aantalGewonnen){this.aantalGewonnen = aantalGewonnen;}
    public void setAantalGelijk(int aantalGelijk){this.aantalGelijk = aantalGelijk;}
    public void setAantalVerloren(int aantalVerloren){this.aantalVerloren = aantalVerloren;}

    public void verwerkResultaat(char ch) {
        if (ch == 'w')
            aantalGewonnen = aantalGewonnen + 1;
        if (ch == 'g')
            aantalGelijk = aantalGelijk + 1;
        if (ch == 'v')
            aantalVerloren = aantalVerloren + 1;
    }

    public int aantalPunten(){
        return (aantalGewonnen * 3) + aantalGelijk;
    }

    public int aantalGespeeld(){
        return aantalGelijk + aantalVerloren + aantalGewonnen;
    }

    public String toString(){
        return String.format("%s  %d %d %d %d %d", clubNaam, aantalGespeeld() , aantalGewonnen, aantalGelijk, aantalVerloren, aantalPunten());
    }
}

