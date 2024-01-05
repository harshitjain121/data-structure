package Test;

import java.util.*;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String args[]){
        System.out.println(findNonDuplicateIndex("abcdcaf"));
        System.out.println(findNonDuplicateIndex("aaaaa"));
    }


    static int findNonDuplicateIndex(String s){
        //abcdcaf
        HashMap<Character, Integer> map = new HashMap<>();
//        int index = -1;

        //first create the freq hashmap
        for(Character ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        System.out.println(map);

        for(Character ch : s.toCharArray()){
            if(map.get(ch) == 1)
                return s.indexOf(ch);
        }

        return -1;
    }
}



//Prerequisites: Emp(ename,eid, did), Dept(did,dname) tables. get the dname of employee whose ename is "David".
//
//Select d.dname from
//Emp as e join Dept as d
//on e.did == d.did
//where e.ename = "David"


