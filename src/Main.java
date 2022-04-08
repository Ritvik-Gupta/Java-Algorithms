package src;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws NoEmployeeFound, Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number of Employees :\t");
        int numEmp = sc.nextInt();
        ArrayList<Employee> emps = new ArrayList<>(numEmp);

        for (int i = 1; i <= numEmp; ++i) {
            System.out.print("Employee (" + i + ") Name :\t");
            String name = sc.next();
            System.out.print("Employee (" + i + ") Id :\t");
            String emp_id = sc.next();
            System.out.print("Employee (" + i + ") Age :\t");
            int age = sc.nextInt();
            System.out.print("Employee (" + i + ") Joining Date :\t");
            Date joining_date = new SimpleDateFormat("dd/MM/yyyy").parse(sc.next());
            System.out.print("Employee (" + i + ") Salary :\t");
            int salary = sc.nextInt();
            emps.add(new Employee(name, emp_id, age, joining_date, salary));
        }

        sc.close();

        List<Employee> higherSalaryEmps = emps.stream().filter(emp -> emp.salary > 50000).collect(Collectors.toList());

        if (higherSalaryEmps.isEmpty())
            throw new NoEmployeeFound();

        System.out.println("\nHigher Salary Employees\n");
        for (Employee emp : higherSalaryEmps)
            System.out.println(emp);

        emps.sort((a, b) -> a.joining_date.compareTo(b.joining_date));

        System.out.println("\nEmployees Sorted by Experience in the Field\n");
        for (Employee emp : emps)
            System.out.println(emp);
    }
}

class NoEmployeeFound extends Exception {
    NoEmployeeFound() {
        super("No Employee with details found");
    }
}

class Employee {
    String name, emp_id;
    int age, salary;
    Date joining_date;

    Employee(String n, String e, int a, Date j, int s) {
        name = n;
        emp_id = e;
        age = a;
        joining_date = j;
        salary = s;
    }

    public String toString() {
        return String.format("Employee( name=%s, emp_id=%s, age=%d, joining_date=%s, salary=%d )", name, emp_id, age,
                joining_date, salary);
    }
}
