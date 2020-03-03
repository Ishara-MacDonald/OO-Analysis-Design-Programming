package Opdracht8;

public class Computer implements Goed {
    private String type;
    private String macAdres;
    private double aanschafPrijs;
    private int productieJaar;

    public Computer(String type, String macAdres, double aanschafPrijs, int productieJaar){
        this.type = type;
        this.macAdres = macAdres;
        this.aanschafPrijs = aanschafPrijs;
        this.productieJaar = productieJaar;
    }

    public double huidigeWaarde() {
        return aanschafPrijs;
    }

    public boolean equals(Object obj){
        boolean gelijk = false;

        return gelijk;
    }

    public String toString(){
        return type;
    }
}
