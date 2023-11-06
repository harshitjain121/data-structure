DSA : `Binary Seach` implementation

1. BS 1 : Sorted Insert Position
2. BS 1 : Find a Peak Element
3. BS 1 : Rotated Sorted Array Search
4. BS 1 : Matrix Search
5. BS 1 : :fire: :fire: Median Of Two Sorted Array
6. BS 1 : :star: Matrix Median
7. BS 2 : Square Root of Integer
8. BS 2 : Special Integer
9. BS 2 : Ath Magical Number
10. BS 2 : KthPrice (B.S in unsorted array)


---

## 1. BS 1 : Sorted Insert Position
You are given a sorted array A of size N and a target value B. find index.

**SortedInsertPosition.java**:
```java
public class SortedInsertPosition {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 3, 5, 6
        ));
        int B = 5;

        System.out.println(findTargetIndex_BinarySearch(A, B));
    }

    private static int findTargetIndex_BinarySearch(ArrayList<Integer> A, int B) {
        int s = 0;
        int e = A.size()-1;
        int mid = s + (e-s)/2;

        while(s<=e){
            // target is found
            if(A.get(mid) == B) return mid;

            else if(A.get(mid) < B){
                // move to right
                s = mid+1;
            }
            else{
                // move to left
                e = mid -1;
            }
            mid = s + (e-s)/2;
        }
        return mid;
    }
}
```

## 2. :fire: BS 1 : Find a Peak Element

**PeakElement.java**:
```java
public class PeakElement {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 3, 5, 6
        ));

        System.out.println(findThePeakElement(A));
    }

    private static int findThePeakElement(ArrayList<Integer> A) {
        int s = 0;
        int e = A.size()-1;

        // NOTE: s<= e  --> we'll get ArrayOutOfBound
        while(s<e){
            int mid = s + (e-s)/2;

            //target is in the decreasing path
            if(A.get(mid) > A.get(mid+1)){
                e = mid;
            }
            else{
                s = mid+1;
            }
        }
        // we have answer at e
        return A.get(e);
    }
}
```

## 3. :fire: BS 1 : Rotated Sorted Array Search

**RotatedSortedArraySearch.java**:
```java
public class RotatedSortedArraySearch {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                4,5,6,7,0,1,2,3
        ));
        int B = 6;
        System.out.println(rotatedSortedArray(A, B));
    }

    //without finding the pivot element
    private static int rotatedSortedArray(ArrayList<Integer> A, int B) {
        int s = 0;
        int e = A.size()-1;
        int mid = s + (e-s)/2;

        while(s<e){
            if(A.get(mid) == B) return mid;

            // upper line
            if(A.get(mid) >= A.get(0)){
                if(A.get(mid) > B && B >= A.get(s)) e = mid;
                else s = mid +1;
            }
            else{
                if(A.get(mid) < B && B <= A.get(e)) s = mid+1;
                else e = mid;
            }
            mid = s + (e-s)/2;
        }
        return -1;
    }
}
```

## 4. BS 1 : Matrix Search

**MatrixSearch.java**:
```java
public class MatrixSearch {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,   3,  5,  7)));
        A.add(new ArrayList<>(Arrays.asList(10, 11, 16, 20)));
        A.add(new ArrayList<>(Arrays.asList(23, 30, 34, 50)));
        int B = 3;

        System.out.println(sortedMatrixSearch(A, B));
    }

    private static int sortedMatrixSearch(ArrayList<ArrayList<Integer>> A, int B) {
//        matrix - n X m
        int n = A.size();
        int m = A.get(0).size();
        int s = 0;
        int e = n*m -1;
        int mid = s + (e-s)/2;

        while(s<=e){
            int i = mid/m;  //divide by column
            int j = mid%m;  //mod by column
            int midElement = A.get(i).get(j);

            if(midElement == B)    return 1;
            if(midElement > B)
                e = mid-1;
            else
                s = mid+1;
            mid = s + (e-s)/2;
        }
        return 0;
    }
}
```

## 5. :fire: :fire: :fire: BS 1 : Median Of Two Sorted Array

**MedianOf2SortedArray.java**:
```java
public class MedianOf2SortedArray {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 4, 5
        ));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(
                2,3
        ));
//      output - 3.0
        System.out.println(medianOfTwoSortedArray(A, B));
    }

    private static double medianOfTwoSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        int m = B.size();
        int total = n+m;

        //first array size should be small - as calculating the CUTS on smaller array
        if(n>m)
            return medianOfTwoSortedArray(B,A);

        int s = 0;
        int e = n;
//        L1 <= R2 && L2 <= R1
//                        cut1
//        arr1 ->  .....L1 | R1 .......
//                        cut2
//        arr2 ->  .....L2 | R2 .......
//        [.....L1  |  R2 .....]
//        [.....L2  |  R1 .....]

        while(s <= e){
            int cut1 = (s+e)/2;     // mid
            int cut2 = (total +1)/2 - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : A.get(cut1 -1);
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : B.get(cut2 -1);
            int r1 = (cut1 == n) ? Integer.MAX_VALUE : A.get(cut1);
            int r2 = (cut2 == m) ? Integer.MAX_VALUE : B.get(cut2);

            if(l1 <= r2 && l2 <= r1) {
                // median logic
                if((total % 2) == 0)
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                else
                    return Math.max(l1,l2);
            }
            else if (l1 > r2)
                e = cut1-1;
            else
                s = cut1+1;
        }
        return 0.0;
    }
}
```

