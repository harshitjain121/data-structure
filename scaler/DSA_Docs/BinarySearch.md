DSA : `Binary Seach` implementation

1. BS 1 : Sorted Insert Position

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
