import java.util.*;

public class Problem_3 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First number");
        int n1 = sc.nextInt();
        System.out.println("Enter Secound Number");
        int n2 = sc.nextInt();

        System.out.println(add(n1, n2));
        System.out.println(isEven(n1 + n2));
        if(n1+n2>0){
            System.out.println(findFact(n1+n2));
        }
        

    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static boolean isEven(int n) {
        if (n % 2 == 0)
            return true;
        return false;
    }

    public static int findFact(int num) {
        if (num == 0 || num == 1)
            return 1;

        return num * findFact(num - 1);
    }

}
