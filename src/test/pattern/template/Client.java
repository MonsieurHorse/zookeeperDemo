package pattern.template;

/**
 * Created by junbaoma on 2018/2/8.
 */
public class Client {
    public static void main(String[] args) {
        Student student = new Student();
        student.prepareGotoSchool();

        System.out.println();
        Teacher teacher = new Teacher();
        teacher.prepareGotoSchool();
        System.out.println();
        AbstractPerson abstractPerson = new Teacher();
        abstractPerson.prepareGotoSchool();
    }
}
