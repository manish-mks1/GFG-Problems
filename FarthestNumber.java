//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out = new PrintWriter(System.out);
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
        	int N = Integer.parseInt(br.readLine()); 
        	int[] Arr = new int[N];
        	String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
        	for(int i=0; i<N; i++)
        	{
        		Arr[i] = Integer.parseInt(strs[i]); 
        	}
        	

            Solution ob = new Solution();
			int[] ans = ob.farNumber(N,Arr);
  
            for(int i=0; i<ans.length; i++)
                out.print(ans[i] + " ");
            out.println();

            t--;
        }
        out.flush();
    } 
} 

// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int getfathest(int i,int val,int N,int minsuff[]){
        int ans=-1;
        int l=i+1,h=N-1;
	    while(l<=h){
	        int mid=l+(h-l)/2;
	        if(minsuff[mid]<val){
	            ans=mid;
	            l=mid+1;
	        }else
	        h=mid-1;
	    }
	    return ans;
    }
    static int[] farNumber(int N, int arr[])
	{   int[] minsuff=new int[N];
	    Arrays.fill(minsuff,-1);
        minsuff[N-1]=arr[N-1];
        for(int i=N-2;i>=0;i--){
            minsuff[i]=Math.min(minsuff[i+1],arr[i]);
        }
	    for(int i=0;i<arr.length;i++){
	        arr[i]=getfathest(i,arr[i],N,minsuff);
	    }
	    return arr;
        
	}
} 