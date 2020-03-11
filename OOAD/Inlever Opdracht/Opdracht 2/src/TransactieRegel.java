import java.util.Date;

public class TransactieRegel {
    private int aantal;
    private double regelTotaal;

    private Product product;
    private Transactie transactie;

    public TransactieRegel(int aantal, double regelTotaal){
        this.aantal = aantal;
        this.regelTotaal = regelTotaal;
    }

    public Date geefPeriode(){ return transactie.geefDatum(); }
}

