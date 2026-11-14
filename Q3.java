class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    void displayDetails() {
        System.out.println("\n--- MANAGER DETAILS ---");
        super.displayDetails();
        System.out.println("Role: Manager");
    }
}

class Developer extends Employee {
    Developer(String name, double salary) {
        super(name, salary);
    }

    @Override
    void displayDetails() {
        System.out.println("\\n--- DEVELOPER DETAILS ---");
        super.displayDetails();
        System.out.println("Role: Developer");
    }
}

public class Q3 {
    public static void main(String[] args) {
        Manager m = new Manager("RUTVA", 50000);
        Developer d = new Developer("MAHEK", 40000);

        m.displayDetails();
        d.displayDetails();
    }
}
