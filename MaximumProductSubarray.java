import java.io.*;
// import java.util.*;
public class MaximumProductSubarray {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
            System.out.println("Enter the no.elements in the array:");
            int n = Integer.parseInt(br.readLine());
    
            System.out.println("Enter the Elements:");
    
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");// this statement converts the a stream of tokens into seperate
                                                          // valuses stored as arrays of string
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);// conversion from string to integer array
            }
            System.out.println("The product is:");
            System.out.println(new Solution().maxProduct(arr, n));
        }
    }


    
    // } Driver Code Ends
    
    class Solution {
        // Function to find maximum product subarray
        public static long subMaxProduct(int[] arr, int st, int end) {
            if (st > end)
                return 0;
            if (st == end)
                return arr[st];
    
            int count = 0;
            long result = 1;
            int prefix = -1;
            int sufix = -1;
            for (int i = st; i <= end; i++) {
                if (arr[i] < 0) {
                    count++;
                    if (prefix == -1)
                        prefix = i;
                    sufix = i;
                }
            }
    
            if (count % 2 == 0) {
                for (int i = st; i <= end; i++)
                    result *= arr[i];
            } else {
    
                long result1 = Math.max(subMaxProduct(arr, st, sufix - 1), subMaxProduct(arr, sufix + 1, end));
                long result2 = Math.max(subMaxProduct(arr, st, prefix - 1), subMaxProduct(arr, prefix + 1, end));
                result = Math.max(result1, result2);
    
            }
            return result;
        }
    
        long maxProduct(int[] arr, int n) {
            long result = arr[0];
            int tempi = 0;
            for (int i = 0; i <= n; i++) {
                if (i == n || arr[i] == 0) {
                    long tempResult = subMaxProduct(arr, tempi, i - 1);
                    if (tempResult > result)
                        result = tempResult;
                    tempi = i + 1;
                }
            }
            return result;
        }
    } 

