package hashing;

public class ReplicatingSubstring {
    public static void main(String[] args) {
        int A = 2;
        String B = "bbaabb";

        System.out.println(isPossibleToReplicateStringBy_A_Times(A, B));
    }

    // hashmap technique
    private static int isPossibleToReplicateStringBy_A_Times(int A, String B) {
        // hash array to keep a track of frequency of each character
        int[] hash = new int[26];
        for (int i = 0; i < B.length(); i++) {
            hash[B.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            // if the frequency of a character present in the string isn't divisible by A,
            // indicates that it will never be possible to represent B as concatenation of A strings

            if (hash[i] % A != 0)
                return -1;
        }
        return 1;
    }
}
