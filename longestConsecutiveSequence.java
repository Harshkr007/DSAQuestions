import java.io.*;
import java.util.*;

public class longestConsecutiveSequence {
    public static void main(String[] args) throws IOException {
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
        System.out.println("Longest SubSequence:");
        System.out.println( new Solution1().findLongestConseqSubseq(arr,n));
    }
}
class Solution1
{   
    
	public int findLongestConseqSubseq(int arr[], int N)
	{
	   
	   int count = 1; 
	   int countTemp = 1;
	   HashSet<String> set = new HashSet<>();
	   
	   for(int i = 0; i < N; i++){
	       set.add(""+ arr[i]);
	   }
	   
	   Iterator<String> itr = set.iterator();
	   
	   while( itr.hasNext() ){
	       String number = itr.next();
	       int num = Integer.parseInt(number);
	       
	       if(set.contains(""+(num+1))){
	           countTemp += 1;
	       }else countTemp = 1;
	       
	       if (count < countTemp)count = countTemp;
	   }
	   
	   return count;
	}
}
