DSA : `Binary Seach` implementation

1. BS 1 : Sorted Insert Position
2. BS 1 : Find a Peak Element
3. BS 1 : Rotated Sorted Array Search
4. BS 1 : Matrix Search

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
