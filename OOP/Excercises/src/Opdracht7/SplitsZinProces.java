package Opdracht7;

public class SplitsZinProces implements OpmaakProces {
    private String splitsing;

    public SplitsZinProces(String splitsing){
        this.splitsing = splitsing;
    }

    public String maakOp(String input) {
        if(!input.contains(splitsing)){
            return splitsing + " komt niet voor.";
        }

        String output = "";
        String[] splitWords = input.split(splitsing, 0);
        for(String word: splitWords){
            output += word + "\n";
        }
        return output;
    }
}
