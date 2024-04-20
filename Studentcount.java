// import java.util.*;
import java.io.*;

public class Studentcount {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 0;

        System.out.println("Enter the no. of students:");
        num = Integer.parseInt(br.readLine());

        int[] student = new int[num];
        int[] bread = new int[num];

        System.out.println("Enter the Student Preference:");
        System.out.println("NOTE: Enter \' 0 \' for circular bread and \' 1 \' for square bread");
        String[] stpre = br.readLine().split(" ");

        System.out.println("Enter the breads available:");
        System.out.println("NOTE: Enter he breads as \'0 \' for circular and \' 1 \' for square");
        String[] brAvail = br.readLine().split(" ");

        for (int i = 0; i < num; i++) {
            student[i] = Integer.parseInt(stpre[i]);
            bread[i] = Integer.parseInt(brAvail[i]);
        }

        int count = new Solution().countStudents(student, bread);
        System.out.println("So,The Number of students without bread : " + count);

    }
}

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int count = students.length;
        int tempCount = students.length;
        int pointST = 0;
        int pointSW = 0;
        while (pointSW != sandwiches.length) {
            if (students[pointST] == sandwiches[pointSW]) {
                students[pointST] = -1;
                sandwiches[pointSW] = -1;
                pointSW++;
                tempCount--;
            }
            if (pointST == students.length - 1) {
                if (tempCount == count)
                    break;
                count = tempCount;
                pointST = 0;
            } else {
                pointST++;
            }

        }

        int result = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != -1)
                result++;
        }
        return result;
    }
}