class Student {
    int rollNo;
    String name;
    int[] marks;
    static String college = "Marwadi University";

    Student(int rollNo, String name, int[] marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    int calculateTotal() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    double calculatePercentage() {
        return calculateTotal() / (double) marks.length;
    }

    void displayResult() {
        System.out.println("\n--- STUDENT DETAILS ---");
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("College: " + college);
        System.out.println("Total: " + calculateTotal());
        System.out.println("Percentage: " + calculatePercentage() + "%");
    }
}

public class Q2 {
    public static void main(String[] args) {
        int[] marks = {85, 90, 78, 88, 95};
        Student s1 = new Student(19, "Rutva", marks);
        s1.displayResult();
    }
}
