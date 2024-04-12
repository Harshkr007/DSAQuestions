import java.util.Scanner;

public class divisible {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number dividible with:");
        int a = sc.nextInt();
        System.out.println("and");
        int b = sc.nextInt();
        System.out.println("Not divisible by: ");
        int c = sc.nextInt();
        System.out.println("Enter the limit(in Integers):");
        int limit = sc.nextInt();
        System.out.println("The  total no. is " + (divide(a, b, c, limit)));
    }

    public static int divide(int a, int b, int c, int limit) {
        int count = 0;
        for (int i = 1; i <= limit; i++) {
            if ((i % a == 0 && i % b == 0) && i % c != 0) {
                count++;
            }
        }
        return count;
    }
}