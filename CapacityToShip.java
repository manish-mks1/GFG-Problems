//{ Driver Code Starts

    // Capacity To Ship Packages Within D Days

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static boolean checkCapacity(int[] arr,int N,int D,int mid){
        int day=1,cap=0;;
        for(int i=0;i<N;i++){
            cap+=arr[i];
            if(cap>mid){
                day++;
                cap=arr[i];
            }
        }
        return day<=D;
    }
    static int leastWeightCapacity(int[] arr, int N, int D) {
        // code here
        int l=0,h=0,ans=0;
        for(int i=0;i<N;i++){
            l=Math.max(l,arr[i]);
            h+=arr[i];
        }
        while(l<=h){
            int mid=l+(h-l)/2;
            if(checkCapacity(arr,N,D,mid)){
                ans=mid;
                h=mid-1;
            }else
            l=mid+1;
        }
        return ans;
    }
};