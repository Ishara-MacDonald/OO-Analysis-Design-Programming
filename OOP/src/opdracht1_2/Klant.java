package opdracht1_2;

public class Klant {
    private String name;
    private String adress;
    private String city;

    public Klant(String name, String adress, String city) {

        this.name = name;
        this.adress = adress;
        this.city = city;
    }

    public String getNaam() {
        return name;
    }

    public String getAdres() {
        return adress;
    }

    public String getPlaats() {
        return city;
    }

    public String toString() {
        String s = name + " woont op " + adress + " in " + city;
        return s;
    }

}