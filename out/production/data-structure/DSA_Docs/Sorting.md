DSA : `SORTING` implementation

1. Sorting 2 : Inversion count in an array
2. Sorting 2 : Largest Number
3. Sorting 2 : Unique Elements
4. Sorting 2 : Reverse Pairs
5. Sorting 2 : B Closest Points to Origin
6. Sorting 3 : Sum The Difference
7. Sorting 3 : QuickSort
8. Sorting 3 : Maximum Unsorted Subarray
9. Sorting 3 : Maximum Minimum Magic

---

## 1. Sorting 2 : Inversion count in an array

**InversionCountInAnArray.java**:
```java
public class InversionCountInAnArray {
    private static final int MOD = 1000000000 + 7;

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(
                3, 4, 1, 2
        ));
        // REFER MERGE SORT CODE ***********************
        System.out.println(countInvertedPairs(list, 0, list.size()-1));
    }

    private static int countInvertedPairs(ArrayList<Integer> list, int l, int r) {
        // base case
        if(r == l)  return 0;
        int mid = l + (r-l)/2;

        int a = countInvertedPairs(list, l, mid) % MOD;
        int b = countInvertedPairs(list, mid+1, r) % MOD;
        int a_with_b = merge(list, l, mid, r) % MOD;

        return (a + b + a_with_b) % MOD;
    }

    private static int merge(ArrayList<Integer> list, int l, int mid, int r) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int count = 0;
        int i = l;
        int j = mid+1;

        while(i <= mid && j<= r){
            if(list.get(i) <= list.get(j)){
                result.add(list.get(i));
                i++;
            }
            else{
                //inverted pair exists ----------------
//              (----i--------mid) (-----j---------)
                count = (count + mid - i +1) % MOD;
                result.add(list.get(i));
                j++;
            }
        }

        while(i <= mid){
            result.add(list.get(i));
            i++;
        }
        while(j <= r){
            result.add(list.get(j));
            j++;
        }

        //copy the sorted array back the original arraylist
        for(int k=l; k<=r; k++){
            list.set(k, result.get(k-l));
        }

        return count % MOD;
    }
}
```

## 2. Sorting 2 : Largest Number in an array
Given an array A of non-negative integers, arrange them such that they form the largest number

**LargestNumber.java**:
```java
public class LargestNumber {

    public static void main(String[] args) {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                3, 30, 34, 5, 9
        ));

        // approach 1 - merge sort with - custom merge logic - this will be a lengthy code
        // approach 2 - use custom logic to compare and try Comparators
        System.out.println(largestNumber(A));
    }

    private static String largestNumber(ArrayList<Integer> A) {
        StringBuilder sb = new StringBuilder();
        ComparatorUtils.Sort_InReverse_ByAdding_2_digitAsString(A); //custom method

        for (int i : A){
            if(i == 0 && sb.length() == 0)  continue;
            sb.append(i);
        }
        return sb.toString();
    }
}
```

## 3. Sorting 2 : Unique Elements
You are given an array A of N elements. You have to make all elements unique. To do so, in one step you can increase any number by one.

Find the minimum number of steps.

**UniqueElements.java**:
```java
public class UniqueElements {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 1, 3, 1, 2, 3
        ));

        System.out.println(uniqueElements(A));
    }

    private static int uniqueElements(ArrayList<Integer> A) {
        Collections.sort(A);
        int count = 0;
        for(int i=1; i<A.size(); i++){
            if(A.get(i-1) >= A.get(i)){
                int temp = A.get(i);
                A.set(i, A.get(i-1) + 1);
                count += A.get(i) - temp;
            }
        }
        return count;
    }
}
```

## 4. Sorting 2 : Reverse Pairs 
:fire: :fire: :fire: Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
Return the number of important reverse pairs in the given array A.


