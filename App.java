package Student_class;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws Exception {
		while (true) {
			System.out.println("\n Student Management");
			System.out.print("1 = Create, 2 = Read, 3 = Update ,4 = Delete");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			if (choice < 1 || choice >= 5)
				break;
			switch (choice) {
			case 1:
				System.out.println("id ,name ,email ,city ,phone");
				int id = sc.nextInt();
				sc.nextLine();
				String name = sc.nextLine();
				String email = sc.nextLine();
				String city = sc.nextLine();
				long phone = sc.nextLong();
				Student std = new Student(id, name, email, city, phone);
				Student_Dao.createStudent(std);
				break;

			case 2:
				ArrayList<Student> List = Student_Dao.readAllStudent();
				for (Student s : List) {
					System.out.println(s);
				}
				break;

			case 3:
				System.out.println("id & name");
				id = sc.nextInt();
				sc.nextLine();
				name = sc.nextLine();
				Student_Dao.updateStudent(id, name);
				break;

			case 4:
				System.out.println("id ");
				id = sc.nextInt();
				Student_Dao.deleteStudent(id);
				break;

			}

		}
	}
}
