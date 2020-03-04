package Opdracht8;

public class Main {
    public static void main(String[] args) {
        BedrijfsInventaris nieuwBedrijf = new BedrijfsInventaris("Wink", 400.00);

        Computer pc1 = new Computer("hp", "01", 30.00, 2017);
        Computer pc2 = new Computer("hp", "01", 30.00, 2017);

        Auto auto1 = new Auto("Mercedes", 100.00, 2019, "3-dvt-19");
        Auto auto2 = new Auto("Mercedes", 100.00, 2019, "3-dvt-19");

        Fiets fiets1 = new Fiets("gall", 50.00, 2019, 1233);
        Fiets fiets2 = new Fiets("gall", 50.00, 2019, 1233);

        Computer pcAnders = new Computer("dell", "71", 50.00, 2019);
        Auto autoAnders = new Auto("Volvo", 200, 2018, "9-wew-12");
        Fiets fietsAnders = new Fiets("lagg", 20, 2016, 2004);

        nieuwBedrijf.schafAan(pc1);
        nieuwBedrijf.schafAan(pc2);
        nieuwBedrijf.schafAan(auto1);
        nieuwBedrijf.schafAan(auto2);
        nieuwBedrijf.schafAan(fiets1);
        nieuwBedrijf.schafAan(fiets2);
        nieuwBedrijf.schafAan(pcAnders);
        nieuwBedrijf.schafAan(autoAnders);
        nieuwBedrijf.schafAan(fietsAnders);
        System.out.println(nieuwBedrijf.toString());
    }

}
