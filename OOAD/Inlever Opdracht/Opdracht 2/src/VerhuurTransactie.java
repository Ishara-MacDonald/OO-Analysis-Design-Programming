import java.sql.Time;
import java.util.Date;

public class VerhuurTransactie  extends Transactie{
    private double borgTotaal;
    private double afrekenTotaal;

    public VerhuurTransactie(double borgTotaal, int transactieNr, Date datum, Time tijd, String plaats, double btwTotaal, String transactieType){
        super(transactieNr, datum, tijd, plaats, btwTotaal, transactieType);
        this.borgTotaal = borgTotaal;
    }

    public VerhuurTransactie(double borgTotaal, double totaal, int transactieNr, Date datum, Time tijd, String plaats, double btwTotaal, String transactieType){
        super(transactieNr, datum, tijd, plaats, totaal, btwTotaal, transactieType);
        this.borgTotaal = borgTotaal;
        this.afrekenTotaal = totaal;
    }

    public void voegVerhuurRegelToe(int aantal, int aantaldagen){
        Date eindDatum = super.geefDatum();
        VerhuurRegel regel = new VerhuurRegel(aantal, this.afrekenTotaal, eindDatum, aantaldagen);
        super.voegVerhuurRegelToe(regel);
    }
}
