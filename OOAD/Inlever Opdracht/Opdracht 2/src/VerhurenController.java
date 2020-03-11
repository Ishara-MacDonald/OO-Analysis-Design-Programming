import java.sql.Time;
import java.util.Date;

public class VerhurenController {
    public static void main(String[] args) {
        VerhuurProduct.geefAlle();
    }

    public static void selecteerProduct(VerhuurProduct product){
        product.geefBeschikbareExemplaren();
    }

    public static void verhuurExemplaar(int aantal, int aantaldagen, double bordTotaal, double totaal, int transactieNr, Date datum, Time tijd, String plaats, double btwTotaal, String transactieType){
        if(true){ //given conditions
            VerhuurTransactie verhuurTransactie = new VerhuurTransactie(bordTotaal, totaal, transactieNr, datum, tijd, plaats, btwTotaal, transactieType);
        }


        VerhuurTransactie verhuurTransactie = new VerhuurTransactie(bordTotaal, totaal, transactieNr, datum, tijd, plaats, btwTotaal, transactieType);

        verhuurTransactie.voegVerhuurRegelToe(aantal, aantaldagen);
    }

}
