
import java.util.*;

public class Problem_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number");
        int n = sc.nextInt();
        
        if (n > 0) {
            System.out.println("Postive Number");
        } else if (n < 0) {
            System.out.println("Negative Number");
        } else {
            System.out.println("Zero");
        }

        if (n % 2 == 0) {
            System.out.println("Even Number");
        }

        else {
            System.out.println("Odd Number");
        }

    }
}
