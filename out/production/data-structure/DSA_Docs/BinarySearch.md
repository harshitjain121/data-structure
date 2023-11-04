DSA : `Binary Seach` implementation

1. BS 1 : Sorted Insert Position
2. BS 1 : Find a Peak Element
3. BS 1 : Rotated Sorted Array Search
4. BS 1 : Matrix Search
5. BS 1 : :fire: :fire: Median Of Two Sorted Array
6. BS 1 : Matrix Median

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
` :star: MEDIAN >= (N*M)/2 + 1  elements in a matrix`  

**MatrixMedian.java**:
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