**ReversePairs.java**:
```java
public class ReversePairs {
    public static void main(String[] args) {
        ArrayList<Integer>  A = new ArrayList<>(Arrays.asList(
                1, 3, 2, 3, 1
        ));
        //Output - 2
        // REFER MERGE SORT CODE ***********************
        System.out.println(countInvertedPairs( A, 0, A.size()-1));
    }

    private static int countInvertedPairs(ArrayList<Integer>  A, int l, int r) {
        // base case
        if(r == l)  return 0;
        int mid = l + (r-l)/2;

        int a = countInvertedPairs( A, l, mid) ;
        int b = countInvertedPairs( A, mid+1, r) ;
        int a_with_b = merge( A, l, mid, r) ;

        return (a + b + a_with_b) ;
    }

    private static int merge(ArrayList<Integer>  A, int l, int mid, int r) {
        ArrayList<Integer> result = new ArrayList<>();
        int count = 0;
        int i = l;
        int j = mid+1;

        while(i <= mid && j<= r){
            if( A.get(i) <=  A.get(j)){
                result.add( A.get(i));
                i++;
            }
            else{
                // invert pair exists ~~~~~~~~~~~~~~~~~~~~~ TODO
                if( A.get(i) > 2*  A.get(j)){
                    count += mid-i+1;
                }
                result.add( A.get(j));
                j++;
            }
        }

        while(i <= mid){
            result.add( A.get(i));
            i++;
        }
        while(j <= r){
            result.add( A.get(j));
            j++;
        }

        //copy the sorted array back the original arraylist
        for(int k=l; k<=r; k++){
            A.set(k, result.get(k-l));
        }

        return count ;
    }
}
```

## 5. Sorting 2 : B Closest Points to Origin
We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).
Here, the distance between two points on a plane is the Euclidean distance.
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).


**BClosestPointsToOrigin.java**:
```java
public class BClosestPointsToOrigin {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,3)));
        A.add(new ArrayList<>(Arrays.asList(-2,2)));

        int B = 1;
        // output - [[-2, 2]]
        System.out.println(findBClosestPointsFromOrigin(A, B));
    }

    private static ArrayList<ArrayList<Integer>> findBClosestPointsFromOrigin(ArrayList<ArrayList<Integer>> A, int B) {
//        sorting the points based on the distance
        ComparatorUtils.sortListOf_2_Points_List(A);

        ArrayList<ArrayList<Integer>> res = new  ArrayList<>();
        for(int i=0;i<B;i++){
            res.add(A.get(i));
        }
        return res;
    }
}
```

## 6. :fire: Sorting 3 : Sum The Difference
:fire:

**SumTheDifference.java**:
```java
public class SumTheDifference {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                5, 3, 10
        ));
        // output - 21
        System.out.println(findTheDiffBtwMIN_MAXOfEverySubsequence(A));
    }

    private static int findTheDiffBtwMIN_MAXOfEverySubsequence(ArrayList<Integer> A) {
        long MOD = 1000000007;
        long minVal = 0L;
        long maxVal = 0L;
        int N = A.size();
        long minPower = 1L; // 2^0
        long maxPower = (long) Math.pow(2,N-1); // 2^(n-1)

        Collections.sort(A);

        // USING THE CONTRIBUTION TECHNIQUE ------------------
        for(int i=0; i<N; i++){
            maxVal = (maxVal + A.get(i) * (minPower<<i) ) % MOD; // 2^0 -> 2^1 -> 2^2
            minVal = (minVal + A.get(i) * (maxPower>>i) ) % MOD; // 2^n-1 -> 2^n-2 -> 2^n-3
//            System.out.println("minVal : " + minVal + " , minPow : " + (maxPower>>i) + " || maxVal : " + maxVal + " , maxPow : " + (minPower<<i));
        }

        return (int)((maxVal - minVal + MOD) % MOD);
    }

//    minVal : 12 , minPow : 4 || maxVal : 3 , maxPow : 1
//    minVal : 22 , minPow : 2 || maxVal : 13 , maxPow : 2
//    minVal : 32 , minPow : 1 || maxVal : 53 , maxPow : 4
//            21
}
```

