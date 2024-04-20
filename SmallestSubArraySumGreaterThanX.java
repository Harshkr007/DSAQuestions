import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestSubArraySumGreaterThanX {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n;
        int[] arr ;
        int X;

        System.out.println("Enter the no. of elements:");
        n = Integer.parseInt(br.readLine());

        System.err.println("Enter the elements:");
        arr = new int[n];
        String[] inputLine = br.readLine().split(" ");// this statement converts the a stream of tokens into seperate
                                                          // valuses stored as arrays of string
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputLine[i]);// conversion from string to integer array
        }

        System.out.println("Enter the element to get sum greaterThan:");
        X = Integer.parseInt(br.readLine());

        System.out.println(" "+smallestSubWithSum(arr, n, X));
    }
    public static int smallestSubWithSum(int a[], int n, int x) {
        if(x == 0)return 0;
        
       int left,right,count,sum;
       left = 0;
       right = 0;
       count = 0;
       sum = 0;
       
       while(right < n && sum <= x){ 
           sum += a[right];
           right++;
           count++;
       }
       
       while((sum - a[left]) > x || right < n){
           
           while((sum - a[left]) > x){
               sum -= a[left++];
               if((right - left ) < count) count = right - left ;
           }
           if(right < n){
            sum += a[right];
             right++; 
           }
       } 
       return sum < x ? 0 : count;
    }
}
