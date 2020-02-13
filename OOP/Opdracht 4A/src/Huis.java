public class Huis {
    private String adres;
    private int bouwjaar;
    private Persoon huisbaas;

    public Huis(String adres, int bouwjaar){
        this.adres = adres;
        this.bouwjaar = bouwjaar;
    }

    public void setHuisbaas(Persoon huisbaas){this.huisbaas = huisbaas;}
    public Persoon getHuisbaas(){ return huisbaas;}

    public String toString(){
        String huis = String.format("Huis %s is gebouwd in %d\n", adres, bouwjaar);
        String hsb = "en heeft huisbaas " + huisbaas.toString();
        return huis + hsb;
    }
}
