package bit_manipulation;

public class SmallestXOR {
    public static void main(String[] args) {
        System.out.println(solve(11,1));
    }
    public static int solve(int A, int B) {
        int x = A;
        int numOfBits = countBits(x);
        if (numOfBits > B) {
            //remove extra bits
            int k = numOfBits - B;
            for (int i = 0; i < 32; i++) {
                if (((x >> i) & 1) == 1) {
                    x = x - (1 << i);
                    k--;
                }
                if (k == 0) return x;
            }
        } else if (numOfBits < B) {
            //add more bits
            int k = B - numOfBits;
            for (int i = 0; i < 32; i++) {
                if ((x & (1 << i)) == 0) {
                    x = x | (1 << i);
                    k--;
                }
                if (k == 0) return x;
            }
        }
        return x;
    }

    public static int countBits(int A) {
        int numOfBits = 0;
        while (A != 0) {
            A = A & (A - 1);
            numOfBits++;
        }
        return numOfBits;
    }
}
