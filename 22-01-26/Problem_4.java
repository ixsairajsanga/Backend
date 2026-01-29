
import java.util.*;

public class Problem_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student Id");
        int id = sc.nextInt();
        System.out.println("Enter student Name");
        String name = sc.next();
        System.out.println("Enter Student marks");
        int marks = sc.nextInt();

        Student s1 = new Student(id, name, marks);

        System.out.println(s1.getId());
        System.out.println(s1.getname());
        System.out.println(s1.getMarks());
        System.out.println(s1.isPassed(s1.getMarks()));
        

    }
}

class Student {
    private int id;
    private String name;
    private int marks;

    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public String getname() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public void setid(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public boolean isPassed(int marks) {
        if (marks < 40)
            return false;
        return true;
    }

}
