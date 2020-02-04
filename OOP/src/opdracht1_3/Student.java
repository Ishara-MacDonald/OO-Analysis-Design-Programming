package opdracht1_3;

public class Student {
    private String name;
    private long studentNr;

    public Student(String name, long studentNr) {
        this.name = name;
        this.studentNr = studentNr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentNr(long studentNr) {
        this.studentNr = studentNr;
    }

    public String getNaam() {
        return name;
    }

    public long getNr() {
        return studentNr;
    }

    public String toString() {
        String studentNumber = Long.toString(studentNr);
        String s = name + " heeft studentNr " + studentNumber;
        return s;
    }

}