## 7. Sorting 3 : QuickSort

**QuickSort.java**:
```java
public class QuickSort {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 4, 10, 2, 1, 5
        ));
        quickSort(A, 0, A.size()-1);
        System.out.println(A);
    }

    private static void quickSort(ArrayList<Integer> A, int s, int e) {
        if(s >= e)  return;
        int idx = rearrange(A, s, e);

        quickSort(A, s, idx-1);
        quickSort(A, idx+1, e);
    }

    private static int rearrange(ArrayList<Integer> A, int s, int e) {
        //selecting the random index from the array
        int randomPivot = (int)(Math.random()*(e-s+1)+s);

        //swap the starting element and the randomPivot element
        swap(A, s, randomPivot);

        int i = s+1;
        int j = e;

        // sending A[s] to its right position
        while(i <= j){
            if(A.get(i) <= A.get(s)) // i -> is happy
                i++;
            else if(A.get(j) > A.get(s)) // j -> is happy
                j--;
            else{
                // both are unhappy
                swap(A, i, j);
                i++;
                j--;
            }
        }
        // swap A[s] and A[i--]
        swap(A, s, --i);
        return i;
    }

    private static void swap(ArrayList<Integer> A, int a, int b) {
        int temp = A.get(a);
        A.set(a, A.get(b));
        A.set(b, temp);
    }

}
```

## 8. Sorting 3 : Maximum Unsorted Subarray
find the maximum length UnSorted subarray in a sorted array, when subarray is sorted than whole array become sorted. Output the indices [s,e]
:star: focus on the EDGE CASE ... :star:

**MaximumUnsortedSubarray.java**:
```java
public class MaximumUnsortedSubarray {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 4, 10, 2, 1, 5
        ));

        System.out.println(subArrayUnsorted(A));
    }

    private static ArrayList<Integer> subArrayUnsorted(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = A.size();
        int i = 0;
        int j = n-1;

        while (i < n - 1 && A.get(i) <= A.get(i+1)) {
            i++;
        }

        while(j>0 && A.get(j-1) <= A.get(j)){
            j--;
        }
        // :star: EDGE CASE | if the array is already sorted, output is -1
        if(i == n-1){
            ans.add(-1);
            return ans;
        }

        // :star: find the maximum and minimum element of the subarray -> A.get(i) ... A.get(j)
        int mn = A.get(i);
        int mx = A.get(i);

        for (int k = i; k <= j ; k++) {
            mx = Math.max(mx, A.get(k));
            mn = Math.min(mn, A.get(k));
        }

        int l = 0, r = n-1;

        while(A.get(l) <= mn && l <= i)
            l++;

        while(A.get(r) >= mx && r >= j)
            r--;

        ans.add(l);
        ans.add(r);

        return ans;
    }
}
```

## 9. Sorting 3 : Maximum Minimum Magic
Given an array of integers A of size N where N is even. Divide the array into two subsets such that
`Magic Number` = sum of absolute difference of corresponding elements of subset.

**MaximumMinimumMagic.java**:
```java
public class MaximumMinimumMagic {
    private static final int MOD = 1000000007;
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                3, 11, -1, 5
        ));

        System.out.println(minAndMaxMagicCombination(A));
    }

    private static ArrayList<Integer> minAndMaxMagicCombination(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();

        Collections.sort(A);

        // MINIMUM value
        int min = 0;
        int max = 0;
        int N = A.size();

        for (int i = 0; i < N; i+=2) {
            min = (min + Math.abs(A.get(i) - A.get(i+1))) % MOD;
        }

        // MAXIMUM value
        for (int i = 0; i < N/2; i++) {
            max = (max + Math.abs(A.get(i) - A.get(N-i-1))) % MOD;
        }

        result.add(max);
        result.add(min);

        return result;
    }
}
```