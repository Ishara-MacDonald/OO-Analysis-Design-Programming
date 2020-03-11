import java.util.ArrayList;

public class VerhuurProduct extends Product{
    private double verhuurPrijs;
    private double borg;
    private static ArrayList<Product> alleVerhuurProducten = new ArrayList<>();
    private ArrayList<Exemplaar> exemplaren = new ArrayList<>();

    public VerhuurProduct(int productNR, String omschrijving, double prijs, double verhuurPrijs, double borg, ArrayList<Product> alleVerhuurProducten){
        super(productNR, omschrijving, prijs);
        this.verhuurPrijs = verhuurPrijs;
        this.borg = borg;
        this.alleVerhuurProducten = alleVerhuurProducten;
    }

    public static String geefAlle(){
        String output = "";
        for(Product product : alleVerhuurProducten){output += product.geefOmschrijving();}
        return output;
    }

    public void geefBeschikbareExemplaren(){
        for(Exemplaar exemplaar : exemplaren){
            exemplaar.geefDetails();
            exemplaar.isVerhuurd();
        }
    }



}
