import java.util.Calendar;
import java.util.Date;

public class TestKlas {

    public static void main(String[] args) {
        testZiekmelding();
    }

    private static void testZiekmelding(){
        Student st1 = new Student(1, "email", "123", "Harry");
        Student st2 = new Student(1, "email", "123", "Henk");

        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.YEAR, 2020);
        cal1.set(Calendar.MONTH, 1);
        cal1.set(Calendar.DAY_OF_MONTH, 2);
        Date date1 = cal1.getTime();

        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.YEAR, 2020);
        cal2.set(Calendar.MONTH, 1);
        cal2.set(Calendar.DAY_OF_MONTH, 2);
        Date date2 = cal2.getTime();

        st1.ziekMelden(date1);
        st1.getZiekMeldingen();

        st1.ziekMelden(date2);
        st1.getZiekMeldingen();

        st2.getZiekMeldingen();
    }

    private static void testFull(){
        Klas klas1 = new Klas(214);

        Student st1 = new Student(1, "email", "123", "Harry");
        Student st2 = new Student(2, "emai", "12", "Henk");
        Docent d1 = new Docent("Job");
        Lokaal l1 = new Lokaal(123);

        klas1.voegStudentToe(st1);
        klas1.voegStudentToe(st2);

        System.out.println(klas1);

        College college = new College(123, "OOAD" ,CollegeType.werkCollege, TijdBlok.ochtendBlok, l1);

        college.voegKlasToe(klas1);
        college.voegDocentToe(d1);

        System.out.println(college);
    }

    private static void testAnotherOne(){
        Klas klas1 = new Klas(214);

        Student st1 = new Student(1, "email", "123", "Harry");
        Student st2 = new Student(2, "emai", "12", "Henk");
        Docent d1 = new Docent("Job");
        Lokaal l1 = new Lokaal(123);

        System.out.println(klas1);

        College college = new College(123, "OOAD" ,CollegeType.werkCollege, TijdBlok.ochtendBlok, l1);
        college.voegDocentToe(d1);

        System.out.println(college);
    }

    private static void testAfmeldingen(){
        Student st1 = new Student(1, "email", "123", "Harry");
        Student st2 = new Student(1, "email", "123", "Henk");
        Student st3 = new Student(1, "email", "123", "Hikkie");
        Lokaal l1 = new Lokaal(123);
        Lokaal l2 = new Lokaal(13);
        College college1 = new College(123, "OOAD" ,CollegeType.werkCollege, TijdBlok.ochtendBlok, l1);
        College college2 = new College(1233, "OOP" ,CollegeType.hoorCollege, TijdBlok.middagBlok, l2);

        st1.voegAfmeldingToe(college1);
        st1.voegAfmeldingToe(college2);

        st1.getAfmeldingen();

        st2.voegAfmeldingToe(college1);

        st2.getAfmeldingen();

        st3.getAfmeldingen();

    }
}