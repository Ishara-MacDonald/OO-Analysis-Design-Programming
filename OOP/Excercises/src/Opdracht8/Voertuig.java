package Opdracht8;

public abstract class Voertuig implements Goed{
    private String type;

    protected double nieuwprijs;
    protected int bouwjaar;

    public Voertuig(String type, double nieuwprijs, int bouwjaar){
        this.type = type;
        this.nieuwprijs = nieuwprijs;
        this.bouwjaar = bouwjaar;
    }

    protected String getType(){
        return type;
    }

    public boolean equal(Object obj){
        return false;
    }

    public String toString(){
        return type;
    }

}
