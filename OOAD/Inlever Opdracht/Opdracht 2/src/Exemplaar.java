import java.util.ArrayList;
import java.util.Date;

public class Exemplaar {
    private Date aanschafDatum;
    private int serieNr;
    private String status;

    private ArrayList<VerhuurRegel> regels = new ArrayList<>();

    public Exemplaar(Date aanschafDatum, int serieNr, String status){
        this.aanschafDatum = aanschafDatum;
        this.serieNr = serieNr;
        this.status = status;
    }

    public void geefDetails(){}

    public void isVerhuurd(){
        for(VerhuurRegel regel: regels){regel.geefPeriode();}
    }

}
