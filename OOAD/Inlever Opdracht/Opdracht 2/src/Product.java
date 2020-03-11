public class Product {
    private int productNr;
    private String omschrijving;
    private double prijs;

    public Product(int productNr, String omschrijving, double prijs){
        this.productNr = productNr;
        this.omschrijving = omschrijving;
        this.prijs = prijs;
    }

    public String geefOmschrijving(){
        return this.omschrijving;
    }

}
