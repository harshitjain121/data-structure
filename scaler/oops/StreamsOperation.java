package oops;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsOperation {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 5, 6, 6, 6, 7, 8, 9);

//        workOnIntegerList(list);
//        workOnEmployeeData();

        String s = "aabbccc";
        StringBuilder sb = new StringBuilder();
        char currentChar = s.charAt(0);
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == currentChar){
                count++;
                continue;
            }
            else{
                //put to the string builder
                sb.append(currentChar);
                sb.append(count);

                //reset
                count = 1;
                currentChar = s.charAt(i);
            }
        }
        sb.append(currentChar);
        sb.append(count);
        System.out.println(sb);
//        a2b2c2d1
//        HashMap<Character, Integer> map = new HashMap<>();
//        for(int i=0; i<s.length(); i++){
//            map.put(s.charAt(i), map.getOrDefault(map.get(s.charAt(i)), 1)+1);
//        }
//        System.out.println(map);
//        StringBuilder sb = new StringBuilder();
//        int count = 1;
//        for(int i=0; i<s.length(); i++){
//            if(s.charAt(i) ==  s.charAt(i+1)){
//                continue;
//            }
//            else{
//                sb.append(s.charAt(i));
//                sb.append(map.get(s.charAt(i)));
//            }
//
//        }

    }

    private static void workOnIntegerList(List<Integer> list) {
        // find the max value
        Integer maxVal = list.stream()
                .max(Integer::compare)
                .get();
        System.out.println(maxVal);

        //find the min value
        Integer minVal = list.stream()
                .min(Integer::compare)
                .get();
        System.out.println(minVal);

        // find the frequency HashMap
        Map<Integer, Long> freqMap = list.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(freqMap);

        //find the 2nd largest element
        Integer secondLargestVal = list.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println("secondLargestVal : " + secondLargestVal);

        //find the 2nd minimum element
        Integer secondMinimumVal = list.stream()
                .sorted(Integer::compare)
                .skip(1)
                .findFirst()
                .get();
        System.out.println("secondMinimumVal : " + secondMinimumVal);

        //find the sum of all elements in a list
        Integer sum = list.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("toatal sum : " + sum);
    }

    private static void workOnEmployeeData() {
        List<Employee> empList = Employee.getEmployeeList();
        Map<String, List<Employee>> mapOfEmp = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(mapOfEmp);

        Map<String, Set<Employee>> setOfEmp = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toSet()));
        System.out.println(setOfEmp);

        Map<String, List<String>> mapOfEmpNames = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(mapOfEmpNames);

        Map<String, Long> mapOfEmpCountByDepartment = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        System.out.println(mapOfEmpCountByDepartment);

        Map<String, Integer> mapOfTotalSalaryPerDepartment = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary)));
        System.out.println(mapOfTotalSalaryPerDepartment);
    }
}
