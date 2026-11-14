import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Q10 {
    private static Connection con;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    ""
            );

            int choice;
            do {
                System.out.println("\\n--- STUDENT CRUD MENU ---");
                System.out.println("1. Insert Student");
                System.out.println("2. Display Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        insertStudent();
                        break;
                    case 2:
                        displayStudents();
                        break;
                    case 3:
                        updateStudent();
                        break;
                    case 4:
                        deleteStudent();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid Choice!");
                }
            } while (choice != 5);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Could not close connection: " + e.getMessage());
            }
            sc.close();
        }
    }

    private static void insertStudent() throws SQLException {
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        String sql = "INSERT INTO Student(name, age, marks) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setDouble(3, marks);
            int rows = ps.executeUpdate();
            System.out.println("Affected Rows: " + rows);
        }
    }

    private static void displayStudents() throws SQLException {
        String sql = "SELECT * FROM Student";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("\\nID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Marks: " + rs.getDouble("marks"));
            }
            if (!found) {
                System.out.println("No student records found.");
            }
        }
    }

    private static void updateStudent() throws SQLException {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();
        System.out.print("Enter New Age: ");
        int age = sc.nextInt();
        System.out.print("Enter New Marks: ");
        double marks = sc.nextDouble();

        String sql = "UPDATE Student SET name=?, age=?, marks=? WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setDouble(3, marks);
            ps.setInt(4, id);
            int rows = ps.executeUpdate();
            System.out.println("Affected Rows: " + rows);
        }
    }

    private static void deleteStudent() throws SQLException {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM Student WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println("Affected Rows: " + rows);
        }
    }
}
