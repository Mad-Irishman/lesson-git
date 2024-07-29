import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        Developer dev1 = new Developer("Oleg", 1031.41);
        Developer dev2 = new Developer("Bob", 3124.85);
        Developer dev3 = new Developer("Alex", 2131.41);
        Developer dev4 = new Developer("Alice", 3904.85);
        Tester tester1 = new Tester("David", 1312.09);
        Tester tester2 = new Tester("Andrey", 5000);
        Manager manager1 = new Manager("Charlie", 4000);
        Manager manager2 = new Manager("Liza", 1000);
        HR hr = new HR("Katiy", 4000);

        company.addEmployee(dev1);
        company.addEmployee(dev2);
        company.addEmployee(dev3);
        company.addEmployee(dev4);

        company.addEmployee(tester1);
        company.addEmployee(tester2);

        company.addEmployee(manager1);
        company.addEmployee(manager2);


        company.addEmployee(hr);

        System.out.println("All employees----->");
        company.showEmployees();

        System.out.println("Total salary-------> " + company.sumTitalSalary());

    }
}


abstract class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public abstract void responsibilities();
}


class Developer extends Employee {
    public Developer(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void responsibilities() {
        System.out.println(getName() + " is writing code");
    }
}

class Tester extends Employee {
    public Tester(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void responsibilities() {
        System.out.println(getName() + " is testing the software");
    }
}


class HR extends Employee {
    public HR(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void responsibilities() {
        System.out.println(getName() + " is recruits employees");
    }
}

class Manager extends Employee {
    public Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void responsibilities() {
        System.out.println(getName() + " is managing the team");
    }
}

class Company {
    private List<Employee> employees;

    public Company() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public double sumTitalSalary() {
        double sum = 0.0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public void showEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee.getName() + ": $" + employee.getSalary());
        }
    }
}