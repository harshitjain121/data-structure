package dp;

import java.util.Arrays;

public class DistinctSubSequenceDP {

    public static void main(String[] args) {
        String A = "rabbbit";
        String B = "rabbit";
        int[] dp = new int[B.length()+1];
        count(A,B,dp);
    }

    static int count(String A,String B,int dp[]){
        dp[0] = 1;

        for(int i=0; i<A.length(); i++){
//            for(int j=1; j<=B.length(); j++){
            for(int j=B.length(); j>0; j--){

                if(A.charAt(i) == B.charAt(j-1)){
                    dp[j] = dp[j-1] + dp[j];
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[B.length()];
    }
}
