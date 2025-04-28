package Student_class;

public class Query {
    static String insert = "INSERT INTO Student (id, name, email, city, phone) VALUES (?, ?, ?, ?, ?)";
    static String update = "UPDATE Student SET name = ? WHERE id = ?";
    static String delete = "DELETE FROM Student WHERE id = ?";
    static String select = "SELECT * FROM Student";
}
