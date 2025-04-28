package Student_class;

import java.sql.*;
import java.util.ArrayList;

public class Student_Dao {
	private static final String url = "jdbc:mysql://localhost:3306/Student_mgmt";
	private static final String user = "root";
	private static final String password = "root";

	// 1. Create student
	public static void createStudent(Student student) {
		String sql = Query.insert;
		try (Connection conn = DB.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			String query = Query.insert;

			stmt.setInt(1, student.getId());
			stmt.setString(2, student.getName());
			stmt.setString(3, student.getEmail());
			stmt.setString(4, student.getCity());
			stmt.setLong(5, student.getPhone());

			stmt.executeUpdate();
			stmt.close();
			System.out.println("Student created successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 2. Read all students
	public static ArrayList<Student> readAllStudent() {
		ArrayList<Student> list = new ArrayList<>();
		String sql = "SELECT * FROM Student";

		try (Connection conn = DB.connect();
				Statement stmt = conn.createStatement();

				ResultSet rs = stmt.executeQuery(sql)) {
			String query = Query.select;

			while (rs.next()) {
				Student student = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("city"), rs.getLong("phone"));
				list.add(student);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// 3. Update student name by id
	public static void updateStudent(int id, String newName) {
		String query = "UPDATE Student SET name = ? WHERE id = ?";

		try (Connection conn = DB.connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
			String query1 = Query.update;
			stmt.setString(1, newName);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
			System.out.println("Student updated successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 4. Delete student by id
	public static void deleteStudent(int id) {
		String sql = "DELETE FROM Student WHERE id = ?";

		try (Connection conn = DB.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			String query = Query.delete;
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Student deleted successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
