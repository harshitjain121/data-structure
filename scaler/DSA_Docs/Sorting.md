DSA : `SORTING` implementation

1. Sorting 2 : Inversion count in an array
2. Sorting 2 : Largest Number
3. Sorting 2 : Unique Elements

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

## 4. Sorting 2 : Reverse pairs 
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
        System.out.println(countInvertedPairs( A, 0,  A.size()-1));
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