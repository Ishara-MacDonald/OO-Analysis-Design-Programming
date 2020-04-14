package Opdracht11;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static String name;
    static String destination;
    static double value;

    static boolean destinationSet = false;
    static File file = new File("");

    public static void main(String[] args) throws IOException {
        setName();
        processOldFile();
        System.out.println("File succesfully added!");
    }

    private static void setName() throws IOException {
        name = getInput("Enter the file's name.");
        setDestination();
    }

    private static void setDestination() throws IOException{
        destination = getInput("Enter the path of the destination folder.");
        setValues();
    }

    private static void setValues() throws IOException {
        file = new File(destination);

        if(file.exists()){
            file = new File(destination + "\\" + name + ".txt");
            if(file.createNewFile()){
                System.out.println("File " + name + " is created in " + destination + "!");
                destinationSet = true;
            }else{
                System.out.println("File " + name + " already exists in " + destination + "!");
                fileExists();
            }
        }else{
            System.out.println("Folder doesn't exist. Please enter a valid path!");
            setDestination();
        }
        setValueDollar();
    }

    private static void setValueDollar(){
        String input = getInput("Enter the value of 1 dollar in euros.");
        double inputInt = 0;
        try{inputInt = Double.parseDouble(input);}
        catch(Exception e){
            System.out.println("Please enter a valid number!");
            setValueDollar();
            inputInt = 1;
        }
        value = inputInt;
    }

    private static String getInput(String request){
        Scanner input = new Scanner(System.in);
        System.out.println(request);
        return input.nextLine();
    }

    private static void fileExists() throws IOException{
        String inputUser = getInput("Do you want to change [0] file name, [1] destination folder or [2] cancel?");
        int inputInt;
        try{
            Integer.parseInt(inputUser);
            inputInt = Integer.parseInt(inputUser);
        }
        catch(Exception e){
            inputInt = -1;
        }
        switch(inputInt){
            case 0:
                setName();
                break;
            case 1:
                setDestination();
                break;
            case 2:
                System.out.println("Cancelled creating file.");
                System.exit(0);
                break;
        }
    }

    private static void processOldFile() throws IOException{
        FileReader reader = new FileReader("src/Opdracht11/mainText.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        ArrayList<String> nieuweRegels = new ArrayList<>();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] arrOfStr = line.split(":", 2);
            String descriptionStr = arrOfStr[0];
            String priceStr = arrOfStr[1];
            String nieuweRegel;
            double price;
            if(tryParseDouble(priceStr)){
                price = Double.parseDouble(priceStr);
                price = price * value;
                nieuweRegel = descriptionStr + ": " + price;
            }else{continue;}
            nieuweRegels.add(nieuweRegel);
        }
        reader.close();
        editNewFile(nieuweRegels);
    }

    private static void editNewFile(ArrayList<String> regels) throws IOException {
        FileWriter fw = new FileWriter(file);

        for(String regel: regels){fw.write(regel + "\r\n");}
        fw.close();
    }

    private static boolean tryParseDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {return false;}
    }
}