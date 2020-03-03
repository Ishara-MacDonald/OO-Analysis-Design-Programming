package Opdracht7;

public class Main {
    public static void main(String[] args) {
        StringProcessor processor = new StringProcessor();
        processor.voegProcesToe(new VervangProces("hij", "hij/zij"));
        processor.voegProcesToe(new HoofdletterProces());
        String inputString = "Een student loopt meestal in het derde jaar stage. Dan moet hij zelf een stageplek vinden.";
        String result = processor.verwerk(inputString);
        System.out.println(result);

        StringProcessor stuff = new StringProcessor();
        stuff.voegProcesToe(new SplitsZinProces(" "));
        String outputString = "Een student loopt.";
        String resultt = stuff.verwerk(outputString);
        System.out.println(resultt);

        StringProcessor stufff = new StringProcessor();
        stufff.voegProcesToe(new SplitsZinProces(";"));
        String outputStringg = "Een student loopt.";
        String resulttt = stufff.verwerk(outputStringg);
        System.out.println(resulttt);
    }
}