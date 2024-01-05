package oops;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private int id;
    private String name;
    private int salary;
    private String department;

    public Employee(int id, String name, int salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }

    public static List<Employee> getEmployeeList(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Harshit", 1000, "development"));
        list.add(new Employee(2, "Richa", 1500, "development"));
        list.add(new Employee(3, "Aastha", 1000, "designer"));
        list.add(new Employee(4, "Manvi", 500, "designer"));
        list.add(new Employee(5, "Shubham", 1500, "Tester"));
        return list;
    }
}
