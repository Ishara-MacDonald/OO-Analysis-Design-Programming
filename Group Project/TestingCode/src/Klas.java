import java.util.ArrayList;

public class Klas {
    private int klasNr;
    private ArrayList<Student> studenten = new ArrayList<>();

    public Klas(int klasNr){
        this.klasNr = klasNr;
    }

    public void voegStudentToe(Student student){
        studenten.add(student);
    }

    public String toString(){
//        if(studenten.isEmpty()){
//            return "Klas is leeg.";
//        }
//
//        String output = "";
//        for(Student student: studenten){
//            output += student.getNaam() + "\n";
//        }

        return Integer.toString(klasNr);
    }
}
