import java.util.ArrayList;
import java.util.Date;

public class VerhuurRegel extends TransactieRegel{
    private Date eindDatum;
    private int aantalDagen;

    private Exemplaar exemplaar;

    public VerhuurRegel(int aantal, double regelTotaal, Date eindDatum, int aantalDagen){
        super(aantal, regelTotaal);
        this.aantalDagen = aantalDagen;
        this.eindDatum = eindDatum;
    }
}
