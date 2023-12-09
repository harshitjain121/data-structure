package others;

public class StringToBinary {
    public static void main(String[] args) {
        System.out.println(convertStringBinaryToInt("101"));

    }

    public static int convertStringBinaryToInt(String s){
        // 101
        int k = 0;
        int ans = 0;
        int n = s.length();
        for(int i= n-1; i>=0; i--){
            int p = findPower(2, n-1-i); // power => 0,1,2
            int bit = s.charAt(i)-48;
            ans += bit * p;
        }
        return ans;
    }

    public static int findPower(int n, int i){
        //n^i
        //base case
        if(i == 0) return 1;
        if(n == 0) return 0; // 1

        int halfPower = findPower(n, i/2);

        if(i%2 == 0){
            return halfPower * halfPower;
        }
        else{
            return halfPower * halfPower * n;
        }
    }
}
