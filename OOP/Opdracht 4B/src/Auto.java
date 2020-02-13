public class Auto {
    private String type;
    private double prijsPerDag;

    public Auto(String type, double prijsPerDag){
        this.type = type;
        this.prijsPerDag = prijsPerDag;
    }

    public void setPrijsPerDag(double prijsPerDag) {this.prijsPerDag = prijsPerDag;}
    public double getPrijsPerDag() {return prijsPerDag;}

    public String toString() {
        return String.format("%s met prijs per dag: %.2f", type, prijsPerDag);
    }
}