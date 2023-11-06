package binarySearch;

import utils.GcdUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class AthMagicalNumber {
    private static final int MOD = 1000000007;
    public static void main(String[] args) {
        int A = 4;
        int B = 2;
        int C = 3;

        System.out.println(findMagicalNumber(A, B, C));

    }

    private static int findMagicalNumber(int A, int B, int C) {
        long start = Math.min(B, C);
        long end = (long)A * start; // A* min(B,C)
        long mid = start + (end - start)/2;

        if(A == 1)  return (int)start;

        long ans = start;
        long lcm = (((long) B)*C)/ GcdUtils.gcd(B,C);

        while(start <= end){
            long count_of_B = mid/B;
            long count_of_C = mid/C;
            long count_of_BandC = mid/lcm;
            long magicalNum_mid = (count_of_B + count_of_C - count_of_BandC);

            if(magicalNum_mid >= A){
                //move to left - for more precision
                ans = mid;
                end = mid - 1;
            }
            else{
                //move to right
                start = mid + 1;
            }
            mid = start + (end - start)/2;
        }
        // ans -> it can never be negative
        // if(ans < 0 ){
        //     ans += MOD;
        // }
        return (int)(ans % MOD);
    }
}
