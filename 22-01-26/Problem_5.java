
import java.util.*;

public class Problem_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Id");
        int id = sc.nextInt();
        System.out.println("Enter Employee Name");
        String name = sc.next();
        System.out.println("Enter Employee salary");
        int salary = sc.nextInt();

        Employee e1 = new Employee(id, name, salary);
        System.out.println(e1.calculateAnnualSalary());
        e1.display();
        
    }
}

class Employee {
    public int id;
    public String name;
    public int monthlySalary;
    private String CompanyName = "Innovatech";

    public Employee(int id, String name, int monthlySalary) {
        this.id = id;
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public Employee() {

    }

    public int calculateAnnualSalary() {
        return 12 * monthlySalary;
    }

    public void display() {

        System.out.println(this.id);
        System.out.println(this.name);
        System.out.println(this.monthlySalary);

    }

}