//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class PaintersPartition
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution{
    static boolean check(int[] arr,int n,int k,long mid){
        int count=1;
        long total=0;
        for(int i=0;i<arr.length;i++){
            total+=arr[i];
            if(total>mid){
                total=arr[i];
                count++;
            }
            
        }
        if(count<=k)
        return true;
        else 
        return false;
    }
    static long minTime(int[] arr,int n,int k){
        //code here
        long l=0;
        long h=0;
        long ans=0;
        for(int i=0;i<arr.length;i++){
            l=Math.max(l,arr[i]);
            h+=arr[i];
        }
        int count=1;
        while(l<=h){
            long mid=l+(h-l)/2;
            if(check(arr,n,k,mid)==true){
                ans=mid;
                h=mid-1;
            }else{
                count++;
                l=mid+1;
            }
        }
        return ans;
    }
}


