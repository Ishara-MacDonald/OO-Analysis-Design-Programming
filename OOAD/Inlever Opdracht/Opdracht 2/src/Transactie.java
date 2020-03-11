import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;


public class Transactie{
    private int transactieNr;
    private Date datum;
    private Time tijd;
    private String plaats;
    private double totaal;
    private double btwTotaal;
    private String transactieType;

    private Klant klant;
    private ArrayList<TransactieRegel> regels = new ArrayList<>();

    public Transactie(int transactieNr, Date datum, Time tijd, String plaats, double btwTotaal, String transactieType){
        this.transactieNr = transactieNr;
        this.datum = datum;
        this.tijd = tijd;
        this.plaats = plaats;
        this.btwTotaal = btwTotaal;
        this.transactieType = transactieType;
    }

    public Transactie(int transactieNr, Date datum, Time tijd, String plaats, double totaal, double btwTotaal, String transactieType){
        this.transactieNr = transactieNr;
        this.datum = datum;
        this.tijd = tijd;
        this.plaats = plaats;
        this.totaal = totaal;
        this.btwTotaal = btwTotaal;
        this.transactieType = transactieType;
    }

    public Date geefDatum(){return this.datum;}

    public void voegVerhuurRegelToe(TransactieRegel regel){
        regels.add(regel);
    }


}