## 6. :star: BS 1 : Matrix Median
`MEDIAN >= (N*M)/2 + 1  elements in a matrix`  

**MatrixMedian.java**:
```java
public class MatrixMedian {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1, 3, 5)));
        A.add(new ArrayList<>(Arrays.asList(2, 6, 9)));
        A.add(new ArrayList<>(Arrays.asList(3, 6, 9)));

        System.out.println(findMatrixMedian(A));
    }

    private static int findMatrixMedian(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int s = 1;
        int e = A.get(n-1).get(m-1);
        final int MEDIAN_ELEMENT_COUNT = n*m/2 +1;

        while(s <= e){
            int mid = s + (e-s)/2;
            int count = 0;

            // count number of elements <= mid for each row . . . . .
            for(int i=0; i<n; i++){
                count += countSmallerNumber(A.get(i), mid, m);
            }
            // count should be greater than N*M/2 + 1
            if(count < MEDIAN_ELEMENT_COUNT)
                s = mid +1;
            else
                e = mid -1;
        }
        return s;
    }

    private static int countSmallerNumber(ArrayList<Integer> A, int mid, int m) {
        int s = 0;
        int e = m-1;

        while(s <= e){
            int midPos = s + (e-s)/2;

            if(A.get(midPos) <= mid){
                s = midPos +1;
            }
            else{
                e = midPos -1;
            }
        }
        return s;
    }
}
```

## 7. BS 2 : Square Root of Integer

**SquareRoot.java**:
```java
public class SquareRoot {

    public static void main(String[] args) {
        int A = 11;

        System.out.println(findSquareRoot(A));
    }

    private static int findSquareRoot(int A) {
        // edge case for A = 0;
        if(A == 0)  return 0;

        int s = 1;
        int e = A;
        int mid = s + (e-s)/2;
        int ans = 1;

        // for optimal power function - use our power function
        //to save from overflow  -->  mid == A/mid

        while(s <= e){
            if(mid <= A/mid){
                ans = mid;
                s = mid+1;
            }
            else{
                e = mid-1;
            }
            mid = s + (e-s)/2;
        }
        return ans;
    }
}
```

## 8. BS 2 : Special Integer
//OPTIMAL SOLUTION - 2 POINTER - T.C - O(n) | complex
//Binary Search  - T.C- O(n lon n)

**SpecialInteger.java**:
```java
public class SpecialInteger {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                2,24,38,25,35,33,43,12,49,35,45,47,5,33
//                1,1000000000
        ));
        int B = 249; //1000000000
        //OPTIMAL SOLUTION - 2 POINTER - T.C - O(n) - DRY RUN ON NOTES
        //Binary Search  - T.C- O(n lon n)
        System.out.println(findTheMaxLengthSubArrayWithSumLessThanEqualTo_B(A,B));
    }

    // TWO Pointer approach
    private static int findTheMaxLengthSubArrayWithSumLessThanEqualTo_B(ArrayList<Integer> A, int B) {
        //base case
        if(B == 0)  return 0;

        int i=0;
        int j=0;
        long sum = 0;
        int window = 0;

        while(j < A.size()){
            sum += A.get(j++);
            if(sum > B){
                while(sum > B){
                    sum -= A.get(i++);
                    window = j-i;
                }
                break;
            }
        }

        while(j<A.size()){
            sum = sum + A.get(j++) - A.get(i++);
            if(sum > B){
                while(sum > B){
                    sum -= A.get(i++);
                    window = j-i;
                }
            }
        }
        return window;
    }
}
```

## 9. BS 2 : Ath Magical Number

**AthMagicalNumber.java**:
```java
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
```

## 10. BS 2 : KthPrice
:star: binary search in unsorted input array, but the search space is sorted.
**KthPrice.java**:
```java
public class KthPrice {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                2, 1, 4, 3, 2
        ));
        int B = 3;

        System.out.println(find_Kth_Number(A, B));

    }

    private static int find_Kth_Number(ArrayList<Integer> A, int B) {
        int min = 0;
        int max = 0;
        for (Integer i : A) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int s = min;
        int e = max;
        int ans = 0;

        //binary search -------------------------------------------
        while(s <= e){
            int mid = s + (e-s)/2;
            int smallerThanK = elementsSmallerThanK(A, mid);

            if(smallerThanK >= B){
                //move to left
                ans = mid;
                e = mid -1;
            }
            else{
                s = mid +1;
            }
        }
        return ans;
    }

    private static int elementsSmallerThanK(ArrayList<Integer> A, int mid) {
        int smallerThanK = 0;
        for(int i : A){
            if(i <= mid)
                smallerThanK++;
        }
        return smallerThanK;
    }
}
```